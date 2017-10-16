<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Empresa</title>

<link rel="icon" href="./imagens/icone.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/update.js">
( window )
</script>
</head>
<body>
	
	<c:import url="menu.jsp"/>
	<c:import url="exclusao.jsp"/>

	<div id="main" class="container">
		<h1 class="page-header">Dados da empresa</h1>


		<div class="row">
			<div class="col-md-12">
				<label>CNPJ:</label>
				${ empresa.cnpj }
			</div>
		</div>


		<div class="row">
			<div class="col-md-12">
				<label>Razão Social:</label>
				${ empresa.razaoSocial }
			</div>
		</div>




		<div class="row">
			<div class="col-md-12">
				<label>Endereço:</label>
				${ empresa.endereco }
			</div>
		</div>



		<div class="row">
			<div class="col-md-12">
				<label>Telefone:</label>
				${ empresa.telefone }
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<label>Horário de Funcionamento:</label>
				${ empresa.horarioAbertura }
				<label> às </label> ${ empresa.horarioFechamento }<br>

			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<label>Funcionamento do Ar Condicionado:</label>
				${ controle.horarioInicial }
				<label>às</label>
				${ controle.horarioFinal }
			</div>
		</div>


		<div class="row">
			<div class="col-md-12">
				<label>Temperatura:</label>
				${ controle.temperaturaMaxima }<br>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<label>Conjunto ocupado pela empresa: </label>
				${ conjunto.id }
			</div>
		</div>

		<hr />

		<button id="${ empresa.cnpj }" type="button"
			class="btn btn-danger" title="Excluir" data-toggle="modal"
			data-target="#delete-modal" data-cliente="${ empresa.cnpj }">Excluir</button>

		<a type="button" href="controller.do?command=EditarEmpresa&id=${ empresa.cnpj }">
			<button class="btn btn-warning" title="Alterar Empresa">Alterar</button>
		</a>
		
		 <a type="button" href="controller.do?command=ListarEmpresa">
			<button class="btn btn-default" title="Listar Empresas">
				Listar Empresas</button>
		</a>

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