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
	
	public boolean existeUsuario(Administrador usuario){
		Administrador encontrado = (Administrador) session.createCriteria(Administrador.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.uniqueResult();
		return encontrado!=null;
	}
	public void adiciona(Administrador usuario){
		Transaction tx =  session.beginTransaction();
		session.save(usuario);
		tx.commit();
		
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
