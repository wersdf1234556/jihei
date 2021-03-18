package org.tonzoc.common;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;
import org.tonzoc.exception.QueryParamNotSupportedException;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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
                case "dateLike":
                    sql.WHERE("Convert(varchar,mainTable" + "." + sqlQueryParam.getQueryField()+",120)" + " like " + "'%" + sqlQueryParam.getQueryValue() + "%'");
                    break;
                case "or":
                    List<String> list = new ArrayList();
                    StringBuffer resultBuffer = new StringBuffer();
                    String bondNo=null;
                    if (!sqlQueryParam.getQueryValue().contains("*")){
                        if (sqlQueryParam.getQueryValue().contains(",")){
                            list = Arrays.asList(org.apache.commons.lang.StringUtils.split(sqlQueryParam.getQueryValue(),","));
                            for (int m=0;m<list.size();m++){
                                System.out.println(list.get(m));
                                bondNo="mainTable" + "." + sqlQueryParam.getQueryField() + " = " + "'" + list.get(m) + "'";
                                if (m == 0) {
                                    //只有一个值的时候输出
                                    resultBuffer.append(bondNo);
                                }else{
                                    //有多个值的时候or分割
                                    resultBuffer.append(" or " + bondNo);
                                }
                            }
                        }else {
                            resultBuffer.append("mainTable" + "." + sqlQueryParam.getQueryField() + " = " + "'" + sqlQueryParam.getQueryValue() + "'");
                        }
                        if (resultBuffer.toString().contains("or")){
                            resultBuffer.insert( 0 , "(" ).append(")");
                        }
                        sql.WHERE(resultBuffer.toString());
                    }
                    break;
                default:
                    throw new QueryParamNotSupportedException(sqlQueryParam.getOperator() + "操作符不受支持！");
            }
        }

        return sql;
    }
}
