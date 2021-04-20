package org.tonzoc.service;

import org.tonzoc.model.BaidaModel;
import org.tonzoc.model.CameraModel;

import java.util.List;

public interface IBaidaService extends IBaseService<BaidaModel> {

    List<BaidaModel> getStat(String categoryGuid, String projectTypeGuid);
}
