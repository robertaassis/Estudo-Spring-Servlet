<!-- java server page - JSP -->

<%

	String nomeEmpresa = (String) request.getAttribute("empresa"); // pegando o atributo que foi jogado
	
%>

<html>
<body>
	Empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body>
</html>

