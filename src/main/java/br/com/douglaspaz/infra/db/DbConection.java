package br.com.douglaspaz.infra.db;

import java.sql.Connection;

public interface DbConection {

	Connection getConnection();
	void close(Connection conn);
	
}
