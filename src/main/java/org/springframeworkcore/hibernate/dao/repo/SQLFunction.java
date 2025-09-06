package org.springframeworkcore.hibernate.dao.repo;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLFunction<T, R> {
	R apply(T t) throws SQLException;
}
