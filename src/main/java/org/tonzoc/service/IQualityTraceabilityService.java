package org.tonzoc.service;

import org.tonzoc.model.QualityTraceabilityModel;

import java.util.Map;


public interface IQualityTraceabilityService extends IBaseService<QualityTraceabilityModel> {

    // 生成二维码
    Map<String, String> qrcode(String orderNo);

}
