package org.tonzoc.service;

import org.tonzoc.model.AreaDataModel;

import java.util.List;

public interface IAreaDataService extends IBaseService<AreaDataModel>{
    List<AreaDataModel> listWithLevel(String parentCode) throws Exception;
    List<AreaDataModel> listByCode(String code);
}
