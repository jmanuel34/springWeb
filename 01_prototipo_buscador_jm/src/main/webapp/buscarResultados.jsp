<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Lista de productos por categor�a</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style type="text/css">
body {
	color: purple;
}

h1 {
	text-align: center;
}

div {
	width: 400px;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple; input { display : block;
	margin-bottom: 15px;
}

input {
	color: purple;
	margin: 0 auto;
	display: block;
	margin-bottom: 15px;
	border: 1px solid purple;
	padding: 7px;
	display: block;
}}
</style>
</head>
<body bgcolor="green">
	<div>
		<h1>Buscar resultado</h1>
		
			Tematica: <input type="text" name="tematica" id="tematica"><br>
			<input type="button" value="Buscar" id="buscar">
		
		<br><br>
		<div id="resultados">
			
		</div>
		<br>
		<a href="toInicio">Volver</a>
	</div>
	<script type="text/javascript">
		$("#buscar").click(function(){
		/*	let url="FrontController?operation=doBuscarResultados&tematica="+$("#tematica").val();
			$.get(url,function(data,status) {*/
				let url="FrontController";
				let params = new Object();
				params.operation = "doBuscarResultados";
				params.tematica = $("#tematica").val();
				$.get(url, params, function(data, status) {	
				var html="";
				//recorremos JSON de respuesta y creamos una entrada HTML por cada resultado
				$.each(data,function(i,e){
					html+="<h2><a href='"+e.nombre+"'>"+e.nombre+"</a></h2>";
					html+="<h4>"+e.tematica+"</h4><hr>"
				});
				//volcamos el html completo en el div
				$("#resultados").html(html);
			});
		});
	
	
	</script>
	
	
</body>
</html> 