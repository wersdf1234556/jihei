package org.tonzoc.mapper;

import org.apache.ibatis.annotations.*;
import org.tonzoc.provider.*;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.List;

public interface BaseMapper<Entity> {

    @SelectProvider(type = SelectAllProvider.class, method = "sql")
    List<Entity> selectAll(@Param(value = "sqlQueryParams") List<SqlQueryParam> sqlQueryParams);

    @SelectProvider(type = SelectOneProvider.class, method = "sql")
    Entity selectOne(@Param(value = "primaryKey") String primaryKey);

    @InsertProvider(type = InsertOneProvider.class, method = "sql")
    @SelectKey(keyProperty = "guid", resultType = String.class, before = true, statement = "SELECT NEWID()")
    Integer insert(Entity entity);

    @InsertProvider(type = InsertManyProvider.class, method = "sql")
//    @SelectKey(keyProperty = "guid", resultType = String.class, before = true, statement = "SELECT NEWID()")
    Integer insertMany(@Param(value = "entities") List<Entity> entities);

    @UpdateProvider(type = UpdateOneProvider.class, method = "sql")
    Integer update(@Param(value = "entity") Entity entity);

    @DeleteProvider(type = DeleteOneProvider.class, method = "sql")
    Integer delete(@Param(value = "primaryKey") String primaryKey);
}
