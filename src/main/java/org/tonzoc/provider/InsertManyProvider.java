package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.exception.PrimaryKeyNotFoundException;
import org.tonzoc.support.TableInfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InsertManyProvider extends BaseProvider {

    public String sql(@Param(value = "entities") List entities, ProviderContext providerContext) throws PrimaryKeyNotFoundException {
        TableInfo tableInfo = getTableInfo(providerContext);

        SQL sql = insertManySql(tableInfo);

        List<String> values = new ArrayList<>();

        for (Object entity : entities) {
            String value = StringUtils.arrayToCommaDelimitedString(tableInfo.getColumns()
                    .stream()
                    .filter(item -> !item.isAnnotationPresent(NotInsertColumn.class))
                    .map(item -> {
                        try {
                            String getter = "get" + StringUtils.capitalize(item.getName());
                            Method method = entity.getClass().getMethod(getter);
                            return "'" + method.invoke(entity) + "'";
                        } catch (Exception e) {
                            return "''";
                        }
                    })
                    .toArray(String[]::new));

            values.add("(" + value + ")");
        }

        return sql.toString() + " VALUES " + StringUtils.arrayToCommaDelimitedString(values.toArray());
    }
}
