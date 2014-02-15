package br.com.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb {
	
	private Usuario logado;
	
	public Usuario getUser(){
		return logado;
	}
	
	public void login(Usuario usuario){
		this.logado = usuario;
		
	}
	public String getNome(){
		return this.logado.getNome();
	}
	
	public boolean isLogado(){
		return logado!=null;
	}
	public void logout(){
		this.logado = null;
	}
	

}
