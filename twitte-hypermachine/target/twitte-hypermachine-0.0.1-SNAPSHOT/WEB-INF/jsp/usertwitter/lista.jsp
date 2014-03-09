<%@ include file="../../../header.jspf" %>

<table>
		<thead>
		
			<tr>
				<th>Contas Cadastradas</th>
				<th>Remover</th>
				
			</tr> 
		</thead>
		<tbody>
			
			<c:forEach items="${contaTwitter}" var="contaTwitter">
				<tr>
					
					<td>${contaTwitter.nome}</td>
					<c:if test="${usuarioWeb.logado }">
						
						<td ><a id ="remover"href="remover?id=${contaTwitter.id}">remover</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
</table>

<%@ include file="../../../footer.jspf" %>