package br.com.util;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import br.com.modelo.Video;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.media.mediarss.MediaCategory;
import com.google.gdata.data.media.mediarss.MediaThumbnail;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.data.youtube.YouTubeMediaGroup;


public class YoutubeUtil {
	
	 private static final String YOUTUBE_URL = "http://gdata.youtube.com/feeds/api/videos/";
	 private static final String YOUTUBE_EMBEDDED_URL = "http://www.youtube.com/v/";

	 private String clientID ;
	 
	 private int maxResults = 1;
     private int timeout = 2000;
	 
	public YoutubeUtil() {
		this.clientID = "181714817003-fh033t66nvp1854ipha0fjkhrf3f8asb.apps.googleusercontent.com";// Id de Desenvolvedor do Google
	}
	
	public Video retrieveVideos(String textQuery) throws Exception {
       
		YouTubeService service = new YouTubeService(clientID);
       service.setConnectTimeout(timeout); 
       YouTubeQuery query = new YouTubeQuery(new URL(YOUTUBE_URL));
 
       query.setOrderBy(YouTubeQuery.OrderBy.VIEW_COUNT);
       query.setFullTextQuery(textQuery);
       query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
       query.setMaxResults(maxResults);
       
       VideoFeed videoFeed = service.query(query, VideoFeed.class); 
      
       List<VideoEntry> videos = videoFeed.getEntries();       
       return convertVideos(videos,textQuery);
 
   }

	private Video convertVideos(List<VideoEntry> videos , String idYoutube) {
		VideoEntry videoEntry = videos.get(0);
		YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();
        String webPlayerUrl = YOUTUBE_EMBEDDED_URL+idYoutube;
      
        List<MediaCategory> categories = mediaGroup.getCategories();
        String categoria ="";
        for(MediaCategory mc:categories){
        	categoria =mc.getLabel();// Categoria do Video ex = music
        }
        List<String> thumbnails = new LinkedList<String>();
        for (MediaThumbnail mediaThumbnail : mediaGroup.getThumbnails()) {
            thumbnails.add(mediaThumbnail.getUrl());
        }
        String title = videoEntry.getTitle().getPlainText();//titulo video
        String img = thumbnails.get(1);
        Video video = new Video(title, categoria, webPlayerUrl, img);
		
       return video;
 
   }
}
