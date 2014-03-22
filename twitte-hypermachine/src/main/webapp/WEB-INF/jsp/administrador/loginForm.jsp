
<%@ include file="../../../cabecalho.jsp" %>

<!--  <form action="<c:url value="/login"/>" name="loginForm" method="POST">
	<fieldset>
		<legend>Efetue o login</legend>
		<label for="login">Login:</label>
		<input type="text" name="usuario.login" id="login" />	
		
		<label for="password">Senha:</label>
		<input type="password" name="usuario.senha" id="password"/>
		<button type="submit" id="submit">Login</button>
	</fieldset>
</form>-->
<body>
 <div class="account-container">
	
	<div class="content clearfix">
		
		<form action="<c:url value="/login"/>" name="loginForm" method="POST">
		
			<h1>Login</h1>		
			
			<div class="login-fields">
				
				<p>Por favor forneca os seus dados</p>
				
				<div class="field">
					<label for="username">Usuario</label>
					<input type="text" id="username" name="usuario.login" placeholder="Usuario" class="login username-field" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Senha:</label>
					<input type="password" id="password" name="usuario.senha" placeholder="Senha" class="login password-field"/>
				</div> <!-- /password -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
				<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">Manter-me logado</label>
				</span>
									
				<button class="button btn btn-success btn-large">Entrar</button>
				
			</div> <!-- .actions -->
			
			
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->



<div class="login-extra">
	<a href="#">Redefinicao de senha</a>
</div> <!-- /login-extra -->

</body>


