package br.com.douglaspaz.comand;

import java.util.List;

import br.com.douglaspaz.entity.Cliente;
import br.com.douglaspaz.entity.OrdemServico;
import br.com.douglaspaz.service.ClienteServico;
import br.com.douglaspaz.service.OrdemServicoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletePedido implements Command {

	private String pagina = "/WEB-INF/ordemServico/listaOrdemServico.jsp";

	private OrdemServicoService orderServicoService;
	private ClienteServico clienteService;
	
    public DeletePedido(OrdemServicoService ordemServicoService, ClienteServico clienteService) {
        this.orderServicoService = ordemServicoService;
        this.clienteService = clienteService;
    }


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    this.orderServicoService.removerOrder(id);
	    List<Cliente> clienteList = clienteService.listarClientes();
        request.setAttribute("clienteList", clienteList);
	    List<OrdemServico> servicoList = this.orderServicoService.listarTodos(); // Liste as ordens de serviço
	    request.setAttribute("servicoList", servicoList); // Mude para servicoList
	    return pagina;
	}
	
}
