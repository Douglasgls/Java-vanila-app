package br.com.douglaspaz.comand;

import java.sql.SQLException;

import br.com.douglaspaz.service.ClienteServico;
import br.com.douglaspaz.service.ServicoService;
import br.com.douglaspaz.service.VeiculoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewOrdemServico implements Command {
	
	private String pagina = "/WEB-INF/ordemServico/cadastrarOrdemServico.jsp";
	
	private VeiculoService veiculoService;
	private ServicoService servicoService;
	private ClienteServico clienteService;
	
    public NewOrdemServico(VeiculoService veiculoService, ServicoService servicoService, ClienteServico clienteService) {
        this.veiculoService = veiculoService;
        this.servicoService = servicoService;
        this.clienteService = clienteService;
    }

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		request.setAttribute("clientes", clienteService.listarClientes());
	    request.setAttribute("veiculos", veiculoService.listarVeiculos());
	    request.setAttribute("servicos", servicoService.listarServicos());
	
		return pagina;
	}

}
