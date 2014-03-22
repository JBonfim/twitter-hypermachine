package br.com.testeTwitter;

import br.com.modelo.Midia;
import br.com.util.YoutubeUtil;


public class UsarYoutube {

	public static void main(String[] args) throws Exception {
        String textQuery = "gWAavCjVQvM";//SyePTcWE23Q
        
  
        YoutubeUtil ym = new YoutubeUtil();
  
        Midia video = ym.retrieveVideos(textQuery);
        System.out.println("Titulo: "+video.getTitulo());
    	System.out.println("Categoria: "+video.getCategoria());
    	System.out.println("Link: "+video.getLocation());
        
        System.out.println("************************************");
        
    }

}
