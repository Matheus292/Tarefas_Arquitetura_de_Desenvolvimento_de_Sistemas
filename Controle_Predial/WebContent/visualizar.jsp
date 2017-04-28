<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.usjt.refatoracao.model.*"%>
<%@ page import="br.com.usjt.refatoracao.service.*"%>
<%@ page import="java.util.*"%>


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
	<%@ include file="menu.jsp"%>
	<%@ include file="exclusao.jsp"%>

	<%
		Empresa empresa = ( Empresa ) request.getAttribute("empresa");
		ControleTemperatura controle = (ControleTemperatura) request.getAttribute("controle");
		Conjunto conjunto = ( Conjunto )request.getAttribute( "conjunto" );
	%>



	<div id="main" class="container">
		<h1 class="page-header">Dados da empresa</h1>


		<div class="row">
			<div class="col-md-12">
				<label>CNPJ:</label>
				<%=empresa.getCnpj()%>
			</div>
		</div>


		<div class="row">
			<div class="col-md-12">
				<label>Razão Social:</label>
				<%=empresa.getRazaoSocial()%>
			</div>
		</div>




		<div class="row">
			<div class="col-md-12">
				<label>Endereço:</label>
				<%=empresa.getEndereco()%>
			</div>
		</div>



		<div class="row">
			<div class="col-md-12">
				<label>Telefone:</label>
				<%=empresa.getTelefone()%>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<label>Horário de Funcionamento:</label>
				<%=empresa.getHorarioAbertura()%>
				<label> às </label><%=" " + empresa.getHorarioFechamento()%><br>

			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<label>Funcionamento do Ar Condicionado:</label>
				<%=controle.getHorarioInicial()%>
				<label>às</label>
				<%=controle.getHorarioFinal()%>
			</div>
		</div>


		<div class="row">
			<div class="col-md-12">
				<label>Temperatura:</label>
				<%=controle.getTemperaturaMaxima()%><br>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<label>Conjunto ocupado pela empresa: </label>
				<%= conjunto %>
			</div>
		</div>

		<hr />

		<button id="<%=empresa.getCnpj( ) %>" type="button"
			class="btn btn-danger" title="Excluir" data-toggle="modal"
			data-target="#delete-modal" data-cliente="<%= empresa.getCnpj( ) %>">Excluir</button>

		<a type="button" href="alterar.jsp?id=<%=empresa.getCnpj( )%>">
			<button class="btn btn-warning" title="Alterar Empresa">Alterar</button>
		</a>
		
		 <a type="button" href="consultar.jsp">
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