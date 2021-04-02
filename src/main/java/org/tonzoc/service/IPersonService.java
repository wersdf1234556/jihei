package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.support.ReturnPersonModel;

import java.util.List;

public interface IPersonService extends IBaseService<PersonModel> {
    List<String> listAreaCode();
    List<PersonModel> listByTenderName(String tenderName);

    PersonModel login(String sign,String password,Integer flag) throws Exception;

    void insertStack(PersonModel personModel) throws Exception;
    void updateStack(PersonModel personModel) throws Exception;
    void upFile(String guid, MultipartFile file, Integer flag);

    // 模板导入
    List<ReturnPersonModel> addPerson(MultipartFile file) throws Exception;
}
