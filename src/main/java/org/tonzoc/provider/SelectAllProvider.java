package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.tonzoc.common.SqlHelper;
import org.tonzoc.exception.PrimaryKeyNotFoundException;
import org.tonzoc.exception.QueryParamNotSupportedException;
import org.tonzoc.support.TableInfo;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.List;

public class SelectAllProvider extends BaseProvider {

    @Autowired
    private SqlHelper sqlHelper;

    public String sql(@Param(value = "sqlQueryParams") List<SqlQueryParam> sqlQueryParams, ProviderContext providerContext)
            throws QueryParamNotSupportedException, PrimaryKeyNotFoundException {
        TableInfo tableInfo = getTableInfo(providerContext);

        SQL sql = selectSql(tableInfo);

        sqlHelper.generateSql(sql, sqlQueryParams);

        return sql.toString();
    }
}
