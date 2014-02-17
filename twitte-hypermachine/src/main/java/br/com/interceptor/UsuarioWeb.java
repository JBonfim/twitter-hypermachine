package br.com.interceptor;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.modelo.Administrador;

@Component
@SessionScoped
public class UsuarioWeb {
	
	private Administrador logado;
	
	public Administrador getUser(){
		return logado;
	}
	
	public void login(Administrador usuario){
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
