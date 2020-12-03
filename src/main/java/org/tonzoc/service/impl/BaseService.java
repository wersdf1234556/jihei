package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.tonzoc.mapper.BaseMapper;
import org.tonzoc.service.IBaseService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.List;

public abstract class BaseService<Entity> implements IBaseService<Entity> {

    @Autowired
    protected BaseMapper<Entity> entityMapper;

    public List<Entity> list(List<SqlQueryParam> sqlQueryParams) {
        return entityMapper.selectAll(sqlQueryParams);
    }

    public Entity get(String primaryKey) {
        return entityMapper.selectOne(primaryKey);
    }

    public Entity save(Entity entity) {
        entityMapper.insert(entity);
        return entity;
    }

    public Integer saveMany(List<Entity> entities) {
        return entityMapper.insertMany(entities);
    }

    public Entity update(Entity entity) {
        entityMapper.update(entity);
        return entity;
    }

    public void remove(String primaryKey) {
        entityMapper.delete(primaryKey);
    }

}
