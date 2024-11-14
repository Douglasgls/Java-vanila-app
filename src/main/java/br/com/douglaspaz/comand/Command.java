package br.com.douglaspaz.comand;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {

	
	String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException;
	
}
