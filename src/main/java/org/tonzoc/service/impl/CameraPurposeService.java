package org.tonzoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.tonzoc.model.CameraPurposeModel;
import org.tonzoc.service.ICameraPurposeService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.*;
import java.util.stream.Collectors;

@Service(value = "cameraPurposeService")
public class CameraPurposeService extends BaseService<CameraPurposeModel> implements ICameraPurposeService {
}
