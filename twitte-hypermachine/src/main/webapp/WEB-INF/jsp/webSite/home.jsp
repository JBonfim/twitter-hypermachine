<%@ include file="../../../inicio.jspf" %>

					<li>
						<h3>Video Mais Curtido</h3>
						<a href="produto.html">
									<iframe width="720" height="480"
									src="http://www.youtube.com/embed/${v.location}">
									</iframe>
								</a>
								<button type="button" ><a id="bt" href="webSite/listaUsuarios?location=${v.location}" onclick="NovaJanela(this.href,'nomeJanela','450','450','yes');return false">Usuarios Que Tuitaram</a></button>
								<button type="button" ><a id="bt" href="webSite/midiaAlbum?id=${v.id}" onclick="NovaJanela(this.href,'nomeJanela','450','450','yes');return false">Capa do Album</a></button>
								
								<a href="https://twitter.com/share" class="twitter-share-button" data-via="hypermachine_tweets - Gostei da musica" data-url="${v.location}"  data-lang="pt" data-count="none">Tweetar</a>
								<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
								
						
					</li>
			</div><!-- fim .container .destaque -->
		</div>
			
	<div id="destaques">
			<div class="container paineis">
				<div class="painel novidades">
					<h2>Videos</h2>
					<ol>
						<li>
							<c:forEach items="${litvideos}" var="litvideos">
								<a href="produto.html">
										
									  <iframe width="350" height="250"
										src="http://www.youtube.com/embed/${litvideos.location}">
									</iframe>
								</a>
								
								<button type="button" ><a id="bt" href="webSite/listaUsuarios?location=${litvideos.location}" onclick="NovaJanela(this.href,'nomeJanela','450','450','yes');return false">Usuarios Que Tuitaram</a></button>
								<button type="button" ><a id="bt" href="webSite/midiaAlbum?id=${litvideos.id}" onclick="NovaJanela(this.href,'nomeJanela','450','450','yes');return false">Capa do Album</a></button>
								
								<a href="https://twitter.com/share" class="twitter-share-button" data-via="hypermachine_tweets - Gostei da musica" data-url="http://www.youtube.com/embed/${litvideos.location}"  data-lang="pt" data-count="none">Tweetar</a>
								<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
								
							</c:forEach>
							
						</li>
						
					</ol>
				</div>
			</div>
			<div class="container paineis">
				
				<div class="painel mais-vendidos">
					
					<h2>Musicas</h2>
					
					<ol>
						<li>
							<c:forEach items="${litmusicas}" var="litmusicas">
								
								<a href="produto.html">
									  
									<iframe class="iframe-responsive" width="350" height="250"
									src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/${litmusicas.location}&amp;auto_play=false&amp;hide_related=false&amp;visual=true">
									</iframe>
									
									
								</a>
								<button type="button" ><a id="bt" href="webSite/listaUsuarios?location=${litmusicas.location}" onclick="NovaJanela(this.href,'nomeJanela','450','450','yes');return false">Usuarios Que Tuitaram</a></button>
								<button type="button" ><a id="bt" href="webSite/midiaAlbum?id=${litmusicas.id}" onclick="NovaJanela(this.href,'nomeJanela','450','450','yes');return false">Capa do Album</a></button>
								
								<a href="https://twitter.com/share" class="twitter-share-button" data-via="hypermachine_tweets - Gostei da musica" data-url="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/${litmusicas.location}"  data-lang="pt" data-count="none">Tweetar</a>
								<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
								
							</c:forEach>
							
						</li>
						
					</ol>
					</div>
			</div>
	</div>
		
	
	
			
				

		<div>
			<div class="rodape footer">
				<!-- <img src="images/logoHT.png" alt="Logo HyperMachine Tweets" class="logo"> -->
				<ul class="social">
					<li><a href="https://www.facebook.com/hypermachinetweets">Facebook</a></li>
					<li><a href="http://twitter.com/hypermachinetweets">Twitter</a></li>
					<li><a href="http://plus.google.com/hypermachinetweets">Google+</a></li>
				</ul>
			</div>
		</div>

	</body>
 <script type="text/javascript">
$(function(){
 
    // Dialog
    $('.dialog').dialog({
        autoOpen: false,
        width: 500,
        height: 300,
        buttons: {
        "Ok": function() {
        $(this).dialog("close");
        },
        "Cancel": function() {
        $(this).dialog("close");
        }
        }
    });
 
    $('.dialog_link').click(function(){
 
    $('.dialog').dialog('close');
 
    var id_link = $(this).attr('id');
    var index = id_link.split('_');
 
    $('#txt_'+index[1]).dialog('open');
 
    return false;
 
    });
 
    $('.dialog_link, ul.icons li').hover(
    function() { $(this).addClass('ui-state-hover'); },
    function() { $(this).removeClass('ui-state-hover'); }
    );
 
});
</script>

</html>