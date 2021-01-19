package org.tonzoc.service.impl;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.QualityTraceabilityMapper;
import org.tonzoc.mapper.TenderMapper;
import org.tonzoc.model.*;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IMachineService;
import org.tonzoc.service.IQualityTraceabilityService;
import org.tonzoc.service.ISubTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QualityTraceabilityService extends BaseService<QualityTraceabilityModel> implements IQualityTraceabilityService {

    @Autowired
    private QualityTraceabilityMapper qualityTraceabilityMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private TenderMapper tenderMapper;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private ISubTypeService subTypeService;

    @Autowired
    private IMachineService machineService;

    @Autowired
    private FileHelper fileHelper;

    // 查询字符串转时间
    @Override
    public List<QualityTraceabilityModel> selected(List<QualityTraceabilityModel> list) {
        if (list.size() > 0) {
            for (QualityTraceabilityModel m : list) {

                m.setCurrentDate(TimeHelper.dateToString(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public QualityTraceabilityModel updateTime(QualityTraceabilityModel mapInformationModel) throws ParseException {

        if (!mapInformationModel.getCurrentDate().equals("") && mapInformationModel.getCurrentDate() != null) {

            qualityTraceabilityMapper.updateTime(TimeHelper.stringToDate(mapInformationModel.getCurrentDate()), mapInformationModel.getGuid());
        }
        mapInformationModel.setSortId(0);
        mapInformationModel.setCurrentDate("");
        return mapInformationModel;
    }

    // 生成二维码
    @Override
    public Map<String, String> qrcode(String subTypeGuid) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String address = request.getLocalPort() + ""; // 获取端口号

        String payUrl = intelliSiteProperties.getIp() + address + "/attachment?subTypeGuid =" + subTypeGuid; // 二维码存的内容
        String guid = fileHelper.newGUID(); // 二维码名称

        try {
            fileHelper.generateQRCodeImage(payUrl, 380, 380, guid + ".png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String oldGuid = attachmentMapper.getGuid(guid + ".png", "");
        if (oldGuid != null) {
            attachmentService.remove(oldGuid);
        }
        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setGuid(guid);
        attachmentModel.setUrl(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + guid + ".png");
        attachmentModel.setName(guid + ".png");
        attachmentModel.setSortId(0);
        attachmentModel.setQualityTraceabilityGuid("");
        attachmentService.save(attachmentModel);

        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.getGuid(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + guid + ".png", ""));
        return map;
    }

    // 上传多个质量追溯文件
    @Override
    public void upFiles(MultipartFile[] file, String qualityTraceabilityGuid) {

        intelliSiteProperties.setFileUrl("/质量追溯/");
        attachmentService.upFiles(file, qualityTraceabilityGuid);
        intelliSiteProperties.setFileUrl("/");
    }

    // 上传质量追溯文件
    @Override
    public void upFile(MultipartFile file, String qualityTraceabilityGuid) {

        intelliSiteProperties.setFileUrl("/质量追溯/");
        attachmentService.upFile(file, qualityTraceabilityGuid);
        intelliSiteProperties.setFileUrl("/");
    }

    // 按照名称模糊查询的功能
    public List<AttachmentModel> selectLikeName(String name, String qualityTraceabilityGuid){

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("qualityTraceabilityGuid", qualityTraceabilityGuid, "eq"));
        if (!"".equals(name) && name != null) {
            sqlQueryParams.add(new SqlQueryParam("name", name, "like"));
        }

        return attachmentService.list(sqlQueryParams);
    }

    // 将质量表中的sortId同步
    public void updateSortId(){

        List<SubTypeModel> list = subTypeService.list(new ArrayList<>());
        for (SubTypeModel li: list) {

            qualityTraceabilityMapper.updateSortId(li.getGuid());
        }
    }

    // 追溯统计
    public List<ReturnModel> traceabilityCount(){

        Integer count = qualityTraceabilityMapper.count();
        List<ReturnModel> list = qualityTraceabilityMapper.traceabilityCount();

        return machineService.machinePublic(count,list);
    }

    // 标段统计
    public List<TenderModel> tenderCount(){

        List<TenderModel> list1 = tenderMapper.list();

        for (TenderModel li: list1) {

            List<ReturnModel> list2 = qualityTraceabilityMapper.tenderCount(li.getGuid());
            li.setList(list2);
        }

        return list1;
    }
}
