package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.mapper.*;
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
    private IRedisAuthService redisAuthService;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private ApprovalHelper approvalHelper;

    // 添加一条安全信息
    public void add(SecurityModel securityModel, MultipartFile[] file, Integer fileType, String accounType) {

        securityModel.setStatus("unSubmit");
        String approvalTenderGuid = approvalHelper.getNextSupervisor(securityModel.getChangTenderGuid(), accounType);
        securityModel.setApprovalTenderGuid(approvalTenderGuid);
        this.save(securityModel);

        TenderScoreModel tenderScoreModel = new TenderScoreModel();
        tenderScoreModel.setSecurityGuid(securityModel.getGuid());
        tenderScoreModel.setScores(securityModel.getDefaultScore());
        tenderScoreModel.setTenderGuid(securityModel.getChangTenderGuid());
        tenderScoreService.save(tenderScoreModel);

        if (file != null) {
            this.upFiles(file, securityModel.getGuid(), "", fileType);
        }
    }

    // 上传安全文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String securityGuid, String securityChangGuid, Integer fileType) {

        Map<String, String> map = new HashMap<>();
        intelliSiteProperties.setFileUrl("/安全/");

        // 获取的实际时间
        String[] str = fileHelper.fileUpload(file, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "");

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
    public void upFiles(MultipartFile[] file, String securityGuid, String securityChangGuid, Integer fileType) {
        if (file.length > 0) {
            intelliSiteProperties.setFileUrl("/安全/");
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
            intelliSiteProperties.setFileUrl("/");
        }
    }

    // 修改状态
    @Override
    public void updateStatus(String status, String approvalTime, String guid) {

        securityMapper.updateStatus(status, approvalTime, guid);
    }

    // 安全统计
    @Override
    public List<ReturnModel> securityStatics(String date) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);   // 设置小数最多两位
        numberFormat.setMinimumFractionDigits(2);   // 设置小数最少两位

        List<ReturnModel> list = new ArrayList<>();

        ReturnModel returnModel = new ReturnModel();
        returnModel.setName("下单数量");
        ReturnModel returnModel1 = new ReturnModel();
        returnModel1.setName("已整改");
        ReturnModel returnModel2 = new ReturnModel();
        returnModel2.setName("未整改");
        ReturnModel returnModel3 = new ReturnModel();
        returnModel3.setName("合格数");
        ReturnModel returnModel4 = new ReturnModel();
        returnModel4.setName("不合格数");
        ReturnModel returnModel5 = new ReturnModel();
        returnModel5.setName("合格率");

        if (date == null || "".equals(date) || "全部".equals(date)) {

            returnModel.setNumber(securityMapper.count());
            returnModel1.setNumber(securityMapper.countStatus("finish") + securityMapper.countStatus("unFinish"));
            returnModel2.setNumber(securityMapper.countStatus("submitted") + securityMapper.countStatus("unSubmitted"));
            returnModel3.setNumber(securityMapper.countStatus("finish"));
            returnModel4.setNumber(securityMapper.countStatus("unFinish"));
        }else {

            returnModel.setNumber(securityMapper.countByDate(date));
            returnModel1.setNumber(securityMapper.countStatusByDate("finish", date) + securityMapper.countStatusByDate("unFinish", date));
            returnModel2.setNumber(securityMapper.countStatusByDate("submitted", date) + securityMapper.countStatusByDate("unSubmitted", date));
            returnModel3.setNumber(securityMapper.countStatusByDate("finish", date));
            returnModel4.setNumber(securityMapper.countStatusByDate("unFinish", date));
        }

        if (returnModel1.getNumber() > 0) {
            String result = numberFormat.format((1 - ((double) returnModel3.getNumber() / (double) returnModel1.getNumber())) * 100);
            returnModel4.setProportion(result + "");
        } else {
            returnModel4.setProportion("0");
        }

        if (returnModel1.getNumber() > 0) {
            String result = numberFormat.format(((double) returnModel3.getNumber() / (double) returnModel1.getNumber()) * 100); // 合格数除已整改
            returnModel3.setProportion(result + "");
        } else {
            returnModel3.setProportion("0");
        }

        returnModel5.setNumber(returnModel3.getNumber());
        returnModel5.setProportion(returnModel3.getProportion());
        list.add(returnModel);
        list.add(returnModel3);
        list.add(returnModel1);
        list.add(returnModel2);
        list.add(returnModel4);
        list.add(returnModel5);

        return list;
    }

    // 安全隐患排查
    @Override
    public List<SecurityModel> unsafeSelect() {

        return securityMapper.unsafeSelect();
    }

    //提交
    @Override
    public void submit(String securityGuid) {
        SecurityModel securityModel = this.get(securityGuid);
        String approvalTime = "";
        if (securityModel.getStatus().equals("unSubmitted")) {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            approvalTime = df.format(new Date());
        }
        securityMapper.updateStatusAndTender("submitted", approvalTime, securityGuid);
    }

    // 修改时询问是否能修改
    @Override
    public void updateStack(SecurityModel securityModel) throws Exception {

        SecurityModel securityModel1 = this.get(securityModel.getGuid());
        // 监理未提交时，施工单位看不见;
        // 监理提交后，不可改

        if (!"unSubmit".equals(securityModel1.getStatus())) {

            throw new NotMatchException("当前状态无法修改");
        }
    }

    // 删除一条
    @Override
    public void removeStack(String guid) throws Exception {

        SecurityModel securityModel1 = this.get(guid);

        if (!"unSubmit".equals(securityModel1.getStatus())) {

            throw new NotMatchException("当前状态无法删除");
        }

        this.remove(guid);
    }

    // 判断当前分数超过10天改状态
    public void updateIsEffect() throws ParseException {
        List<SecurityModel> list = tenderScoreMapper.securityByIsEffect();
        for (SecurityModel li: list) {

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -10);
            long start = calendar.getTime().getTime(); // 十天前的时间
            long end = new Date().getTime(); // 当前时间

            long createDate = TimeHelper.stringToDate(li.getApprovalTime()).getTime(); // 创建时间

            if(start > createDate || createDate > end) { // 改变状态

                tenderScoreMapper.updateScore("2" , li.getGuid());
            }
        }
    }

    // 查询分数
    public List<ReturnModel> selectScore() {

        List<ReturnModel> list1 = tenderScoreMapper.tenderScores();

        for (ReturnModel li: list1) {

            li.setNumber(100 - li.getNumber());
        }

        return list1;
    }
}