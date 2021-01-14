package org.tonzoc.service;

import org.tonzoc.model.DocumentModel;

import java.text.ParseException;

public interface IDocumentService extends IBaseService<DocumentModel> {

    // 处理时间
    DocumentModel updateTime (DocumentModel documentModel) throws ParseException;
}