package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.model.*;
import org.tonzoc.model.support.ReturnQtbModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IQualityTraceabilityService extends IBaseService<QualityTraceabilityModel> {

    // 添加
    void add(QualityTraceabilityModel qualityTraceabilityModel, String accounType) throws Exception;

    // 查询字符串转时间
    List<QualityTraceabilityModel> selected(List<QualityTraceabilityModel> list);

    // 处理时间
    QualityTraceabilityModel updateTime(QualityTraceabilityModel QualityTraceabilityModel) throws ParseException;

    // 生成二维码
    Map<String, String> qrcode(String qualityTraceabilityGuid);

    // 上传多个质量追溯文件
    void upFiles(MultipartFile[] file, String qualityTraceabilityGuid, String fileType);

    // 上传质量追溯文件
    void upFile(MultipartFile file, String qualityTraceabilityGuid, String fileType);

    // 按照名称模糊查询的功能
    List<AttachmentModel> selectLikeName(String name, String qualityTraceabilityGuid);

    // 将质量表中的sortId同步
    void updateSortId();

    // 追溯统计
    List<ReturnModel> traceabilityCount();

    // 标段统计
    List<TenderModel> tenderCount();

    // 修改时是否包含
    Boolean containGuid(String guid, String name);

    // 添加时是否包含
    Boolean containName(String name);

    // 提交
    void submit(String qualityTraceabilityGuid);

    // 审批
    void approval(String qualityTraceabilityGuid, Integer flag, String currentTenderGuid);

    // 多条提交或审批
    void batchApproval(String qualityTraceabilityGuid, Integer flag, String currentTenderGuid);

    // 修改时询问是否能修改
    void updateStack(QualityTraceabilityModel qualityTraceabilityModel, UserModel userModel) throws Exception;

    // 删除一条
    void removeStack(String guid, UserModel userModel) throws Exception;

    // 循环删除
    void batchRemoveStack(String guids, UserModel userModel) throws Exception;

    // 标段和文件数量
    List<ReturnModel> tenderAndNumber(Integer typeId);

    // A B标段和文件数量的另一种格式
    List<ReturnQtbModel> tenderAndNumbers(String tenderName);

    // Z S标段和文件数量的另一种格式
    List<ReturnQtbModel> currentTenderAndNumbers(String currentTenderName);
}
