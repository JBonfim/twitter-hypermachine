package br.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.modelo.UserTwitter;

@Component
public class UserTwitterDao {
	
	private final Session session;
	public UserTwitterDao(Session session) {
		this.session = session;
	}

	public void salvar(UserTwitter contaTwitter) {
		//Transaction tx =  session.beginTransaction();
		session.save(contaTwitter);
		//tx.commit();
	}

	public void alterar( UserTwitter contaTwitter) {
		//Transaction tx = session.beginTransaction();
		session.update(contaTwitter);
		//tx.commit();
	}

	public void deletar( UserTwitter contaTwitter) {
		//Transaction tx = session.beginTransaction();
		session.delete(contaTwitter);
		//tx.commit();
	}

	
	public List<UserTwitter> listarTudo() {
		return session.createCriteria(UserTwitter.class).list();
	}

	public UserTwitter carrega(long id) {
		return (UserTwitter) this.session.load(UserTwitter.class, id);
	}

}
