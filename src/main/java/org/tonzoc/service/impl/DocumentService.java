package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.mapper.DocumentMapper;
import org.tonzoc.model.DocumentModel;
import org.tonzoc.model.MemorabiliaModel;
import org.tonzoc.service.IDocumentService;

import java.text.ParseException;

@Service
public class DocumentService extends BaseService<DocumentModel> implements IDocumentService {

    @Autowired
    DocumentMapper documentMapper;

    // 处理时间
    @Override
    public DocumentModel updateTime(DocumentModel documentModel) throws ParseException {

        if (!"".equals(documentModel.getEndDate()) && documentModel.getEndDate() != null) {

            documentMapper.updateEndTime(TimeHelper.stringToDate(documentModel.getEndDate()), documentModel.getGuid());
        }
        if (!"".equals(documentModel.getStartDate()) && documentModel.getStartDate() != null) {

            documentMapper.updateStartTime(TimeHelper.stringToDate(documentModel.getStartDate()), documentModel.getGuid());
        }
        documentModel.setSortId(0);
        documentModel.setStartDate("");
        documentModel.setEndDate("");
        return documentModel;
    }
}