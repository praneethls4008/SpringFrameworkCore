package org.springframeworkcore.jdbc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframeworkcore.jdbc.dao.repo.SQLFunction;

public class StudentGroupByResultSetExtractor<K, V> implements ResultSetExtractor<Map<K, List<V>>>{

	private SQLFunction<ResultSet, K> keyFunction;
	private SQLFunction<ResultSet, V> valueFunction;
	
	
	public StudentGroupByResultSetExtractor(SQLFunction<ResultSet, K> keyFunction, SQLFunction<ResultSet, V> valueFunction){
		this.keyFunction = keyFunction;
		this.valueFunction = valueFunction;
	}
	
	 @Override
	    public Map<K, List<V>> extractData(ResultSet rs) throws SQLException, DataAccessException {
	        Map<K, List<V>> map = new HashMap<>();
	        while (rs.next()) {
	            try {
	                K key = keyFunction.apply(rs);
	                V value = valueFunction.apply(rs);
	                map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
	            } catch (SQLException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return map;
	    }
	
	

}
