
<%@ include file="../../../header.jspf" %>

<form action="altera">
	<fieldset>
		<legend>Editar Conta </legend>
		<input type="hidden" name="contaTwitter.id"
		value="${contaTwitter.id }" />
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="produto.nome"
		value="${produto.nome }"/>
		<button type="submit">Enviar</button>
	</fieldset>
</form>

<%@ include file="../../../footer.jspf" %>
    