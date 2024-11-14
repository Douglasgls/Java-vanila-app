package br.com.douglaspaz.comand;

import java.sql.SQLException;

import br.com.douglaspaz.entity.Servico;
import br.com.douglaspaz.service.ServicoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetServico implements Command {
	private String pagina = "./servico/cadastrarServico.jsp";
	
	private ServicoService servicoService;
	
    public GetServico (ServicoService servicoService) {
        this.servicoService = servicoService;
    }

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		Servico servico = servicoService.listaUmServico(Long.parseLong(id));
		request.setAttribute("servico", servico);
		return pagina;
	}

}
