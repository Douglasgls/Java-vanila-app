package br.com.douglaspaz.comand;

import java.util.List;

import br.com.douglaspaz.entity.Veiculo;
import br.com.douglaspaz.service.VeiculoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteVeiculo implements Command {

	private String pagina = "/veiculo/listaVeiculo.jsp";

	private VeiculoService veiculoService;

	public DeleteVeiculo(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		this.veiculoService.removerVeiculo(id);
		List<Veiculo> veiculos= this.veiculoService.listarVeiculos();
		request.setAttribute("veiculoList", veiculos);
		return pagina;
	}

}
