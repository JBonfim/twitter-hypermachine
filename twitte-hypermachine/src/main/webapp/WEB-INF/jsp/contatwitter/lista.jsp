<%@ include file="../../../header.jspf" %>

<table>
		<thead>
		
			<tr>
				<th>Conta</th>
				
			</tr> 
		</thead>
		<tbody>
			
			<c:forEach items="${contaTwitterList}" var="contaTwitter">
				<tr>
					
					<td>${contaTwitter.nome}</td>
					<c:if test="${usuarioWeb.logado }">
						
						<td><a href="remover?id=${contaTwitter.id}">Remover</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
</table>

<%@ include file="../../../footer.jspf" %>