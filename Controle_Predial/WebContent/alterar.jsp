<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar empresa</title>
<link rel="icon" href="./imagens/icone.ico">
<link href="css/estilo.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
	<c:import url="menu.jsp"/>
	

	<div id="main" class="container">


		<h1 class="page-header">Alterar empresa</h1>

		<form name="formulario" action="AlterarEmpresa.do?opcao=salvar" method="post">

		<input type="hidden" name="cnpj" value= "${ empresa.cnpj }" />

			<div class="row">
				<div class="form-group col-md-12">
					<label>CNPJ:</label> <input type="text" class="form-control"
						id="fonte"  maxlength="14" required
						value="${ empresa.cnpj }" 
						placeholder="CNPJ no formato xx.xxx.xxx/xxxx-xx" disabled /><br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Razão Social:</label> <input type="text" name="razao"
						class="form-control" id="fonte" required maxlength="100"
						placeholder="Insira a razão social"
						value="${ empresa.razaoSocial }" /> <br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Endereço:</label> <input type="text" name="endereco"
						id="fonte" class="form-control" required
						value="${ empresa.endereco }"
						placeholder="Insira o endereço" /><br>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label>Telefone:</label> <input type="tel" name="fone" required
						id="fonte" class="form-control" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{4}[- ]?\d{4}"
						value="${ empresa.telefone }"
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
					<input type="time" name="horarioInicial" required id="fonte"
						value= "${ empresa.horarioAbertura }" /> <label>às</label> <input
						type="time" name="horarioFinal" required id="fonte"
						value= "${ empresa.horarioFechamento }" /><br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Funcionamento do Ar Condicionado:</label>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<input type="time" name="arHorarioInicial" value = "${ controle.horarioInicial }" required id="fonte" />
					<label>às</label> <input type="time" name="arHorarioFinal" value= "${ controle.horarioFinal }" required
						id="fonte" /><br>

				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-8">
					<label>Temperatura máxima do Ar Condicionado:</label>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-8">
					<input type="number" name="temperatura" min="0" max="40" id="fonte" value = "${ controle.temperaturaMaxima }"
						required /><br>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					<label>Conjuntos Dísponiveis:</label>
				</div>

				<div class="form-group col-md-6">
					<label>Conjunto ocupado pela empresa</label>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
			
			<c:forEach var = "conjunto" items="${ lista }">
				<label>${conjunto.id}</label>
				<input type="radio" name="CONJUNTO" value="${conjunto.id}" checked />   
			</c:forEach>		
		
			</div>

				<div class="form-group col-md-6">
				<label>${ ocupado.id  }</label>
			<input	type="radio" name="CONJUNTO" value="${ ocupado.id  }" checked />
				</div>
			</div>
			<hr />

			<br> <input type="submit" class="btn btn-success"
				value="Salvar alterações" /> 
				
				<a href="ManterEmpresa.do?opcao=listar"
				class="btn btn-default">Cancelar</a> <br>
			<br>
		</form>
	</div>
</body>
</html>