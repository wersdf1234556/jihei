package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.PersonModel;

import java.util.List;

public interface IPersonService extends IBaseService<PersonModel> {
    List<PersonModel> listByTenderName(String tenderName);

    PersonModel login(String sign,String password,Integer flag) throws Exception;

    void insertStack(PersonModel personModel) throws Exception;
    void updateStack(PersonModel personModel) throws Exception;
    void upFile(String guid, MultipartFile file, Integer flag);
}
