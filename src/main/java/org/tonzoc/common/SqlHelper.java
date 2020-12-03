package org.tonzoc.common;

import org.apache.ibatis.jdbc.SQL;
import org.tonzoc.exception.QueryParamNotSupportedException;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.List;

public class SqlHelper {

    public static SQL generateSql(SQL sql, List<SqlQueryParam> sqlQueryParams) throws QueryParamNotSupportedException {

        for (SqlQueryParam sqlQueryParam : sqlQueryParams) {
            switch (sqlQueryParam.getOperator()) {
                case "eq":
                    sql.WHERE("mainTable" + "." + sqlQueryParam.getQueryField() + " = " + "'" + sqlQueryParam.getQueryValue() + "'");
                    break;
                case "neq":
                    sql.WHERE("mainTable" + "." + sqlQueryParam.getQueryField() + " != " + "'" + sqlQueryParam.getQueryValue() + "'");
                    break;
                case "gt":
                    sql.WHERE("mainTable" + "." + sqlQueryParam.getQueryField() + " > " + "'" + sqlQueryParam.getQueryValue() + "'");
                    break;
                case "lt":
                    sql.WHERE("mainTable" + "." + sqlQueryParam.getQueryField() + " < " + "'" + sqlQueryParam.getQueryValue() + "'");
                    break;
                case "gte":
                    sql.WHERE("mainTable" + "." + sqlQueryParam.getQueryField() + " >= " + "'" + sqlQueryParam.getQueryValue() + "'");
                    break;
                case "lte":
                    sql.WHERE("mainTable" + "." + sqlQueryParam.getQueryField() + " <= " + "'" + sqlQueryParam.getQueryValue() + "'");
                    break;
                case "like":
                    sql.WHERE("mainTable" + "." + sqlQueryParam.getQueryField() + " like " + "'%" + sqlQueryParam.getQueryValue() + "%'");
                    break;
                default:
                    throw new QueryParamNotSupportedException(sqlQueryParam.getOperator() + "操作符不受支持！");
            }
        }

        return sql;
    }
}
