package br.com.controle;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

import br.com.dao.UsuarioDao;
import br.com.modelo.Usuario;
import br.com.modelo.UsuarioWeb;

@Resource
public class UsuariosController {
	
	private UsuarioDao dao;
	private Result result;
	private Validator validator;
	private final UsuarioWeb usuarioWeb;
	
	
	public UsuariosController(UsuarioDao dao,Result result,Validator validator,UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
		this.validator = validator;
		this.result = result;
		this.dao = dao;
	}
	
	public void novo(){
		
	}
	
	@Post("/usuarios")
	public void adiciona(Usuario usuario){
		if(dao.existeUsuario(usuario)){
			validator.add(new ValidationMessage("Login ja Existe", "usuario.login"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).novo();
		dao.adiciona(usuario);
		
		result.redirectTo(ContatwitterController.class).lista();
	}
	@Get("/login")
	public void loginForm(){
		System.out.println("Veio FormLogin");
	}
	@Post("/login")
	public void login(Usuario usuario){
		Usuario carregado = dao.carregar(usuario);
		if(carregado==null){
			validator.add(new ValidationMessage("Login ou Senha Incorretos", "usuario.login"));
			System.out.println("Veio Usuario Null");
			
		}
		validator.onErrorUsePageOf(this).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(ContatwitterController.class).lista();
		System.out.println("Veio Redirecionando");
//		final Usuario carregado = dao.carregar(usuario);
//		validator.checking(new Validations(){{
//			that(carregado == null),"login","Usuario ou Senha Invalido");
//		}});
//		validator.onErrorUsePageOf(this).loginForm();
//		usuarioWeb.login(carregado);
//		result.redirectTo(ProdutoController.class).lista();
	}
	@Path("/logout")
	public void logout(){
		usuarioWeb.logout();
		result.redirectTo(this).loginForm();
	}

}
