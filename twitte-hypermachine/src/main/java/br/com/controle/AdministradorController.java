package br.com.controle;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.dao.AdministradorDao;
import br.com.interceptor.UsuarioWeb;
import br.com.modelo.Administrador;

@Resource
public class AdministradorController {
	
	private AdministradorDao dao;
	
	
	private Result result;
	private Validator validator;
	private final UsuarioWeb usuarioWeb;
	
	
	public AdministradorController(AdministradorDao dao,Result result,
			Validator validator,UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
		this.validator = validator;
		this.result = result;
		this.dao = dao;
		
	}
	
//	@SuppressWarnings({ "deprecation", "unchecked" })
//	public void adicionarTweets(){
//		List<UserTwitter> lista = userDao.listarTudo();
//		
//		 for(UserTwitter usr:lista){
//			 try{
//			        List<Status> estatus = twitterUtil.getTweets(usr.getNome());
//			        for(Status s : estatus){
//			        	Date date = new Date();
//			        	date.setDate(s.getCreatedAt().getDate());
//			        	date.setMonth(s.getCreatedAt().getMonth());
//			        	date.setYear(s.getCreatedAt().getYear());
//			        				        	
//			        	URLEntity[] urlEntities = s.getURLEntities();
//			        	for(int i = 0;i<urlEntities.length;i++){
//			        		
//			        		int popularidade = s.getFavoriteCount();/// DEFINIR COMO POPULARIDADE DAS POSTAGEM <<<<<=======
//			        		
//			        		String url = urlEntities[i].getExpandedURL();// Pega a URL da Postagem
//			        		if(validador.verificarURL(url).equals("youtube.com")){// Verifica se é uma URL valida 
//			        			String idYoutube = validador.buscarIDYoutubeURL(url);//Pegar Id da URL para pesquisar no youtube 
//			        			Video video = youtubeUtil.retrieveVideos(idYoutube);
//			        			if(video.getCategoria().equals("Music")){
//			        				Tweets tweets = new Tweets(video, usr,date , popularidade);// cria um novo Tweets
//			        				
//			        				//Carrega lista de Tweets do banco de dados do Usuario especificado e verifica se o Tweets ja foi armazenado no banco
//			        				Collection<Tweets> listweets = tweetsDao.carrega(usr);
//			        				boolean adicionar =true;
//			        				for(Tweets t:listweets){
//			        					if(t.getVideo().getLocation().equals(video.getLocation())){
//			        						System.out.println("Ja existe");
//			        						adicionar = false;
////			        						tweets.setId(t.getId());
////			        						//tweets.getVideo().setId(t.getVideo().getId());
////			        						tweetsDao.atualizar(tweets);
//			        						break;
//			        					}
//			        				}
//			        				if(adicionar==true){
//			        					videoDao.salvar(video);
//			        					tweetsDao.salvar(tweets);
//			        				}
//			        			}
//			        		}
//			        	}
//			        }
//			        
//			    }catch(Exception e){
//			        e.printStackTrace();
//			        System.out.println("Problema na Conexao com a Rede.....");
//			    }
//		 }
//		 this.result.redirectTo(UsertwitterController.class).menu();
//		 
//		 
//		 
//	}
	
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
	@Path("/")
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
