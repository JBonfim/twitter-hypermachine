package br.com.controle;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.dao.AdministradorDao;
import br.com.dao.TweetsDao;
import br.com.dao.UserTwitterDao;
import br.com.dao.VideoDao;
import br.com.interceptor.UsuarioWeb;
import br.com.modelo.Administrador;
import br.com.testeTwitter.TestTweets;

@Resource
public class AdministradorController {
	
	private AdministradorDao dao;
	private VideoDao videoDao;
	private TweetsDao tweetsDao;
	private UserTwitterDao userDao;
	
//	private TwitterUtil twitterUtil = new TwitterUtil();
//	private Validador validador = new Validador();
//	private YoutubeUtil youtubeUtil = new YoutubeUtil();
	
	private Result result;
	private Validator validator;
	private final UsuarioWeb usuarioWeb;
	
	
	public AdministradorController(AdministradorDao dao,VideoDao videoDao,UserTwitterDao userDao,TweetsDao tweetsDao,Result result,
			Validator validator,UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
		this.validator = validator;
		this.result = result;
		this.dao = dao;
		this.videoDao = videoDao;
		this.userDao = userDao;
		this.tweetsDao = tweetsDao;
		
	}
	

	
	public void novo(){
		
	}
	
	@Post("/usuarios")
	public void adiciona(Administrador usuario){
		if(dao.existeUsuario(usuario)){
			validator.add(new ValidationMessage("Login ja Existe", "usuario.login"));
		}
		validator.onErrorUsePageOf(AdministradorController.class).novo();
		dao.adiciona(usuario);
		
		result.redirectTo(UsertwitterController.class).lista();
	}
	@Path("/loginForm")
	@Get
	public void loginForm(){
		System.out.println("Veio FormLogin");
	}
	@Post("/login")
	public void login(Administrador usuario){
		Administrador carregado = dao.carregar(usuario);
		if(carregado==null){
			validator.add(new ValidationMessage("Login ou Senha Incorretos", "usuario"));
			System.out.println("Veio Usuario Null");
			
		}
		validator.onErrorUsePageOf(this).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(UsertwitterController.class).menu();
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
