package br.com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.modelo.Usuario;

@Component
public class UsuarioDao {
	
	private final Session session;
	public UsuarioDao(Session session) {
		this.session = session;
	}
	
	public boolean existeUsuario(Usuario usuario){
		Usuario encontrado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.uniqueResult();
		return encontrado!=null;
	}
	public void adiciona(Usuario usuario){
		//Transaction tx =  session.beginTransaction();
		session.save(usuario);
		//tx.commit();
	}
	public void refresh(Usuario user) {
		session.refresh(user);
	}
	public Usuario carregar(Usuario usuario){
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.add(Restrictions.eq("senha", usuario.getSenha()))
				.uniqueResult();
	}

}
