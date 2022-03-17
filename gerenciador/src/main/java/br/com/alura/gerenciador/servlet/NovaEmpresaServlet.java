package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// se eu mudar de protected void service pra protected void doPost ele só vai aceitar requisição POST, não GET.
	// service lida com get e com post
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		System.out.println("Cadastrando nova empresa");
		PrintWriter out = response.getWriter(); // vai escrever na página
		// METODO GETPARAMETER SEMPRE RETORNA STRING!!!
		// Se o forms estiver como metodo POST, o getParameter consegue pegar o valor do input sem mostra-lo na URL
		String nomeEmpresa = request.getParameter("nome"); // guarda o parametro nome (Alura) da URL em nomeEmpresa; http://localhost:8080/gerenciador/novaEmpresa?nome=Alura
		out.println("<html><body>Empresa "+ nomeEmpresa +" cadastrada com sucesso</body></html>");
		
		
	}

}