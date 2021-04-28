package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamPersonMapper;
import org.tonzoc.model.BeamPersonGroupModel;
import org.tonzoc.model.BeamPersonModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.service.IBeamPersonGroupService;
import org.tonzoc.service.IBeamPersonService;
import org.tonzoc.service.IPersonService;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service("BeamPersonService")
public class BeamPersonService extends BaseService<BeamPersonModel> implements IBeamPersonService {

    @Autowired
    private BeamPersonMapper beamPersonMapper;

    @Autowired
    private IBeamPersonGroupService beamPersonGroupService;

    @Autowired
    private IPersonService personService;

    // 添加人员
    public void add(BeamPersonModel beamPersonModel){

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("beamGroupGuid", beamPersonModel.getBeamGroupGuid(), "eq"));
        List<BeamPersonGroupModel> list = beamPersonGroupService.list(sqlQueryParams);

        List<String> listPerson = beamPersonMapper.personByTender(beamPersonModel.getTenderGuid());

        for (BeamPersonGroupModel li : list) {

            if (!listPerson.contains(li.getPersonGuid())) {
                PersonModel personModel = personService.get(li.getPersonGuid());

                BeamPersonModel beamPersonModel1 = new BeamPersonModel();
                beamPersonModel1.setBeamGroupGuid(beamPersonModel.getBeamGroupGuid());
                beamPersonModel1.setPersonTypeGuid(personModel.getPersonTypeGuid());
                beamPersonModel1.setPersonMobile(personModel.getMobile());
                beamPersonModel1.setPersonGuid(personModel.getGuid());
                beamPersonModel1.setTenderGuid(personModel.getTenderGuid());
                beamPersonModel1.setBeamGuid(beamPersonModel.getBeamGuid());
                beamPersonModel1.setOperator(beamPersonModel.getOperator());
                beamPersonModel1.setAttTime(beamPersonModel.getAttTime());
                beamPersonModel1.setSortId(beamPersonModel.getSortId());

                this.save(beamPersonModel1);
            }
        }
    }
}
