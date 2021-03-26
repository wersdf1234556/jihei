package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.UserModel;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ISecurityService extends IBaseService<SecurityModel> {

    // 添加一条安全信息
    void add(SecurityModel securityModel, MultipartFile[] file, Integer fileType, String accounType);

    // 上传安全的文件
    Map<String, String> upFile(MultipartFile file, String securityGuid, String securityChangGuid, Integer fileType);

    // 上传多条安全的文件
    void upFiles(MultipartFile[] file, String securityGuid, String securityChangGuid, Integer fileType);

    // 修改状态
    void updateStatus(String status, String approvalTime, String guid);

    // 安全统计
    List<ReturnModel> securityStatics(String date);

    // 安全隐患排查
    List<SecurityModel> unsafeSelect();

    // 提交
    void submit(String securityGuid);

    // 修改时询问是否能修改
    void updateStack(SecurityModel securityGuid) throws Exception;

    // 删除一条
    void removeStack(String guid) throws Exception;

    // 判断当前分数是否超过10天改状态
    void updateIsEffect() throws ParseException;

    // 查询分数
    List<ReturnModel> selectScore() throws ParseException;

    // 标段查询除了未提交的数据
    List<SecurityModel> listByTender(String tenderGuid);

}