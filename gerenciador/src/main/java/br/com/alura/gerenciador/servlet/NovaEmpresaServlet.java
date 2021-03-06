package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa") // caminho mapeado
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// se eu mudar de protected void service pra protected void doPost ele só vai aceitar requisição POST, não GET.
	// service lida com get e com post
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data"); 
		
		Date dataAbertura = null; // instanciei aqui pra ser global, pois como tava dentro de try catch eu nao tava conseguindo recupera-lo
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			dataAbertura = sdf.parse(dataEmpresa); // passa o valor dataEmpresa, que veio como string do getParameter, e o transforma na forma dd/MM/yyyy
		} catch (ParseException e) {
			throw new ServletException(e);
		} 
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		
		Banco banco = new Banco();
		banco.adiciona(empresa); // adiciona empresa no banco; seta o id autoincremento
		
		
		response.sendRedirect("listaEmpresas"); // redireciona a resposta para o servlet listaEmpresas
		
		
	}

}
