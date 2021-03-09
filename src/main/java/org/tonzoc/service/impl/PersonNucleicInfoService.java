package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.model.AreaDataModel;
import org.tonzoc.model.PersonNucleicInfoModel;
import org.tonzoc.service.IAreaDataService;
import org.tonzoc.service.IPersonNucleicInfoService;

@Service("personNucleicInfoService")
public class PersonNucleicInfoService extends BaseService<PersonNucleicInfoModel> implements IPersonNucleicInfoService {

    @Autowired
    private IAreaDataService areaDataService;

    public void insertStack(PersonNucleicInfoModel personNucleicInfoModel){
        //判断是否是中高风险区出发的isRisk=1
        AreaDataModel areaDataModel = areaDataService.get(personNucleicInfoModel.getDeparturePlaceGuid());
        if (areaDataModel.getFlag()==1){
            personNucleicInfoModel.setIsRisk(1);
        }
        update(personNucleicInfoModel);
    }
}
