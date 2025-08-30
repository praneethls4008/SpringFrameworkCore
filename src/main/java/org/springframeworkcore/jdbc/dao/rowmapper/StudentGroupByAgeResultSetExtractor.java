package org.springframeworkcore.jdbc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentGroupByAgeResultSetExtractor implements ResultSetExtractor<Map<Integer, List<String>>>{

	@Override
	public Map<Integer, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, List<String>> map = new HashMap<>();
		
		while(rs.next()) {
			Integer key = rs.getInt("age");
			String val = rs.getString("name");
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
		}
		return map;
	}

}
