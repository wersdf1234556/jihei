package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.GradeModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IGradeService extends IBaseService<GradeModel> {

    void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception;
    void uploadTemplate(MultipartFile file, String date) throws Exception;
    
}
