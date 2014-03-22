package br.com.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.dao.TweetsDao;
import br.com.dao.UserTwitterDao;
import br.com.dao.MidiaDao;
import br.com.modelo.Midia;
import br.com.modelo.Tweets;
import br.com.modelo.UserTwitter;
import br.com.util.MidiaUser;

@Resource
public class WebSiteController {
	
	private MidiaDao midiaDao;
	private TweetsDao tweetsDao;
	private UserTwitterDao userDao;
	private Result result;
	private List<UserTwitter> litUsres;
	
	public WebSiteController(MidiaDao midiaDao,UserTwitterDao userDao,TweetsDao tweetsDao,Result result) {
		
		this.result = result;
		
		this.midiaDao = midiaDao;
		this.userDao = userDao;
		this.tweetsDao = tweetsDao;
	}
	
	@Path("/")
	@Get
	public void home(){
		//Musicas Mais Curtida
		List<Tweets> tweets = tweetsDao.listarTudo();
		Midia v=null;
		int popular =0;
		for(Tweets tw:tweets){
			if(tw.getPopularidade()>popular){
				popular = tw.getPopularidade();
				v= tw.getMidia();
			}
		}
		listavideos();
		listamusicas();
		result.include("v", v);
	}
	
	
	@Path("/listavideos")
	@Get
	public void listavideos(){
		//Lista Musicas Usando o Youtube
		List<Midia> litvideos = new ArrayList<Midia>();
		List<Tweets> tweets = tweetsDao.listarTudo();
				
		for(Tweets tw:tweets){
			if(tw.getMidia().getTipo().equals("Youtube")){
				litvideos.add(tw.getMidia());
			}
		}
		result.include("litvideos", litvideos);
	}
	@Path("/listamusicas")
	@Get
	public void listamusicas(){
		//Lista Musicas Usando o Soundcloud
		List<Midia> litmusicas = new ArrayList<Midia>();
		List<Tweets> tweets = tweetsDao.listarTudo();
		for(Tweets tw:tweets){
			if(tw.getMidia().getTipo().equals("Soundcloud")){
				litmusicas.add(tw.getMidia());
			}
		}

		result.include("litmusicas", litmusicas);
	}

	public void listaUsuarios(String location){
		//Lista Usuarios que Twwets uma Midia
		List<Tweets> tweets = tweetsDao.listarTudo();
		litUsres = new ArrayList<UserTwitter>();
		for(Tweets tw:tweets){
			if(tw.getMidia().getLocation().equals(location)){
				litUsres.add(tw.getUsertwitter());
			}
		}
		result.include("litUsres", litUsres);
	}
	
	
	public void midiaAlbum(int id){
		//Recebe o Id para pegar o album da midia
		Midia midia = midiaDao.carrega(id);
		result.include("midia", midia);
	}
	
}
