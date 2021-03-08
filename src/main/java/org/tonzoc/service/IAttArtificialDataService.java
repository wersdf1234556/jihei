package org.tonzoc.service;

import org.tonzoc.model.AttArtificialDataModel;
import org.tonzoc.model.support.AttendanceStatModel;
import org.tonzoc.model.support.StatTotalModel;

import java.util.List;

public interface IAttArtificialDataService extends IBaseService<AttArtificialDataModel> {
    List<AttendanceStatModel> statAllByCategoryGuid(String categoryGuid);
    StatTotalModel statAll();
    List<Object> statByTender(String categoryGuid);
    void insertAllArti(String categoryGuid);
//    List<AttendanceStatModel> statArticle(String tenderName);
}
