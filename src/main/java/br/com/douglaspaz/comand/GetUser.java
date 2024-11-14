package br.com.douglaspaz.comand;

import br.com.douglaspaz.service.ClienteServico;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetUser implements Command {
	
	
	private static final String PAGINAUPDATE = "/cliente/cadastrarCliente.jsp";
	
	ClienteServico clienteServico;
	
	public GetUser(ClienteServico clienteServico) {
		this.clienteServico = clienteServico;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		var user = this.clienteServico.buscarClientePorId(id);
		request.setAttribute("user", user);
		
		return PAGINAUPDATE;
	}

}
