package br.com.douglaspaz.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.douglaspaz.DAO.ClienteDAO;
import br.com.douglaspaz.DAO.OrdemServicoDAO;
import br.com.douglaspaz.DAO.ServicoDAO;
import br.com.douglaspaz.DAO.VeiculoDAO;
import br.com.douglaspaz.comand.Command;
import br.com.douglaspaz.comand.DeletePedido;
import br.com.douglaspaz.comand.DeleteServico;
import br.com.douglaspaz.comand.DeleteUser;
import br.com.douglaspaz.comand.DeleteVeiculo;
import br.com.douglaspaz.comand.GetServico;
import br.com.douglaspaz.comand.GetUser;
import br.com.douglaspaz.comand.GetVeiculo;
import br.com.douglaspaz.comand.ListOrdemServicos;
import br.com.douglaspaz.comand.ListServico;
import br.com.douglaspaz.comand.ListUser;
import br.com.douglaspaz.comand.ListVeiculo;
import br.com.douglaspaz.comand.NewOrdemServico;
import br.com.douglaspaz.comand.NewServico;
import br.com.douglaspaz.comand.NewUser;
import br.com.douglaspaz.comand.NewVeiculo;
import br.com.douglaspaz.comand.RegisterOrdemServico;
import br.com.douglaspaz.comand.RegisterServico;
import br.com.douglaspaz.comand.RegisterVeiculo;
import br.com.douglaspaz.comand.UpdateServico;
import br.com.douglaspaz.comand.UpdateUser;
import br.com.douglaspaz.comand.UpdateVeiculo;
import br.com.douglaspaz.infra.db.DbConection;
import br.com.douglaspaz.infra.db.MySqlDbConection;
import br.com.douglaspaz.service.ClienteServico;
import br.com.douglaspaz.service.OrdemServicoService;
import br.com.douglaspaz.service.ServicoService;
import br.com.douglaspaz.service.VeiculoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DbConection conn = new MySqlDbConection();
	
	private VeiculoDAO veiculoDAO = new VeiculoDAO(this.conn);
	private ServicoDAO servicoDAO = new ServicoDAO(this.conn);
	private ClienteDAO clienteDAO = new ClienteDAO(this.conn);
	private OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO(this.conn);
	HashMap<String, Command> command = new HashMap<String, Command>();
	
	private VeiculoService veiculoService = new VeiculoService(veiculoDAO);
	private ServicoService servicoService = new ServicoService(servicoDAO);
	private ClienteServico clienteServico = new ClienteServico(clienteDAO);
	private OrdemServicoService ordemServicoService = new OrdemServicoService(ordemServicoDAO);
	
	public Controller() {
//		Cliente
		command.put("CadastroUser", new NewUser(clienteServico));
		command.put("ListUser", new ListUser(clienteServico));
		command.put("GetUser", new GetUser(clienteServico));
		command.put("AtualizarUser", new UpdateUser(clienteServico));
		command.put("DeleteUser", new DeleteUser(clienteServico));
		
//		Veiculo
		command.put("novoVeiculo", new NewVeiculo(clienteServico));
		command.put("cadastrarVeiculo", new RegisterVeiculo(veiculoService));
		command.put("listaVeiculos", new ListVeiculo(veiculoService));
		command.put("listaUmVeiculo", new GetVeiculo(veiculoService,clienteServico));
		command.put("atualizarVeiculo", new UpdateVeiculo(veiculoService));
		command.put("deleteVeiculo", new DeleteVeiculo(veiculoService));
		
//		Servico
		command.put("novoServico", new NewServico());
		command.put("cadastrarServico", new RegisterServico(servicoService));
		command.put("listaServico", new ListServico(servicoService));
		command.put("listaUmServico", new GetServico(servicoService));
		command.put("atualizarServico", new UpdateServico(servicoService));
		command.put("deleteServico", new DeleteServico(servicoService));
		
		command.put("novoOrderServico", new NewOrdemServico(veiculoService,servicoService,clienteServico));
		command.put("cadastrarPedido", new RegisterOrdemServico(ordemServicoService, veiculoService, servicoService, clienteServico));
		command.put("listaOrderServico", new ListOrdemServicos(clienteServico, ordemServicoService));
		command.put("deleteOrderServico", new DeletePedido(ordemServicoService, clienteServico));
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = this.processRequest(request, response);
		request.getRequestDispatcher(pagina).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = this.processRequest(request, response);
		response.sendRedirect(pagina);
	}
	
	private String processRequest(HttpServletRequest request, HttpServletResponse response) {
		Command command = this.command.get(request.getParameter("acao"));
		String resources;
		try {
			resources = command.execute(request, response);
			return resources;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
