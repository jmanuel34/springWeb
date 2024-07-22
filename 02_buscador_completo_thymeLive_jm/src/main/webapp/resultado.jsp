

<!DOCTYPE html>
<html lang="es" xmlns:th="http://www.thymeleaf.org"><head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" >
</head>
<body>
	<h2>URL: ${requestScope.resultado.url }</h2>
	<h2>Temática: ${requestScope.resultado.tematica }</h2>
	<h2>Descripción: ${requestScope.resultado.descripcion }</h2>
	<a href="toInicio">Volver a home</a>
</body>
</html> 

