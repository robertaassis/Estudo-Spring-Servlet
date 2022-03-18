package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data"); 
		String paramId =  request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null; // instanciei aqui pra ser global, pois como tava dentro de try catch eu nao tava conseguindo recupera-lo
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			dataAbertura = sdf.parse(dataEmpresa); // passa o valor dataEmpresa, que veio como string do getParameter, e o transforma na forma dd/MM/yyyy
		} catch (ParseException e) {
			throw new ServletException(e);
		} 
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPorId(id); // acha a empresa
		// troca os dados dela
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listaEmpresas");
		
	}

}
