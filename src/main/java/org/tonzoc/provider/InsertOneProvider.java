package org.tonzoc.provider;

import org.apache.ibatis.builder.annotation.ProviderContext;
import org.tonzoc.exception.PrimaryKeyNotFoundException;
import org.tonzoc.support.TableInfo;

public class InsertOneProvider extends BaseProvider {

    public String sql(ProviderContext providerContext) throws PrimaryKeyNotFoundException {
        TableInfo tableInfo = getTableInfo(providerContext);

        System.out.println(insertSql(tableInfo));

        return insertSql(tableInfo).toString();
    }
}
