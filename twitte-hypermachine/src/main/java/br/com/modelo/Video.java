package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Video {
	@Id
	@GeneratedValue
    private Long id;
    
	private String titulo;
    private String categoria;
    private String location;
    private String img;

    public Video() {
		// TODO Auto-generated constructor stub
	}
    public Video(String titulo,String categoria,String location,String img) {
         super();
         
         this.categoria = categoria;
         this.location = location;
         this.titulo = titulo;
         this.img = img;
    }
    public String getImg() {
		return img;
	}
    public void setImg(String img) {
		this.img = img;
	}
    public String getLocation() {
		return location;
	}
   public String getTitulo() {
	return titulo;
   }
   public void setLocation(String link) {
	this.location = link;
   }
   public void setTitulo(String titulo) {
	this.titulo = titulo;
   }
    public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}



	

}