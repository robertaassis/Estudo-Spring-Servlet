<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> <!-- biblioteca jstl; prefixo core-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<c:url value="/removeEmpresa" var="remove"/>
<c:url value="/mostraEmpresa" var="editar"/>


<!-- BAIXEI BIBLIOTECA JSTL EM src/main/WebContent/WEB-INF/lib  -->
<html>
	<body>
	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	
	<c:if test="${empty empresa}">
		Empresa não foi cadastrada
	</c:if>
	<br>Lista de empresas: <br/> 
	
	
	<ul>
	<!-- precisa usar o c: antes pq o forEach é próprio da library JSTL então ele não existe, é salva no prefixo -->
		<c:forEach items="${listaEmpresa}" var="empresa"> <!-- listaEmpresa é um atributo que pega a lista das empresas no banco la no ListaEmpresaServlet; == foreach(listaEmpresa as empresa) -->
			<!--  printa tambem a data já formatada com a biblioteca jstl no padrao dia/mes/ano -->
			<li> 
			
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>  <!-- chama getNome sozinho -->
				<a href="${remove}?id=${empresa.id}">Remove</a> <!-- remove a empresa passando id como parametro -->
				<a href="${editar}?id=${empresa.id}">Edita</a>
			
			</li>
		</c:forEach>
	</ul>
	
		
		
	</body>
</html> 