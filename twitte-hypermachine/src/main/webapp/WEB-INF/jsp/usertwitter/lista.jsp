<%@ include file="../../../header.jspf" %>

<table>
		<thead>
		
			<tr>
				<th>Contas Cadastradas</th>
				<th>Remover</th>
				
			</tr> 
		</thead>
		<tbody>
			
			<c:forEach items="${userTwitter}" var="userTwitter">
				<tr>
					
					<td>${userTwitter.nome}</td>
					<c:if test="${usuarioWeb.logado }">
						
						<td ><a id ="remover"href="remover?id=${userTwitter.id}">remover</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
</table>

