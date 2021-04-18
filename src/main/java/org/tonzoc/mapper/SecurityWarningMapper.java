package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.CameraModel;
import org.tonzoc.model.SecurityWarningModel;

@Component
public interface SecurityWarningMapper extends BaseMapper<SecurityWarningModel> {

}
