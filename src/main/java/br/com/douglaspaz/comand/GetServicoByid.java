//package br.com.douglaspaz.comand;
//
//import java.sql.SQLException;
//
//import br.com.douglaspaz.service.ClienteServico;
//import br.com.douglaspaz.service.OrdemServicoService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class GetServicoByid implements Command{
//	private String pagina = "/ordemServico/listaOrdemServico.jsp";
//	
//
//	private ClienteServico clienteService;
//	private OrdemServicoService orderServicoService;
//	
//    public GetServicoByid(ClienteServico clienteService, OrdemServicoService orderServicoService) {
//        this.clienteService = clienteService;
//        this.orderServicoService  = orderServicoService;
//    }
//   
//
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        String idParam = request.getParameter("id");
//        if (idParam != null && !idParam.isEmpty()) {
//            int id = Integer.parseInt(idParam);
//            request.setAttribute("servicoCliente", clienteService.listaServicoCliente(id));
//        } else {
//            request.setAttribute("orderServicosList", orderServicoService.listarTodos());
//        }
//        return pagina;
//    }
//}
