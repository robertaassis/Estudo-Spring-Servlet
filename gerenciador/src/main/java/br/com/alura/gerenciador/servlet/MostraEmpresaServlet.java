package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id"); // getParameter devolve como string
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresaSelecionada = banco.buscaEmpresaPorId(id); // banco guarda uma lista das empresas, logo, quando eu achar uma empresa, vai ser retornado um objeto desse tipo
		
		request.setAttribute("empresa", empresaSelecionada);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request,  response);
		
	}

}
