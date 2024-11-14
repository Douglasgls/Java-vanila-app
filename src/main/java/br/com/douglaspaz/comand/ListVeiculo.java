package br.com.douglaspaz.comand;

import java.sql.SQLException;

import br.com.douglaspaz.service.VeiculoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListVeiculo implements Command{
	
	private String pagina = "/veiculo/listaVeiculo.jsp";
	
	private VeiculoService veiculoService;
	
    public ListVeiculo(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		var veiculo = veiculoService.listarVeiculos();
		request.setAttribute("veiculoList", veiculo);
		return pagina;
	}

}
