package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.AttachmentSecurityMapper;
import org.tonzoc.model.AttachmentSecurityModel;
import org.tonzoc.service.IAttachmentSecurityService;

@Service
public class AttachmentSecurityService extends BaseService<AttachmentSecurityModel> implements IAttachmentSecurityService {

    @Autowired
    private AttachmentSecurityMapper attachmentSecurityMapper;
}
