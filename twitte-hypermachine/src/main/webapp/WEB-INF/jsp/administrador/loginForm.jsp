
<%@ include file="../../../header.jspf" %>

<!--<form action="<c:url value="/login"/>" method="POST">
	<fieldset>
		<legend>Efetue o login</legend>
		<label for="login">Login:</label>
		<input id="login" type="text" name="usuario.login"/>
		
		<label for="senha">Senha:</label>
		<input id="senha" type="password" name="usuario.senha"/>
		
		<button type="submit">Login</button>
	</fieldset>
</form>-->

<form action="<c:url value="/login"/>" name="loginForm" method="POST">
	<fieldset>
		<legend>Efetue o login</legend>
		<label for="login">Login:</label>
		<input type="text" name="usuario.login" id="login" />	
		
		<label for="password">Senha:</label>
		<input type="password" name="usuario.senha" id="password"/>
		<button type="submit" id="submit">Login</button>
	</fieldset>
</form>

<%@ include file="../../../footer.jspf" %>