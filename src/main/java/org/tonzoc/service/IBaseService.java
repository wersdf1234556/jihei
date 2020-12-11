package org.tonzoc.service;

import org.tonzoc.exception.NotFoundException;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.List;

public interface IBaseService<Entity> {
    List<Entity> list(List<SqlQueryParam> sqlQueryParams);

    Entity get(String primaryKey);

    Entity save(Entity entity);

    Integer saveMany(List<Entity> entities);

    Entity update(Entity entity);

    void remove(String primaryKey);

    void removeMany(String primaryKeys) throws Exception;
}
