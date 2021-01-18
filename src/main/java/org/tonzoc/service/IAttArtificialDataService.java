package org.tonzoc.service;

import org.tonzoc.model.AttArtificialDataModel;
import org.tonzoc.model.support.AttendanceStatModel;

import java.util.List;

public interface IAttArtificialDataService extends IBaseService<AttArtificialDataModel> {
    List<AttendanceStatModel> statAll(Integer flag);
    List<Object> statByTender(Integer flag);
    void insertAllArti(Integer flag);
}
