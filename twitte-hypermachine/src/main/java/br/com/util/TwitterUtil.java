package br.com.util;

import java.util.List;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class TwitterUtil {
	
	//===============>>>>>>>>>>>>>> Credenciais de Desenvolvedor <<<<<<<<<<<<<==================
    private static final String twitter_consumer_key = "zwENagspUQlU0N3QqoDajQ";
    private static final String twitter_consumer_secret = "0Cvqz0fRBAUif8iS6w9CuBlu8zVxEkqOpQXoGEK2o";
    private static final String access_token = "2327421354-vv2JmSKt4kkZSp87us1cTKgnTnboYuJdg5gIJok";
    private static final String access_token_secret ="3Spe7ma4oBO3eahPi76oIZ1D4Yxn8IT1JTm7z3IXnj4In";

    private Twitter twitter;
    private int pagina = 1;
    private static final int QUANTIDADE = 10;

    /**
     * Constr�i o Twitter, j� com os dados de autentica��o
     */
    public TwitterUtil(){
        twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(twitter_consumer_key,twitter_consumer_secret);
        twitter.setOAuthAccessToken(new AccessToken(access_token, access_token_secret));
    }


    /**
     * Obt�m uma lista paginada de tu�tes do usu�rio.
     * @param username usu�rio do qual se obter� os tu�tes
     * @param pagina n�mero da p�gina
     * @param quantidade quantidade de tu�tes por p�gina
     * @return lista de tu�tes
     */
    public List getTweets(String username) {
        List tweets = null;

        try {
            if (username != null && !username.equals("")) {
                Paging p = new Paging(pagina, QUANTIDADE);
                tweets = twitter.getUserTimeline(username,p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tweets;
    }
    
    
}