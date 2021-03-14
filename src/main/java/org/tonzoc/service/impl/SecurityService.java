package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotMatchException;
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
    private IRedisAuthService redisAuthService;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private FileHelper fileHelper;

    // 处理时间
    @Override
    public SecurityModel updateTime(SecurityModel securityModel) throws ParseException {

        /*if (!securityModel.getCreateDate().equals("") && securityModel.getCreateDate() != null) {

           securityMapper.updateTime( TimeHelper.stringToDate(securityModel.getCreateDate()), securityModel.getGuid());
        }
        securityModel.setSortId(0);
        securityModel.setCreateDate("");*/
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
    public void updateStatus(String status, String approvalTime, String currentTenderGuid, String guid){

        securityMapper.updateStatus(status, approvalTime, currentTenderGuid, guid);
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
    @Override
    public List<SecurityModel> unsafeSelect() {

        return securityMapper.unsafeSelect();
    }

    //提交
    @Override
    public void submit(String securityGuid, String currentTenderGuid){
        SecurityModel securityModel = this.get(securityGuid);
        String approvalTime = "";
        if (securityModel.getStatus().equals("unSubmitted")){

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            approvalTime = df.format(new Date());
        }
        securityMapper.updateStatus("submitted", approvalTime, currentTenderGuid, securityGuid);
    }

    // 多条提交
    @Override
    public void batchApproval(String securityGuid, String currentTenderGuid, Integer flag) {
        String[] split = securityGuid.split(","); // 以逗号分割
        for (String primaryKey:split){
            if (flag == 0) {// 提交

                this.submit(primaryKey, currentTenderGuid);
            }
        }
    }

    // 修改时询问是否能修改
    @Override
    public void updateStack(SecurityModel securityModel, UserModel userModel) throws Exception {

        SecurityModel securityModel1 = this.get(securityModel.getGuid());
        //监理未提交时，施工单位不能添加新表；
        //且管理员可随时能改；
        //监理提交后，监理可改
        //结束审批后，监理不可改
        if (!userModel.getTenderManage().equals("*")){ // 不是管理员

            if (!userModel.getTenderGuid().equals(securityModel1.getTenderGuid()) && securityModel1.getStatus().equals("unSubmit")){

                throw new NotMatchException("您无法修改");
            }
            if(securityModel1.getStatus().equals("finish")){

                throw new NotMatchException("该数据已结束审批，无法修改");
            }
        }
    }

    // 删除一条
    @Override
    public void removeStack(String guid, UserModel userModel) throws Exception{

        SecurityModel securityModel1 = this.get(guid);
        if (!userModel.getTenderManage().equals("*")){ // 不是管理员

            if (!userModel.getTenderGuid().equals(securityModel1.getTenderGuid()) && securityModel1.getStatus().equals("unSubmit")){

                throw new NotMatchException("您无法删除"); // 施工单位不能删除
            }
            if(securityModel1.getStatus().equals("finish")){

                throw new NotMatchException("该数据已结束审批，无法删除");
            }
        }
        this.remove(guid);
    }

    // 循环删除
    @Override
    public void batchRemoveStack(String guids, UserModel userModel) throws Exception{
        if (guids == null){

            throw new NotFoundException("未删除");
        }
        String[] split = guids.split(",");// 以逗号分割
        for (String primaryKey:split){

            removeStack(primaryKey, userModel);
        }
    }

    // 判断当前分数是否超过10天改状态
    public void updateIsEffect(Date oldDate){

        long end = new Date().getTime(); // 当前时间
        long createDate = oldDate.getTime(); // 创建时间
        long start = end - 24*60*60*10;

//        Calendar date = Calendar.getInstance();
//        date.setTime(nowTime);
//
//        Calendar begin = Calendar.getInstance();
//        begin.setTime(beginTime);
//
//        Calendar end = Calendar.getInstance();
//        end.setTime(new Date());
//
//        if (date.after(begin) && date.before(end)) {
//            return true;
//        } else {
//            return false;
//        }

    }
}