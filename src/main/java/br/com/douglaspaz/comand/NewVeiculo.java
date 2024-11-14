package br.com.douglaspaz.comand;

import br.com.douglaspaz.service.ClienteServico;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewVeiculo implements Command{

	private static String pagina = "/WEB-INF/veiculo/cadastrarVeiculo.jsp";
	
	private ClienteServico clienteServico;
	
	public NewVeiculo(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("clientes", this.clienteServico.listarClientes());
		return pagina;
	};
	
	
	
}
