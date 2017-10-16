<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="icon" href="./imagens/icone.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">

<script type="text/javascript">
alert( "Login ou Senha inválida(s) !");
</script>
</head>

<body id="corpo1">
	<div class="container">

		<form class="form-signin" method="post" action="controller.do">

			<h2 class="form-signin-heading">Acessar Sistema</h2>

			<label for="inputEmail" class="sr-only">Login</label> <input
				type="text" id="inputEmail" name="login" class="form-control"
				placeholder="Digite seu login" required autofocus> <label
				for="inputPassword" class="sr-only">Senha</label> <input
				type="password" id="inputPassword" class="form-control" name="senha"
				placeholder="Digite sua senha" required>

			<button class="btn btn-lg btn-primary btn-block" name="command"
				type="submit" value="Login">Entrar</button>
		</form>

	</div>

</body>
</html>