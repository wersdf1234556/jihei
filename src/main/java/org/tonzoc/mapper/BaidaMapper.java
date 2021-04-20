package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.tonzoc.model.BaidaModel;
import org.tonzoc.model.CameraModel;
import org.tonzoc.provider.BaidaProvider;

import java.util.List;

@Component
public interface BaidaMapper extends BaseMapper<BaidaModel> {
    @SelectProvider(type = BaidaProvider.class, method = "getStat")
    List<BaidaModel> getStat(String categoryGuid, String projectTypeGuid);
}
