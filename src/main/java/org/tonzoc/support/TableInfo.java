package org.tonzoc.support;

import java.lang.reflect.Field;
import java.util.List;

public class TableInfo {
    private String table;
    private List<Field> columns;
    private List<Field> joinColumns;
    private String primaryKey;

    public TableInfo() {
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Field> getColumns() {
        return columns;
    }

    public void setColumns(List<Field> columns) {
        this.columns = columns;
    }

    public List<Field> getJoinColumns() {
        return joinColumns;
    }

    public void setJoinColumns(List<Field> joinColumns) {
        this.joinColumns = joinColumns;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

}
