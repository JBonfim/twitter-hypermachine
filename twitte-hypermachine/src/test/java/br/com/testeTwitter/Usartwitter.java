package br.com.testeTwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.URLEntity;
import br.com.util.TwitterUtil;
import br.com.util.Validador;

public class Usartwitter {
  
    private ArrayList<Twitter> tweets;
    private TwitterUtil twitterUtil;
    private String usuario;
    private Validador validador;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Usartwitter u = new Usartwitter();
		u.inicialise("@JDBonfim");

	}

	private void inicialise(String username) {
		this.twitterUtil = new TwitterUtil();
		this.validador = new Validador();
		nomeUsuario(username);
		
		
	}

	private void nomeUsuario(String username) {
		usuario = username;
        //nome = (twitterUtil.getScreenName(usuario));s
        carregar();
	}
	

	private void carregar() {
        
        List<Status> estatus = twitterUtil.getTweets(usuario);
        System.out.println("Size: "+estatus.size());
        
        for(Status s : estatus){
        	Date data = s.getCreatedAt();
        	System.out.println("Data: "+data.getDate()+"/"+data.getMonth()+"/"+(data.getYear()+1900));
        	
        	URLEntity[] urlEntities = s.getURLEntities();
        	for(int i = 0;i<urlEntities.length;i++){
        		String url = urlEntities[i].getExpandedURL();
        		if(validador.verificarURL(url).equals("youtube.com")){
        			System.out.println("Link: "+url+"\n Conectando com youtube....");
        		}
        		
        		
        	}
        	System.out.println("========================================================== \n\n");
        }
	}
}
