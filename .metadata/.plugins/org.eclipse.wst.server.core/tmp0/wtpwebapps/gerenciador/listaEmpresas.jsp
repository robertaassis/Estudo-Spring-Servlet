<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> <!-- biblioteca jstl; prefixo core-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 


<!-- BAIXEI BIBLIOTECA JSTL EM src/main/WebContent/WEB-INF/lib  -->
<html>
	<body>
	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	
	<c:if test="${empty empresa}">
		Empresa n?o foi cadastrada
	</c:if>
	<br>Lista de empresas: <br/> 
	
	
	<ul>
	<!-- precisa usar o c: antes pq o forEach ? pr?prio da library JSTL ent?o ele n?o existe, ? salva no prefixo -->
		<c:forEach items="${listaEmpresa}" var="empresa"> <!-- listaEmpresa ? um atributo que pega a lista das empresas no banco la no ListaEmpresaServlet; == foreach(listaEmpresa as empresa) -->
			<!--  printa tambem a data j? formatada com a biblioteca jstl no padrao dia/mes/ano -->
			<li> ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> </li> <!-- chama getNome sozinho -->
		</c:forEach>
	</ul>
	
	<!-- C?digo acima mesma coisa do c?digo abaixo-->
	
	<!--	<ul>
		
		<%--<% List<Empresa> lista = (List<Empresa>)request.getAttribute("listaEmpresa"); // casting; coloca na lista o atributo guardado em listaEmpresa
		for(Empresa empresa : lista) { %>
			<li> <%= empresa.getNome() %>  </li> 
		<% } %> --%>
		
		</ul> -->
		
		
	</body>
</html> 