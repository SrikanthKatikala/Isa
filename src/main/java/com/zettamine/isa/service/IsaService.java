package com.zettamine.isa.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dto.SearchCriteriaImpl;

public interface IsaService <T, S extends SearchCriteriaImpl> {

	Optional<T> get(Integer id) throws SQLException;
    
    List<T> getAll();
    
    List<T> getBySearchCriteria(S criteria);
    
    void save(T t);
    
    void update(T t, String...params);
    
    void delete(T t);
}
