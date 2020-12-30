package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.model.StakeModel;

public interface IStakeService extends IBaseService<StakeModel> {
    void importExcel(MultipartFile file, String tenderGuid) throws NotFoundException;
    void removeMany(String guids);
}
