<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.usjt.refatoracao.model.*"%>
<%@ page import="br.com.usjt.refatoracao.service.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Nova empresa</title>
<link rel="icon" href="./imagens/icone.ico">
<link href="css/estilo.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>





</head>

<body>
	<%@ include file="menu.jsp"%>

	<div id="main" class="container">
		<h1 class="page-header">Cadastrar nova empresa</h1>

		<form id="formulario" action="ManterEmpresa.do" method="post">

			<div class="row">
				<div class="form-group col-md-12">
					<label>CNPJ:</label> <input type="text" class="form-control" id = "fonte"
						name="cnpj" maxlength="14" required
						placeholder="CNPJ no formato xx.xxx.xxx/xxxx-xx" /><br>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label>Razão Social:</label> <input type="text" name="razao" id = "fonte"
						class="form-control" required placeholder="Insira a razão social" /><br>

				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label>Endereço:</label> <input type="text" name="endereco" id = "fonte"
						class="form-control" required placeholder="Insira o endereço" /><br>
				</div>
			</div>

	
			<div class="row">
				<div class="form-group col-md-12">
					<label>Telefone:</label> <input type="text" name="fone" required id = "fonte"
						class="form-control"
						placeholder="Telefone com ddd no formato (99) 9999-9999" /><br>
				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-12">
					<label>Horário de Funcionameto:</label>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<input type="time" name="horarioInicial" required id = "fonte" /> <label>às</label>
					<input type="time" name="horarioFinal" required id = "fonte" /><br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Funcionamento do Ar Condicionado:</label>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<input type="time" name="arHorarioInicial" required id = "fonte"/> <label>às</label>
					<input type="time" name="arHorarioFinal" required id = "fonte"/><br>

				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-8">
					<label>Temperatura máxima do Ar Condicionado:</label> 
				</div>
			</div>


				<div class="row">
				<div class="form-group col-md-8">
					<input
						type="number" name="temperatura" min="0" max="40" id = "fonte" required/><br>
				</div>
			</div>
	

			<div class="row">
				<div class="form-group col-md-6">
					<label>Conjuntos Dísponiveis:</label>
				</div>
			</div>


	<div class="row">
				<div class="form-group col-md-6">
					<%
						ConjuntoService servico = new ConjuntoService();
						List<Conjunto> lista = servico.consultarConjuntoDesocupado();

						for (Conjunto conjunto : lista) {
					%>
					<label> <%=conjunto%>
					</label> <input type="radio" name="CONJUNTO" value=<%=conjunto%> checked />
					<%
						}
					%>
				</div>
			</div>
			<hr/>
			<input type="submit" class="btn btn-success" name = "opcao" value="Cadastrar"  
			/>
			 <input type="reset" class="btn btn-default" value="Limpar" />
	<br><br>
		</form>
	</div>

</body>
</html>