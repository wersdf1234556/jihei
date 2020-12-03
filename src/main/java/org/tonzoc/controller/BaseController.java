package org.tonzoc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import org.tonzoc.annotation.Operator;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.exception.PageException;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BaseController {

    public Page parsePage(PageQueryParams pageQueryParams) throws PageException {

        String defaultTableName = "mainTable";

        if (pageQueryParams == null || pageQueryParams.getPageSize() == null || pageQueryParams.getPageSize() == 0) {
            // 分页条件未给出或明确不分页，返回所有结果
            // 判断是否排序
            if (pageQueryParams.getOrder() != null && pageQueryParams.getSort() != null) {
                Page page = PageHelper.startPage(1, 0, defaultTableName + "." + pageQueryParams.getOrder() + " " + pageQueryParams.getSort());
                page.setOrderByOnly(true);
                return page;
            }
            return PageHelper.startPage(1, 0);
        }

        if (pageQueryParams.getPageIndex() == null) {
            throw new PageException("分页页码未找到！");
        }

        if (pageQueryParams.getOrder() != null && pageQueryParams.getSort() != null) {
            return PageHelper.startPage(pageQueryParams.getPageIndex(), pageQueryParams.getPageSize(),
                    defaultTableName + "." + pageQueryParams.getOrder() + " " + pageQueryParams.getSort());
        }

        return PageHelper.startPage(pageQueryParams.getPageIndex(), pageQueryParams.getPageSize());
    }

    public List parseSqlQueryParams(Object queryParams) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        if (queryParams != null) {
            for (Field field : queryParams.getClass().getDeclaredFields()) {

                Operator operator = field.getAnnotation(Operator.class);

                String getterName = "get" + StringUtils.capitalize(field.getName());
                Method getter = queryParams.getClass().getMethod(getterName);

                if (getter.invoke(queryParams) != null) {
                    SqlQueryParam sqlQueryParam = new SqlQueryParam(operator.field(), getter.invoke(queryParams).toString(), operator.value());

                    sqlQueryParams.add(sqlQueryParam);
                }
            }
        }

        return sqlQueryParams;
    }
}
