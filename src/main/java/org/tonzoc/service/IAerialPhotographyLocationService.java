<<<<<<< HEAD
package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.model.AerialPhotographyLocationModel;

public interface IAerialPhotographyLocationService extends IBaseService<AerialPhotographyLocationModel> {

    void importExcel(MultipartFile file, String aerialPhotographyGuid) throws NotFoundException;
}
=======
package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.model.AerialPhotographyLocationModel;

public interface IAerialPhotographyLocationService extends IBaseService<AerialPhotographyLocationModel> {

    void importExcel(MultipartFile file, String aerialPhotographyGuid) throws NotFoundException;
}
>>>>>>> origin/master
