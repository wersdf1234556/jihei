package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.CameraMapper;
import org.tonzoc.model.BaidaModel;
import org.tonzoc.model.CameraModel;
import org.tonzoc.service.IBaidaService;
import org.tonzoc.service.ICameraService;

@Service(value = "baidaService")
public class BaidaService extends BaseService<BaidaModel> implements IBaidaService {

}
