<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa"/> <!-- nomeia valor da url -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form action="${linkServletAlteraEmpresa}" method="post"> <!-- redireciona para /gerenciador/novaEmpresa -->
		Nome: <input type="text" name="nome" value="${empresa.nome}"> 
		Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">  <!-- traz a data formatada para esse padrao -->
		<input type="hidden" name="id" value="${empresa.id}">
		<input type="submit">
	</form>
</body>
</html>