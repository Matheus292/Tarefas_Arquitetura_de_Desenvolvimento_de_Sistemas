<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

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
		<c:import url="menu.jsp"/>

		<div id="main" class="container">
		<h1 class="page-header">Cadastrar nova empresa</h1>

		<form  id="formulario" action="controller.do?command=EmpresaCadastrada" method="post">

			<div class="row">
				<div class="form-group col-md-12">
					<label>CNPJ:</label> <input type="text" class="form-control" id = "fonte"
						name="cnpj" maxlength=14  required 
						placeholder="CNPJ no formato xx.xxx.xxx/xxxx-xx" /><br>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label>Raz�o Social:</label> <input type="text" name="razao" id = "fonte"
						class="form-control" required placeholder="Insira a raz�o social" /><br>

				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label>Endere�o:</label> <input type="text" name="endereco" id = "fonte"
						class="form-control" required placeholder="Insira o endere�o" /><br>
				</div>
			</div>

	
			<div class="row">
				<div class="form-group col-md-12">
					<label>Telefone:</label> <input type="tel" name="fone" required id = "fonte"
						class="form-control" 
						 data-mask="(00) 0000-0000"
						data-mask-selectonfocus="true"
						placeholder="Telefone com ddd no formato (99) 9999-9999" /><br>
				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-12">
					<label>Hor�rio de Funcionameto:</label>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<input type="time" name="horarioInicial" required id = "fonte" /> <label>�s</label>
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
					<input type="time" name="arHorarioInicial" required id = "fonte"/> <label>�s</label>
					<input type="time" name="arHorarioFinal" required id = "fonte"/><br>

				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-8">
					<label>Temperatura m�xima do Ar Condicionado:</label> 
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
					<label>Conjuntos D�sponiveis:</label>
				</div>
			</div>


	<div class="row">
		<div class="form-group col-md-6">
				
		 <c:forEach var="lista" items="${lista }">
			 <label> ${lista.id } </label>
		 	<input type="radio" name="CONJUNTO" value= ${lista.id } checked />
		 </c:forEach>	
		 	
		</div>
	</div>
			<hr/>
			<input type="submit" class="btn btn-success"  value="Cadastrar"  
			/>
			 <input type="reset" class="btn btn-default" value="Limpar" />
	<br><br>
		</form>
	</div>

</body>
</html>