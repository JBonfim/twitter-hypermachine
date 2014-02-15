<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login &middot; HyperMachine Twitter </title>
    
    <link href="<c:url value="/estilo.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/estilo.css" />
    
        
  </head>

  <body>
      <form action="<c:url value="/login"/>" method="POST" class="form-login">
        <h2 class="form-login-titulo">Efetue Login:</h2>
        <input type="text" class="input-block-level" id="login" name="usuario.login" placeholder="Email">
        <input type="password" class="input-block-level" id="senha" name="usuario.senha" placeholder="Senha">
        <button class="bntLogin" type="submit">Entrar</button>
      </form>
  </body>
</html>
