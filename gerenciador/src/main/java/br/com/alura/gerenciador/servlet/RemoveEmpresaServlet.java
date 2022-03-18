package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveEmpresaServlet
 */
@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// Remove a empresa
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id"); // getParameter devolve como string
		Integer id = Integer.valueOf(paramId); // casting
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		// redireciona depois de excluir para listaEmpresas que chama o listaEmpresas.jsp e ja mostra a lista sem a empresa deletada
		response.sendRedirect("listaEmpresas");
		
		
	}

}
