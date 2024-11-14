package br.com.douglaspaz.comand;

import br.com.douglaspaz.entity.Cliente;
import br.com.douglaspaz.service.ClienteServico;
import br.com.douglaspaz.service.ServicoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateUser implements Command{
	
	private static final String LISTAUSUARIOS = "http://localhost:8080/UsuarioCRUD/app?acao=ListUser";
	
	private ClienteServico clienteServico;
	
    public UpdateUser(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }
	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var usuario = new Cliente(request.getParameter("nome"), request.getParameter("email"),request.getParameter("celular"));
		usuario.setId(Long.parseLong(request.getParameter("id")));
		this.clienteServico.atualizarCliente(usuario);
		return LISTAUSUARIOS;
	}

	
	
	
}
