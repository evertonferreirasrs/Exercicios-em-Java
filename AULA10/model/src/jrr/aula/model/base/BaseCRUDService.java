package jrr.aula.model.base;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface BaseCRUDService<E extends BaseEntity> {

    public void create(E entity) throws Exception;

    public E readById(Long id) throws Exception;

    public List<E> readByCriteria(Map<Long, Object> criteria, Long limit, Long offset) throws Exception;

    public Long countByCriteria(Map<Long, Object> criteria) throws Exception;

    public void update(E entity) throws Exception;

    public void delete(Long id) throws Exception;

    public Map<String, String> validate(Map<String, Object> fields) throws Exception;
}
