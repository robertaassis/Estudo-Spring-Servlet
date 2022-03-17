package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/oi") // mapeio para oi
public class oiMundoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter(); // abaixo printa na pagina
		out.println("<html>");
		out.println("<body>");
		out.println("primeiro programa em servlet");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("isso aqui roda no console"); // printa no console
	}
}
