package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class UserTwitter {
	@Id
	@GeneratedValue
    private Long id;
	
    private String nome;
    private String avatar;
    
    public String getAvatar() {
		return avatar;
	}
    public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    

}