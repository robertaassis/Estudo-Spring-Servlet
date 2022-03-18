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
		// METODO GETPARAMETER SEMPRE RETORNA STRING!!!
		// Se o forms estiver como metodo POST, o getParameter consegue pegar o valor do input sem mostra-lo na URL
		String nomeEmpresa = request.getParameter("nome"); // guarda o parametro nome (Alura) da URL em nomeEmpresa; http://localhost:8080/gerenciador/novaEmpresa?nome=Alura
		String dataEmpresa = request.getParameter("data"); // retorna como string
		
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
		banco.adiciona(empresa); // adiciona empresa no banco
		
		
		response.sendRedirect("listaEmpresas"); // redireciona a resposta para o servlet listaEmpresas
		
		/* sendRedirect = redirecionamento do lado do navegador; redirecionamento ao lado do cliente
		RequestDispatcher = redirecionamento do lado do servidor (um servlet chamando outro) */
		
		/* é redirecionado para outro servlet para ser feita uma nova requisição. No código abaixo se a pessoa escreve algo e vai para a lista de empresas, se ela apertar
		f5 o nome da lista iria repetir, pois as requisições estavam sendo feitas aqui. Ao redirecionar para outro arquivo com redirect, ele fará uma nova requisição de leitura, então
		ao apertar f5, o usuario abre mão daquela info e nao fica repetindo */

		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); // chama servlet listaEmpresas
//		//consigo usar o atributo empresa no recurso acima
//		request.setAttribute("empresa", empresa.getNome()); // joga atributo dentro da requisição; fica dentro do atributo "empresa" o nome
//		rd.forward(request,  response); // envia para o jsp
		
		
	
		
		
	}

}
