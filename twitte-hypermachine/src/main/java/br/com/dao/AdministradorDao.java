package br.com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.modelo.Administrador;

@Component
public class AdministradorDao {
	
	private final Session session;
	public AdministradorDao(Session session) {
		this.session = session;
	}
	
	
	public void refresh(Administrador user) {
		session.refresh(user);
	}
	public Administrador carregar(Administrador usuario){
		return (Administrador) session.createCriteria(Administrador.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.add(Restrictions.eq("senha", usuario.getSenha()))
				.uniqueResult();
	}

}
