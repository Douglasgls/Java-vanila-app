package br.com.douglaspaz.comand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewServico implements Command{
	private static String pagina = "/servico/cadastrarServico.jsp";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return pagina;
	};
}
