package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.ProgressWeatherModel;
import org.tonzoc.service.IProgressWeatherService;

@Service("progressWeatherService")
public class ProgressWeatherService extends BaseService<ProgressWeatherModel> implements IProgressWeatherService {
}
