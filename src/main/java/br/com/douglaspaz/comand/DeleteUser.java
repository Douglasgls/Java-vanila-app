package br.com.douglaspaz.comand;

import br.com.douglaspaz.service.ClienteServico;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUser implements Command{
	
	private static final String LISTAUSUARIOS = "/WEB-INF/cliente/listaCliente.jsp";

	
	ClienteServico clienteServico;
	
	public DeleteUser(ClienteServico clienteServico) {
		this.clienteServico = clienteServico;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		this.clienteServico.excluirCliente(id);
		request.setAttribute("userList", clienteServico.listarClientes());
		return LISTAUSUARIOS;
	}

}
