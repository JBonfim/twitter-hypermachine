package br.com.interceptor;

import java.util.Arrays;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.controle.UsertwitterController;
import br.com.controle.AdministradorController;
import br.com.dao.AdministradorDao;

@Intercepts
public class AutorizacaoInterceptor implements Interceptor{
	
	private final UsuarioWeb userinfo;
	private final Result result;
	private final AdministradorDao dao;
	
	public AutorizacaoInterceptor(UsuarioWeb userinfo,AdministradorDao dao,Result result) {
		this.dao = dao;
		this.result = result;
		this.userinfo = userinfo;
	}
	
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.redirectTo(AdministradorController.class).loginForm();
		
	}

	public boolean accepts(ResourceMethod method) {
		
		return !this.userinfo.isLogado() && method.containsAnnotation(Restrito.class);
		
	}

}
