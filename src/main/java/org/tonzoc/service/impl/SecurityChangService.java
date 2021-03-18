package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.mapper.SecurityChangMapper;
import org.tonzoc.model.SecurityChangModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.ISecurityChangService;
import org.tonzoc.service.ISecurityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("SecurityChangService")
@Transactional
public class SecurityChangService extends BaseService<SecurityChangModel> implements ISecurityChangService {

    @Autowired
    private SecurityChangMapper securityChangMapper;

    @Autowired
    private IRedisAuthService redisAuthService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private ApprovalHelper approvalHelper;

    // 处理时间
    @Override
    public SecurityChangModel updateTime(SecurityChangModel securityChangModel) throws ParseException {

       /* if (securityChangModel.getChangDate() != null && !securityChangModel.getChangDate().equals("")) {

            securityChangMapper.updateChangTime(TimeHelper.stringToDate(securityChangModel.getChangDate()), securityChangModel.getGuid());
        }

        if (securityChangModel.getCheckDate() != null && !securityChangModel.getCheckDate().equals("")) {

            securityChangMapper.updateCheckTime(TimeHelper.stringToDate(securityChangModel.getCheckDate()), securityChangModel.getGuid());
        }
        securityChangModel.setSortId(0);
        securityChangModel.setChangDate("");
        securityChangModel.setCheckDate("");*/
        return securityChangModel;
    }

    //提交
    @Override
    public void submit(String securityChangGuid){
        SecurityChangModel securityChangModel = this.get(securityChangGuid);
        String nextTenderGuids = approvalHelper.getNextTender(securityChangModel.getCurrentTenderGuid());

        String approvalTime = "";
        if (securityChangModel.getStatus().equals("unSubmitted")){

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            approvalTime = df.format(new Date());
        }

        securityChangMapper.updateStatus("submitted", approvalTime, nextTenderGuids, securityChangGuid);
    }

    //审批
    @Override
    public void approval(String securityChangGuid, Integer flag) {

        SecurityChangModel securityChangModel = get(securityChangGuid);

        String supervisorGuid = approvalHelper.getNextTender(securityChangModel.getTenderGuid());
        String status = "";
        String currentTenderGuid = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if (flag == 1){
            //修改该条状态为已结束
            status = "finish";
            currentTenderGuid = "*";
            securityService.updateStatus("finish", df.format(new Date()), "*" , securityChangModel.getSecurityGuid()); // 安全表最终审批
        }else if (flag == 2){
            if (securityChangModel.getCurrentTenderGuid().equals("*") && securityChangModel.getStatus().equals("finish")){

                status = "submitted";
                currentTenderGuid = supervisorGuid;
                securityService.updateStatus("unFinish", df.format(new Date()), securityChangModel.getTenderGuid() , securityChangModel.getSecurityGuid()); // 取消安全表最终审批
            }
        }

        securityChangMapper.updateStatus(status, df.format(new Date()), currentTenderGuid, securityChangGuid);
    }

    // 多条提交或审批
    @Override
    public void batchApproval(String securityChangGuids, Integer flag) {
        String[] split = securityChangGuids.split(",");//以逗号分割
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
    public void updateStack(SecurityChangModel securityChangModel, UserModel userModel) throws Exception {

        SecurityChangModel securityChangModel1 = this.get(securityChangModel.getGuid());
        //施工方未提交时，监理不可改；
        //且管理员可随时能改；
        //施工方提交后，施工方、监理都可改
        //结束审批后，施工方、监理都不可改
        if (!userModel.getTenderManage().equals("*")){ // 不是管理员

            if (!userModel.getTenderGuid().equals(securityChangModel1.getTenderGuid()) && securityChangModel1.getStatus().equals("unSubmit")){

                throw new NotMatchException("该数据未被提交，无法修改");
            }
            if(securityChangModel1.getStatus().equals("finish")){

                throw new NotMatchException("该数据已结束审批，无法修改");
            }
        }
    }

    // 删除一条
    @Override
    public void removeStack(String guid, UserModel userModel) throws Exception{

        SecurityChangModel securityChangModel1 = this.get(guid);
        if (!userModel.getTenderManage().equals("*")){ // 不是管理员

            if (!userModel.getTenderGuid().equals(securityChangModel1.getTenderGuid()) && securityChangModel1.getStatus().equals("unSubmit")){

                throw new NotMatchException("该数据未被提交，无法删除");
            }
            if(securityChangModel1.getStatus().equals("finish")){

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
        String[] split = guids.split(",");//以逗号分割
        for (String primaryKey:split){

            removeStack(primaryKey, userModel);
        }
    }
}
