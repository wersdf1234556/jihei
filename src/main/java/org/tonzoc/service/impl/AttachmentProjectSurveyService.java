package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.AttachmentProjectSurveyMapper;
import org.tonzoc.model.AttachmentProjectSurveyModel;
import org.tonzoc.service.IAttachmentProjectSurveyService;

@Service
public class AttachmentProjectSurveyService extends BaseService<AttachmentProjectSurveyModel> implements IAttachmentProjectSurveyService {

    @Autowired
    private AttachmentProjectSurveyMapper attachmentProjectSurveyMapper;
}
