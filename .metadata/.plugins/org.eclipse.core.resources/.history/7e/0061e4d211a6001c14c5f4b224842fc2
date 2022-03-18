<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    %>
<%@  page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"  %>
<html>
	<body>
		<ul>
		Lista de empresas:
		<% List<Empresa> lista = (List<Empresa>)request.getAttribute("listaEmpresa"); // casting; coloca na lista o atributo guardado em listaEmpresa
		for(Empresa empresa : lista) { %>
			<li> <%= empresa.getNome() %>  </li> 
		<% } %>
		
		</ul>
	</body>
</html>