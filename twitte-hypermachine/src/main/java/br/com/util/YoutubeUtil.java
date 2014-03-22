package br.com.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import soundcloud.Search;
import br.com.modelo.Midia;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.media.mediarss.MediaCategory;
import com.google.gdata.data.media.mediarss.MediaThumbnail;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.data.youtube.YouTubeMediaGroup;
import com.soundcloud.api.Http;
import com.soundcloud.api.Soundcloud;


public class YoutubeUtil {
	
	 private static final String YOUTUBE_URL = "http://gdata.youtube.com/feeds/api/videos/";
	 private static final String YOUTUBE_EMBEDDED_URL = "http://www.youtube.com/embed/";

	 private String clientID ;
	 
	 private int maxResults = 1;
     private int timeout = 2000;
     
     private Search google;
	 
	public YoutubeUtil() {
		this.clientID = "181714817003-fh033t66nvp1854ipha0fjkhrf3f8asb.apps.googleusercontent.com";// Id de Desenvolvedor do Google
		google = new Search();
	}
	
	public Midia retrieveVideos(String idYoutube) throws Exception {
	       /// Pesquisa no youtube atraves do ID do video Ex: YOUTUBE_URL+idYoutube
			YouTubeService service = new YouTubeService(clientID);
	       service.setConnectTimeout(timeout); 
	       YouTubeQuery query = new YouTubeQuery(new URL(YOUTUBE_URL));
	 
	       query.setOrderBy(YouTubeQuery.OrderBy.VIEW_COUNT);
	       query.setFullTextQuery(idYoutube);
	       query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
	       query.setMaxResults(maxResults);
	       
	       VideoFeed videoFeed = service.query(query, VideoFeed.class); 
	       
	      
	       List<VideoEntry> videos = videoFeed.getEntries();       
	       return convertVideos(videos,idYoutube);
	 
	   }

		private Midia convertVideos(List<VideoEntry> videos , String idYoutube) {
			VideoEntry videoEntry = videos.get(0);
			String tipo="Youtube";
			YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();
	        String location = validarURL(idYoutube);
	      
	        List<MediaCategory> categories = mediaGroup.getCategories();
	        String categoria ="";
	        for(MediaCategory mc:categories){
	        	categoria =mc.getLabel();// Pega a Categoria do Video ex = music
	        }
	        List<String> thumbnails = new LinkedList<String>();
	        for (MediaThumbnail mediaThumbnail : mediaGroup.getThumbnails()) {
	            thumbnails.add(mediaThumbnail.getUrl());
	        }
	        String title = videoEntry.getTitle().getPlainText();//titulo video
	        JSONObject json =google(title);
	        Midia video = null;
	        try {
	        	if(json!=null){
	        		String genero = "";
	        		if(json.get("genre").equals("null")){
	        			 genero = (String)json.get("genre").toString();
	        		}
	        		
					String album = (String) json.get("artwork_url").toString();
					video = new Midia(title, location, categoria,album, genero, tipo);
	        	}else{
					video = new Midia(title, location, categoria,"http://static.tumblr.com/jn9hrij/20Ul2zzsr/albumart.jpg","", tipo);
	        	}
				
			} catch (JSONException e) {
				
				
			}
	        
	        
	        
			
	       return video;
	 
	   }
		private JSONObject google(String titulo){
			String url = google.search(titulo);
			JSONObject json = null;
			if(url!=null && url.contains("soundcloud.com")){
				Soundcloud soundcloud = new Soundcloud();
				String trankid;
				try {
					trankid = soundcloud.getApiUrlFromPermalink(url);
					json = Http.getJSON(soundcloud.getHttpResponse(trankid));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return json;
		}
		private String validarURL(String url){
			List<String> strings = new ArrayList<String>();
			strings.addAll(Arrays.asList(url.split("=")));
			String urlvalida ="";
			for(String str:strings){
				urlvalida+=str;
			}
			
			return urlvalida;
		}
	}
