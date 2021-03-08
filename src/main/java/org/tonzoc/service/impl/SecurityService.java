package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentSecurityMapper;
import org.tonzoc.mapper.SecurityChangMapper;
import org.tonzoc.mapper.SecurityMapper;
import org.tonzoc.mapper.TenderScoreMapper;
import org.tonzoc.model.*;
import org.tonzoc.service.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Transactional
public class SecurityService extends BaseService<SecurityModel> implements ISecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    private TenderScoreMapper tenderScoreMapper;

    @Autowired
    private SecurityChangMapper securityChangMapper;

    @Autowired
    private AttachmentSecurityMapper attachmentSecurityMapper;

    @Autowired
    private IAttachmentSecurityService attachmentSecurityService;

    @Autowired
    private ITenderScoreService tenderScoreService;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private FileHelper fileHelper;

    // 处理时间
    @Override
    public SecurityModel updateTime(SecurityModel securityModel) throws ParseException {

        if (!securityModel.getCreateDate().equals("") && securityModel.getCreateDate() != null) {

           securityMapper.updateTime( TimeHelper.stringToDate(securityModel.getCreateDate()), securityModel.getGuid());
        }
        securityModel.setSortId(0);
        securityModel.setCreateDate("");
        return securityModel;
    }

    // 上传安全文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String securityGuid, String securityChangGuid, Integer fileType) {

        Map<String, String> map = new HashMap<>();
        intelliSiteProperties.setFileUrl("/安全/");

        // 获取的实际时间
        String[] str = fileHelper.fileUpload(file, new SimpleDateFormat("yyyy-MM-dd").format(new Date()),  "");

        AttachmentSecurityModel attachmentSecurityModel = new AttachmentSecurityModel();
        attachmentSecurityModel.setUrl(str[0]);
        attachmentSecurityModel.setName(str[1]);
        attachmentSecurityModel.setSortId(0);
        attachmentSecurityModel.setSecurityGuid(securityGuid);
        attachmentSecurityModel.setSecurityChangGuid(securityChangGuid);
        attachmentSecurityModel.setFileType(fileType);
        attachmentSecurityService.save(attachmentSecurityModel);

        intelliSiteProperties.setFileUrl("/");
        if (securityGuid != null && !securityGuid.equals("")) {
            map.put("attachmentSecurityGuid", attachmentSecurityMapper.getSecurityGuid(str[0], securityGuid));
        }
        if (securityChangGuid != null && !securityChangGuid.equals("")) {
            map.put("attachmentSecurityGuid", attachmentSecurityMapper.getSecurityGuid(str[0], securityChangGuid));
        }

        return map;
    }

    // 上传多条安全的文件
    @Override
    public void upFiles(MultipartFile[] file, String securityGuid, String securityChangGuid, Integer fileType){
        if (file.length > 0) {
            List<AttachmentSecurityModel> list = new ArrayList<>();
            for (MultipartFile f : file) {
                String[] str = fileHelper.fileUpload(f, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "");

                AttachmentSecurityModel attachmentSecurityModel = new AttachmentSecurityModel();
                attachmentSecurityModel.setUrl(str[0]);
                attachmentSecurityModel.setName(str[1]);
                attachmentSecurityModel.setSortId(0);
                attachmentSecurityModel.setSecurityGuid(securityGuid);
                attachmentSecurityModel.setSecurityChangGuid(securityChangGuid);
                attachmentSecurityModel.setFileType(fileType);

                list.add(attachmentSecurityModel);
            }

            attachmentSecurityService.saveMany(list);
        }
    }

    // 修改状态
    public void updateStatus(String status, String guid){

        securityMapper.updateStatus(status, guid);
    }

    /*// 添加多条并修改分数
    @Override
    public void adds(List<SecurityModel> list) {

        Integer score = securityMapper.score(list.get(0).getDocumentGuid(), list.get(0).getTenderGuid());
        TenderScoreModel tenderScoreModel = tenderScoreMapper.selectByTender(list.get(0).getTenderGuid());
        tenderScoreService.updateScore(tenderScoreModel.getScores(), score);

        this.saveMany(list);
    }*/

    // 安全统计
    @Override
    public List<ReturnModel> securityStatics() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);   // 设置小数最多两位
        numberFormat.setMinimumFractionDigits(2);   // 设置小数最少两位

        List<ReturnModel> list = new ArrayList<>();

        ReturnModel returnModel = new ReturnModel();
        returnModel.setName("下单数量");
        returnModel.setNumber(securityMapper.count());

        ReturnModel returnModel1 = new ReturnModel();
        returnModel1.setName("已整改");
        returnModel1.setNumber(securityMapper.countStatus("1"));

        ReturnModel returnModel2 = new ReturnModel();
        returnModel2.setName("未整改");
        returnModel2.setNumber(securityMapper.countStatus("0"));

        ReturnModel returnModel3 = new ReturnModel();
        returnModel3.setName("合格数");
        returnModel3.setNumber(securityChangMapper.countStatus("1"));

        ReturnModel returnModel4 = new ReturnModel();
        returnModel4.setName("不合格数");
        returnModel4.setNumber(securityChangMapper.countStatus("2"));
        if (returnModel4.getNumber() > 0 || returnModel4.getNumber() > 0) {
            String result = numberFormat.format((1 - ((double)returnModel3.getNumber()  / (double) returnModel1.getNumber())) * 100);
            returnModel4.setProportion(result + "%");
        }else{
            returnModel4.setProportion("0%");
        }

        ReturnModel returnModel5 = new ReturnModel();
        returnModel5.setName("整改通过率");
        returnModel5.setNumber(securityMapper.countStatus("1"));
        if (returnModel3.getNumber() > 0) {
            String result = numberFormat.format(((double)returnModel3.getNumber()  / (double) returnModel1.getNumber()) * 100); // 合格数除已整改
            returnModel5.setProportion(result + "%");
        }else{
            returnModel5.setProportion("0%");
        }

        list.add(returnModel);
        list.add(returnModel3);
        list.add(returnModel1);
        list.add(returnModel2);
        list.add(returnModel4);
        list.add(returnModel5);

        return list;
    }

    // 安全隐患排查
    public List<SecurityModel> unsafeSelect() {

        return securityMapper.unsafeSelect();
    }
}