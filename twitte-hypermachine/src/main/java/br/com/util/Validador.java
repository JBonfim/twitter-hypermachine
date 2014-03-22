package br.com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validador {

	public String verificarURL(String url){
		List<String> strings = new ArrayList<String>();
		strings.addAll(Arrays.asList(url.split("http://www.")));//Link do Youtube com http
		String nova ="";
		if(strings.size()==1){
			strings.clear();
			strings.addAll(Arrays.asList(url.split("https://www.")));//Link do Youtube com https
		}
		for (String str : strings) {
			nova += str;
		}
		strings.clear();
		strings.addAll(Arrays.asList(nova.split("/")));
		String linkcorreto = strings.get(0);
		if(linkcorreto.equals("youtube.com")){
			return linkcorreto;
		}
		return "";
		
	}
	public String buscarIDYoutubeURL(String url){
		List<String> strings = new ArrayList<String>();
		strings.addAll(Arrays.asList(url.split("(?<=\\G.{31})")));
		String nova =strings.get(1);
		strings.clear();
		strings.addAll(Arrays.asList(nova.split("&")));
		String idYoutube = strings.get(0);
		
		return idYoutube;
		
	}

}
