package br.com.douglaspaz.comand;

import java.sql.SQLException;
import java.util.List;

import br.com.douglaspaz.entity.Servico;
import br.com.douglaspaz.service.ServicoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListServico implements Command{
	
	private String pagina = "/servico/listaServico.jsp";
	
	private ServicoService servicoService;
	
    public ListServico(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<Servico> servicoList = servicoService.listarServicos();
		request.setAttribute("servicoList", servicoList);
		return pagina;
	}

}
