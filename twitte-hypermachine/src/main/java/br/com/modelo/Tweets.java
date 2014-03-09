package br.com.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tweets {
	
	@Id
	@GeneratedValue
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "video")
    private Video video;// Referencia ao id do video
    
    @ManyToOne
    @JoinColumn(name = "usertwitter")
    private UserTwitter usertwitter;// Referencia ao id usertwitter
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    private int popularidade;
    
    public Tweets() {
		// TODO Auto-generated constructor stub
	}
    
    public Tweets(Video video,UserTwitter usertwitter,Date data,int popularidade) {
    	this.video = video;
    	this.usertwitter = usertwitter;
    	this.data = data;
    	this.popularidade = popularidade;
		// TODO Auto-generated constructor stub
	}
    
    public int getPopularidade() {
		return popularidade;
	}
    public void setPopularidade(int popularidade) {
		this.popularidade = popularidade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUsertwitter(UserTwitter usertwitter) {
		this.usertwitter = usertwitter;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public UserTwitter getUsertwitter() {
		return usertwitter;
	}
	public Video getVideo() {
		return video;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}
