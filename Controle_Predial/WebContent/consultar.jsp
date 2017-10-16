<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar</title>
<link rel="icon" href="./imagens/icone.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
	
	<c:import url="menu.jsp" />
	<c:import url="exclusao.jsp" />
	
	<div id="main" class="container">

		<h1 class="page-header">Empresas Cadastradas</h1>

		<table class="table table-striped">
			<thead>
				<tr>

					<td><b>CNPJ</b></td>
					<td><b>Razão Social</b></td>
					<td><b>Telefone</b></td>
					<td><b>Endereço</b></td>
					<td><b>Horario de Abertura</b></td>
					<td><b>Horario de Fechamento</b></td>
					<td><b>Ação(es)</b></td>
				</tr>
			</thead>
			

			<c:forEach  var="empresa" items="${ lista }">
				<tr>

				<td> ${ empresa.cnpj }</td>
				<td> ${ empresa.razaoSocial }</td>
				<td> ${ empresa.telefone }</td>
				<td> ${ empresa.endereco }</td>
				<td> ${ empresa.horarioAbertura }</td>
				<td> ${ empresa.horarioFechamento }</td>
				<td><a type="button"
					href="controller.do?command=VisualizarEmpresa&id=${ empresa.cnpj }">
						<button class="glyphicon glyphicon-book + btn btn-info"
							title="Consultar"></button>
				</a> 

					<button id="${ empresa.cnpj }" type="button"
						class="glyphicon glyphicon-trash + btn btn-danger" title="Excluir"
						data-toggle="modal" data-target="#delete-modal"		data-cliente="${ empresa.cnpj }">
						
						</button> 
						
						<a	type="button" href="controller.do?command=EditarEmpresa&id=${ empresa.cnpj }">
						<button class="glyphicon glyphicon-pencil + btn btn-warning"
							title="Alterar Empresa"></button>
				</a>
				
				</td>
			</tr>
</c:forEach>
		</table>

		<script type="text/javascript">
			$("#delete-modal").on('show.bs.modal', function(event) {
				var button = $(event.relatedTarget); //botao que disparou a modal
				var recipient = button.data('cliente');
				$("#id_excluir").val(recipient);
			});
		</script>


	</div>
</body>
</html>