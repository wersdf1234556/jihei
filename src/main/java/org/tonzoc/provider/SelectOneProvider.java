package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;
import org.tonzoc.exception.PrimaryKeyEmptyException;
import org.tonzoc.exception.PrimaryKeyNotFoundException;
import org.tonzoc.support.TableInfo;

public class SelectOneProvider extends BaseProvider {

    public String sql(@Param(value = "primaryKey") String primaryKey, ProviderContext providerContext) throws PrimaryKeyNotFoundException, PrimaryKeyEmptyException {
        TableInfo tableInfo = getTableInfo(providerContext);

        if (StringUtils.isEmpty(primaryKey)) {
            throw new PrimaryKeyEmptyException(tableInfo.getPrimaryKey());
        }

        SQL sql = selectSql(tableInfo);

        return sql.WHERE("mainTable" + "." + tableInfo.getPrimaryKey() + " = '" + primaryKey + "'")
                .toString();
    }
}
