package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tonzoc.mapper.BeamPedestalMapper;
import org.tonzoc.mapper.BeamPersonMapper;
import org.tonzoc.model.BeamPersonGroupModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.service.IBeamPersonGroupService;
import org.tonzoc.service.IPersonService;

@Service("BeamPersonGroupService")
@Transactional
public class BeamPersonGroupService extends BaseService<BeamPersonGroupModel> implements IBeamPersonGroupService {

    @Autowired
    private BeamPedestalMapper beamPedestalMapper;

    @Autowired
    private IPersonService personService;

    @Autowired
    private BeamPersonMapper beamPersonMapper;

    // 添加
    @Override
    public void add(BeamPersonGroupModel beamPersonGroupModel) {

        String[] str = beamPersonGroupModel.getPersonGuid().split(",");
        int isGroup = 1;
        for(String s: str) {

            PersonModel personModel = personService.get(s);
            BeamPersonGroupModel beamPersonGroupModel1 = new BeamPersonGroupModel();
            beamPersonGroupModel1.setPersonTypeGuid(personModel.getPersonTypeGuid());
            beamPersonGroupModel1.setPersonGuid(s);
            beamPersonGroupModel1.setName(beamPersonGroupModel.getName());
            beamPersonGroupModel1.setBeamGroupGuid(beamPersonGroupModel.getBeamGroupGuid());

            PersonModel personModel1 = new PersonModel();
            personModel1.setGuid(s);
            personModel1.setIsGroup(isGroup);
            personService.update(personModel1);

            this.save(beamPersonGroupModel1);
        }
    }

    // 删除
    @Override
    public void delete(String guid) {

        BeamPersonGroupModel beamPersonGroupModel = this.get(guid);
        beamPersonMapper.deleteByPerson(beamPersonGroupModel.getPersonGuid()); // 删除梁人表的人

        int isGroup = 0;
        PersonModel personModel = new PersonModel();
        personModel.setGuid(beamPersonGroupModel.getPersonGuid());
        personModel.setIsGroup(isGroup);
        personService.update(personModel);

        this.remove(guid);
    }

    // 批量删除
    @Override
    public void deletes(String guids) {

        String[] str = guids.split(",");
        for (String s: str) {

            this.delete(s);
        }
    }
}
