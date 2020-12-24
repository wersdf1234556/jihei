package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.service.IAdvertisingVideoService;

@Service(value = "advertisingVideoService")
public class AdvertisingVideoService extends BaseService<AdvertisingVideoModel> implements IAdvertisingVideoService {
}
