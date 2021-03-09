package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.AreaDataModel;
import org.tonzoc.service.IAreaDataService;

@Service(value = "areaDataService")
public class AreaDataService  extends BaseService<AreaDataModel> implements IAreaDataService {
}
