package br.com.testeTwitter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import twitter4j.Status;
import twitter4j.URLEntity;
import br.com.dao.TweetsDao;
import br.com.dao.UserTwitterDao;
import br.com.dao.MidiaDao;
import br.com.modelo.Midia;
import br.com.modelo.Tweets;
import br.com.modelo.UserTwitter;
import br.com.util.SoundcloudUtil;
import br.com.util.TwitterUtil;
import br.com.util.Validador;
import br.com.util.YoutubeUtil;

import com.google.api.services.youtube.model.Video;
import com.soundcloud.api.Http;
import com.soundcloud.api.Soundcloud;

public class TestTweets {
	
	private TwitterUtil twitterUtil;
	private Validador validador;
	private YoutubeUtil youtubeUtil;
	private SoundcloudUtil soundcloudUtil;
	
	
	private TweetsDao tweetsDao;
	private MidiaDao videoDao;
	private AnnotationConfiguration configuration;
	private SessionFactory factory;
	private Session session ;

	
	public TestTweets() {
		this.configuration = new AnnotationConfiguration();
		this.validador = new Validador();
		configuration.configure();
		 this.factory = configuration.buildSessionFactory();
		 this.session = factory.openSession();
		twitterUtil = new TwitterUtil();
		youtubeUtil = new YoutubeUtil();
		soundcloudUtil = new SoundcloudUtil();
		this.videoDao = new MidiaDao(session);
		this.tweetsDao = new TweetsDao(session);
		inicio();
		 
	}
	public void inicio(){
		
		
		 UserTwitterDao dao = new UserTwitterDao(session);
		 
		 List<UserTwitter> lista = dao.listarTudo();
		 for(UserTwitter usr:lista){
			 String usuario = usr.getNome();
			 try{
			        List<Status> estatus = twitterUtil.getTweets(usuario);
			        for(Status s : estatus){
			        	Date date = new Date();
			        	date.setDate(s.getCreatedAt().getDate());
			        	date.setMonth(s.getCreatedAt().getMonth());
			        	date.setYear(s.getCreatedAt().getYear());
			        				        	
			        	URLEntity[] urlEntities = s.getURLEntities();
			        	for(int i = 0;i<urlEntities.length;i++){
			        		System.out.println("Veio no for URL");
			        		int popularidade = s.getFavoriteCount();/// DEFINIR COMO POPULARIDADE DAS POSTAGEM <<<<<=======
			        		String url = urlEntities[i].getExpandedURL();
			        		
			        		if(validador.verificarURL(url).equals("youtube.com")){
			        			String idYoutube = validador.buscarIDYoutubeURL(url);
			        			System.out.println("idYoutube: "+idYoutube);
			        			Midia video = youtubeUtil.retrieveVideos(idYoutube);
			        			if(video.getCategoria().equals("Music")){
			        				Tweets tweets = new Tweets(video, usr,date , popularidade);
			        				adicionar(tweets, video, usr);
			        			}
			        		}
			        		else if(url.contains("soundcloud.com")){
			        			Midia musica = soundcloudUtil.retrieveMusica(url);
		        				Tweets tweets = new Tweets(musica, usr,date , popularidade);
		        				adicionar(tweets, musica, usr);
		        				
		        			}

			        	}
			        	System.out.println("========================================================== \n\n");
			        	}
			        }catch(Exception e){
			        	e.printStackTrace();
			        	System.out.println("Problema na Conexao com a Rede.....");
			        }
		}
	}
			 
			 
		 
		 
	public void adicionar(Tweets tweets,Midia midia,UserTwitter usr){
		Collection<Tweets> existe = tweetsDao.carrega(usr);
		boolean liberado =true;
		for(Tweets t:existe){
			if(t.getMidia().getLocation().equals(midia.getLocation())){
				t.setPopularidade(tweets.getPopularidade());
				tweetsDao.atualizar(t);
				System.out.println("Atualizando Dados......");
				liberado = false;
				break;
			}
		}
		if(liberado==true){
			videoDao.salvar(midia);
			System.out.println("Adicionou o video ao banco");
			tweetsDao.salvar(tweets);
			System.out.println("Adicionou uma nova postagem");
		}
	}
	
	
	public static void main(String[] args) {
		new TestTweets();
		
	}

}
