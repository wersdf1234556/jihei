package org.tonzoc.provider;

import org.apache.commons.lang.ArrayUtils;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;
import org.tonzoc.annotation.*;
import org.tonzoc.exception.PrimaryKeyNotFoundException;
import org.tonzoc.support.TableInfo;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseProvider {

    private static Map<Class, TableInfo> tableCache = new ConcurrentHashMap<>(256);

    public TableInfo getTableInfo(ProviderContext providerContext) throws PrimaryKeyNotFoundException {

        TableInfo tableInfo = tableCache.get(providerContext.getMapperType());

        if (tableInfo != null) {
            return tableInfo;
        }

        tableInfo = new TableInfo();

        System.out.println(providerContext.getMapperType());

        Type type = providerContext.getMapperType().getGenericInterfaces()[0];
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type resultType = parameterizedType.getActualTypeArguments()[0];

        Class<?> clazz = (Class<?>) resultType;

        tableInfo.setTable(this.table(clazz));
        tableInfo.setColumns(this.columns(clazz));
        tableInfo.setJoinColumns(this.joinColumns(clazz));
        tableInfo.setPrimaryKey(this.primaryKey(clazz));

        tableCache.put(providerContext.getMapperType(), tableInfo);

        return tableInfo;
    }

    public String table(Class<?> clazz) {
        return clazz.getAnnotation(Table.class).value();
    }

    public List<Field> columns(Class<?> clazz) {

        return Stream.of(clazz.getDeclaredFields())
                .filter(item -> item.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private List<Field> joinColumns(Class<?> clazz) {
        return Stream.of(clazz.getDeclaredFields())
                .filter(item -> item.isAnnotationPresent(JoinColumn.class))
                .collect(Collectors.toList());
    }

    public String primaryKey(Class<?> clazz) throws PrimaryKeyNotFoundException {
        List<String> columns = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                return field.getAnnotation(Column.class).value();
            }
        }

        throw new PrimaryKeyNotFoundException(table(clazz));
    }

    public SQL selectSql(TableInfo tableInfo) {

        String[] selectColumns = tableInfo.getColumns()
                .stream()
                .map(item -> "mainTable" + "." + item.getAnnotation(Column.class).value())
                .toArray(String[]::new);

        String[] selectJoinColumns = tableInfo.getJoinColumns()
                .stream()
                .map(item -> {
                    JoinColumn joinColumn = item.getAnnotation(JoinColumn.class);
                    String tableAlias = joinColumn.type().getAnnotation(Table.class).value()
                            + StringUtils.capitalize(joinColumn.value()) + "Table";
                    return tableAlias + "." + joinColumn.value() + " as " + item.getName();
                })
                .toArray(String[]::new);

        SQL sql = new SQL()
                .SELECT(StringUtils.arrayToCommaDelimitedString(ArrayUtils.addAll(selectColumns, selectJoinColumns)))
                .FROM(tableInfo.getTable() + " " + "mainTable");

        for (Field item : tableInfo.getJoinColumns()) {
            JoinColumn joinColumn = item.getAnnotation(JoinColumn.class);
            String tableName = joinColumn.type().getAnnotation(Table.class).value();
            String tableAlias = tableName + StringUtils.capitalize(joinColumn.value()) + "Table";

            sql.LEFT_OUTER_JOIN(tableName + " " + tableAlias + " ON " + "mainTable" + "."
                    + joinColumn.leftColumn() + " = " + tableAlias + "." + joinColumn.rightColumn());
        }

        return sql;
    }

    public SQL insertManySql(TableInfo tableInfo) {
        String[] intoColumns = tableInfo.getColumns()
                .stream()
                .filter(item -> !item.isAnnotationPresent(NotInsertColumn.class))
                .map(item -> item.getAnnotation(Column.class).value())
                .toArray(String[]::new);

        return new SQL()
                .INSERT_INTO(tableInfo.getTable())
                .INTO_COLUMNS(intoColumns);
    }

    public SQL insertSql(TableInfo tableInfo) {
        System.out.println("insertsql");
        String[] intoColumns = tableInfo.getColumns()
                .stream()
                .filter(item -> !item.isAnnotationPresent(NotInsertColumn.class))
                .map(item -> item.getAnnotation(Column.class).value())
                .toArray(String[]::new);

        String[] intoValues = tableInfo.getColumns()
                .stream()
                .filter(item -> !item.isAnnotationPresent(NotInsertColumn.class))
                .map(item -> bindParameter(item.getAnnotation(Column.class).value()))
                .toArray(String[]::new);

        return new SQL()
                .INSERT_INTO(tableInfo.getTable())
                .INTO_COLUMNS(intoColumns)
                .INTO_VALUES(intoValues);
    }

    public SQL updateSql(TableInfo tableInfo) {

        return new SQL()
                .UPDATE(tableInfo.getTable());
    }

    public SQL deleteSql(TableInfo tableInfo) {
        return new SQL()
                .DELETE_FROM(tableInfo.getTable());
    }

    public String bindParameter(String field) {
        return "#{" + field + "}";
    }
}
