<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="css/estilo.css" rel="stylesheet">
<link rel="icon" href="./imagens/icone.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">

</head>

<body id="corpo1">

	<div class="container">
		<div id="borda1">
			<h1 id="h1" class="page-header">Sistema de Controle Predial</h1>

			<form class="form-signin" method="post" action="controller.do">

				<h2 class="form-signin-heading">Acessar Sistema</h2>

				<label for="inputEmail" class="sr-only">Login</label> <input
					type="text" id="inputEmail" name="login" class="form-control"
					placeholder="Digite seu login" required autofocus> <label
					for="inputPassword" class="sr-only">Senha</label> <input
					type="password" id="inputPassword" class="form-control"
					name="senha" placeholder="Digite sua senha" required>

				<button class="btn btn-lg btn-primary btn-block" name="command"
					type="submit" value="Login">Entrar</button>

				<br>
				<c:if test="${ erro.valor == 1 }">
					<label class=""> Login ou senha inválido( s ) ! </label>
				</c:if>
			</form>

		</div>

	</div>

</body>
</html>