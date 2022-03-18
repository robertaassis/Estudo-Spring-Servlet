<!-- java server page - JSP -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> <!-- core � controle de fluxo -->

<!-- uso ${ empresa } apenas para usar entre eles o atributo salvo. Ex: empresa guardou o empresa.getNome no servlet NovaEmpresaServlet, logo posso usa-lo assim.
Expression Language nao funciona com loops  -->

<html>
	<body>
	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	
	<c:if test="${empty empresa}">
		Empresa n�o foi cadastrada
	</c:if>
	</body>
</html>

