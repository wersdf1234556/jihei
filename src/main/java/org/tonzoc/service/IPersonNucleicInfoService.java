package org.tonzoc.service;

import org.tonzoc.model.PersonNucleicInfoModel;

import java.util.List;

public interface IPersonNucleicInfoService  extends IBaseService<PersonNucleicInfoModel> {
    List<String> listAreaCode();
}
