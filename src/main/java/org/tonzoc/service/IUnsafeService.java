package org.tonzoc.service;

import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.UnsafeModel;

import java.util.List;

public interface IUnsafeService extends IBaseService<UnsafeModel> {

    // 统计安全隐患
    List<ReturnModel> count();
}
