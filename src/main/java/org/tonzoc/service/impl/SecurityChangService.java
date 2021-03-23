package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.mapper.SecurityChangMapper;
import org.tonzoc.mapper.SecurityMapper;
import org.tonzoc.mapper.TenderScoreMapper;
import org.tonzoc.model.SecurityChangModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.TenderScoreModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.ISecurityChangService;
import org.tonzoc.service.ISecurityService;
import org.tonzoc.service.ITenderScoreService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("SecurityChangService")
@Transactional
public class SecurityChangService extends BaseService<SecurityChangModel> implements ISecurityChangService {

    @Autowired
    private SecurityChangMapper securityChangMapper;

    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    private TenderScoreMapper tenderScoreMapper;

    @Autowired
    private ITenderScoreService tenderScoreService;

    @Autowired
    private IRedisAuthService redisAuthService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private ApprovalHelper approvalHelper;

    //添加
    @Override
    public void add(SecurityChangModel securityChangModel, MultipartFile[] file, Integer fileType, String accounType) throws Exception {

        SecurityModel securityModel = securityService.get(securityChangModel.getSecurityGuid());
        if (!"submitted".equals(securityModel.getStatus())){

            throw new Exception("当前状态无法添加");
        }
        securityChangModel.setStatus("unSubmit");
        String approvalTenderGuid = approvalHelper.getNextSupervisor(securityChangModel.getChangTenderGuid(), accounType);
        securityChangModel.setApprovalTenderGuid(approvalTenderGuid);
        this.save(securityChangModel);

        if (file != null) {
            securityService.upFiles(file, "", securityChangModel.getGuid(), fileType);
        }

        this.submit(securityChangModel.getGuid());  //添加完直接提交
    }

    //提交
    @Override
    public void submit(String securityChangGuid){
        SecurityChangModel securityChangModel = this.get(securityChangGuid);

        String approvalTime = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if (securityChangModel.getStatus().equals("unSubmit")){

            approvalTime = df.format(new Date());
        }

        securityChangMapper.updateStatus("submitted", approvalTime, securityChangGuid);
        securityService.updateStatus("unFinish", df.format(new Date()), securityChangModel.getSecurityGuid()); // 整改完毕
    }

    //审批
    @Override
    public void approval(String securityChangGuid, Integer flag, String approvalScore) {

        SecurityChangModel securityChangModel = get(securityChangGuid);

        String status = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if (flag == 1){
            // 修改该条状态为已结束, 合格
            status = "finish";
            securityService.updateStatus("finish", df.format(new Date()), securityChangModel.getSecurityGuid()); // 安全表最终审批
            securityMapper.updateApprovalScore(Integer.parseInt(approvalScore), securityChangModel.getSecurityGuid()); // 修改最终分数

            TenderScoreModel tenderScoreModel = new TenderScoreModel();
            tenderScoreModel.setScores(Integer.parseInt(approvalScore));
            tenderScoreModel.setGuid(tenderScoreMapper.guid(securityChangModel.getSecurityGuid()));
            tenderScoreService.update(tenderScoreModel);
        }else if (flag == 2){ // 修改该条状态为已结束, 不合格
            // 修改该条状态为已结束, 不合格
            status = "noFinish";
            securityService.updateStatus("submitted", df.format(new Date()), securityChangModel.getSecurityGuid()); // 安全表最终审批
        }

        securityChangMapper.updateStatus(status, df.format(new Date()), securityChangGuid);
    }

    // 修改时询问是否能修改
    @Override
    public void updateStack(SecurityChangModel securityChangModel, UserModel userModel) throws Exception {

        SecurityChangModel securityChangModel1 = this.get(securityChangModel.getGuid());
        // 施工方未提交时，监理不可改;
        // 施工方提交后，施工方可以改;
        // 监理审批后，施工方不可改;

        if ("noFinish".equals(securityChangModel1.getStatus()) || "finish".equals(securityChangModel1.getStatus())){

            throw new NotMatchException("当前状态无法修改");
        }
    }

    // 删除一条
    @Override
    public void removeStack(String guid, UserModel userModel) throws Exception{

        SecurityChangModel securityChangModel1 = this.get(guid);

        if (!"unSubmit".equals(securityChangModel1.getStatus())){

            throw new NotMatchException("当前状态无法删除");
        }

        this.remove(guid);
    }
}
