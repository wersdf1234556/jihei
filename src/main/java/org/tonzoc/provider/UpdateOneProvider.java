package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.exception.PrimaryKeyEmptyException;
import org.tonzoc.exception.PrimaryKeyNotFoundException;
import org.tonzoc.model.BaseModel;
import org.tonzoc.support.TableInfo;

import java.lang.reflect.Method;

public class UpdateOneProvider extends BaseProvider {

    public String sql(@Param(value = "entity") BaseModel entity, ProviderContext providerContext) throws PrimaryKeyNotFoundException, PrimaryKeyEmptyException {
        TableInfo tableInfo = getTableInfo(providerContext);

        SQL sql = updateSql(tableInfo);

        String[] sets = tableInfo.getColumns()
                .stream()
                .filter(item -> {
                    try {
                        if (item.isAnnotationPresent(PrimaryKey.class)) {
                            return false;
                        }
                        String getter = "get" + StringUtils.capitalize(item.getName());
                        Method method = entity.getClass().getMethod(getter);
//                        return !StringUtils.isEmpty(method.invoke(entity));
                        return method.invoke(entity)!=null;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .map(item -> {
                    try {
                        String getter = "get" + StringUtils.capitalize(item.getName());
//                        System.out.println("getter"+getter);
                        Method method = entity.getClass().getMethod(getter);
                        return item.getAnnotation(Column.class).value() + " = '" + method.invoke(entity) + "'";
                    } catch (Exception e) {
                        return "";
                    }
                })
                .toArray(String[]::new);

        sql.SET(StringUtils.arrayToCommaDelimitedString(sets));

        try {
            String primaryKeyGetter = "get" + StringUtils.capitalize(tableInfo.getPrimaryKey());
            Method primaryKeyMethod = entity.getClass().getMethod(primaryKeyGetter);

            if (StringUtils.isEmpty(primaryKeyMethod.invoke(entity))) {
                throw new PrimaryKeyEmptyException(tableInfo.getPrimaryKey());
            }
            sql.WHERE(tableInfo.getPrimaryKey() + " = '" + primaryKeyMethod.invoke(entity) + "'");

        } catch (Exception e) {
            throw new PrimaryKeyEmptyException(tableInfo.getPrimaryKey());
        }

        System.out.println(sql.toString());

        return sql.toString();
    }
}
