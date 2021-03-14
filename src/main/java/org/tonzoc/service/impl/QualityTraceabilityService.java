package org.tonzoc.service.impl;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.QualityTraceabilityMapper;
import org.tonzoc.mapper.TenderMapper;
import org.tonzoc.model.*;
import org.tonzoc.service.*;
import org.tonzoc.support.param.SqlQueryParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private IRedisAuthService redisAuthService;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private ApprovalHelper approvalHelper;

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
    public QualityTraceabilityModel updateTime(QualityTraceabilityModel qualityTraceabilityModel) throws ParseException {

        if (!qualityTraceabilityModel.getCurrentDate().equals("") && qualityTraceabilityModel.getCurrentDate() != null) {

            qualityTraceabilityMapper.updateTime(TimeHelper.stringToDate(qualityTraceabilityModel.getCurrentDate()), qualityTraceabilityModel.getGuid());
        }
        qualityTraceabilityModel.setSortId(0);
        qualityTraceabilityModel.setCurrentDate("");
        return qualityTraceabilityModel;
    }

    // 生成二维码
    @Override
    public Map<String, String> qrcode(String qualityTraceabilityGuid) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String address = request.getLocalPort() + ""; // 获取端口号

        String payUrl = intelliSiteProperties.getIp() + address + "/attachment?guid =" + qualityTraceabilityGuid; // 二维码存的内容
        String guid = fileHelper.newGUID(); // 二维码名称

        try {
            fileHelper.generateQRCodeImage(payUrl, 380, 380, guid + ".png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String oldGuid = attachmentMapper.getGuid(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + guid + ".png", "");
//        if (oldGuid != null) {
//            attachmentService.remove(oldGuid);
//        }
        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setGuid(guid);
        attachmentModel.setUrl(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + guid + ".png");
        attachmentModel.setName(guid + ".png");
        attachmentModel.setSortId(0);
        attachmentModel.setQualityTraceabilityGuid("");
        attachmentModel.setFileType("");
        attachmentService.save(attachmentModel);

        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.guid(guid + ".png"));
        return map;
    }

    // 上传多个质量追溯文件
    @Override
    public void upFiles(MultipartFile[] file, String qualityTraceabilityGuid, String fileType) {

        intelliSiteProperties.setFileUrl("/质量追溯/");
        attachmentService.upFiles(file, qualityTraceabilityGuid, fileType);
        intelliSiteProperties.setFileUrl("/");
    }

    // 上传质量追溯文件
    @Override
    public void upFile(MultipartFile file, String qualityTraceabilityGuid, String fileType) {

        intelliSiteProperties.setFileUrl("/质量追溯/");
        attachmentService.upFile(file, qualityTraceabilityGuid, fileType);
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

    // 修改时是否包含
    @Override
    public Boolean containGuid(String guid, String name) {
        List<String> list = qualityTraceabilityMapper.listGuid(guid);
        if (list.contains(name)) {
            return true;
        }
        return false;
    }

    // 添加时是否包含
    @Override
    public Boolean containName(String name) {
        List<String> list = qualityTraceabilityMapper.listName(name);
        if (list.contains(name)) {
            return true;
        }
        return false;
    }

    //提交
    @Override
    public void submit(String qualityTraceabilityGuid){
        QualityTraceabilityModel qualityTraceabilityModel = this.get(qualityTraceabilityGuid);
        String nextTenderGuids = approvalHelper.getNextTender(qualityTraceabilityModel.getCurrentTenderGuid());

        String approvalTime = "";
        if (qualityTraceabilityModel.getStatus().equals("unSubmitted")){

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            approvalTime = df.format(new Date());
        }

        qualityTraceabilityMapper.updateStatus("submitted", approvalTime, nextTenderGuids, qualityTraceabilityGuid);
    }

    //审批
    @Override
    public void approval(String qualityTraceabilityGuid, Integer flag) {

        QualityTraceabilityModel qualityTraceabilityModel = get(qualityTraceabilityGuid);

        String supervisorGuid = approvalHelper.getNextTender(qualityTraceabilityModel.getTenderGuid());
        String status = "";
        String currentTenderGuid = "";
        if (flag == 1){
            //修改该条状态为已结束
            status = "finish";
            currentTenderGuid = "*";
        }else if (flag == 2){
            if (qualityTraceabilityModel.getCurrentTenderGuid().equals("*") && qualityTraceabilityModel.getStatus().equals("finish")){

                status = "submitted";
                currentTenderGuid = supervisorGuid;
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        qualityTraceabilityMapper.updateStatus(status, df.format(new Date()), currentTenderGuid, qualityTraceabilityGuid);
    }

    // 多条提交或审批
    @Override
    public void batchApproval(String qualityTraceabilityModels, Integer flag) {
        String[] split = qualityTraceabilityModels.split(",");//以逗号分割
        for (String primaryKey:split){
            if (flag == 0){ // 提交

                this.submit(primaryKey);
            }else if (flag == 1 || flag == 2){

                this.approval(primaryKey, flag);
            }
        }
    }

    // 修改时询问是否能修改
    @Override
    public void updateStack(QualityTraceabilityModel qualityTraceabilityModel, UserModel userModel) throws Exception {
        QualityTraceabilityModel qualityTraceabilityModel1 = this.get(qualityTraceabilityModel.getGuid());
        //施工方未提交时，监理不可改；
        //且管理员可随时能改；
        //施工方提交后，施工方、监理都可改
        //结束审批后，施工方、监理都不可改
        if (!userModel.getTenderManage().equals("*")){ // 不是管理员

            if (!userModel.getTenderGuid().equals(qualityTraceabilityModel1.getTenderGuid()) && qualityTraceabilityModel1.getStatus().equals("unSubmit")){

                throw new NotMatchException("该数据未被提交，无法修改");
            }
            if(qualityTraceabilityModel1.getStatus().equals("finish")){

                throw new NotMatchException("该数据已结束审批，无法修改");
            }
        }
    }

    // 删除一条
    @Override
    public void removeStack(String guid, UserModel userModel) throws Exception{
        QualityTraceabilityModel qualityTraceabilityModel1 = this.get(guid);
        if (!userModel.getTenderManage().equals("*")){ // 不是管理员

            if (!userModel.getTenderGuid().equals(qualityTraceabilityModel1.getTenderGuid()) && qualityTraceabilityModel1.getStatus().equals("unSubmit")){

                throw new NotMatchException("该数据未被提交，无法删除");
            }
            if(qualityTraceabilityModel1.getStatus().equals("finish")){

                throw new NotMatchException("该数据已结束审批，无法删除");
            }
        }
        this.remove(guid);
        attachmentService.deleteFile(guid);
    }

    // 循环删除
    @Override
    public void batchRemoveStack(String guids, UserModel userModel) throws Exception{
        if (guids == null){

            throw new NotFoundException("未删除");
        }
        String[] split = guids.split(",");//以逗号分割
        for (String primaryKey:split){

            removeStack(primaryKey, userModel);
            attachmentService.deleteFile(guids);
        }
    }
}
