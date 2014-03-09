package br.com.controle;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class WebSiteController {
	
	@Path("/")
	@Get
	public void home(){
		
	}
}
