package br.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.modelo.Tweets;
import br.com.modelo.UserTwitter;

@Component
public class UserTwitterDao {
	
	private final Session session;
	public UserTwitterDao(Session session) {
		this.session = session;
	}

	public void salvar(UserTwitter contaTwitter) {
		session.save(contaTwitter);
	}

	public void atualizar(UserTwitter contaTwitter){
		Transaction tx =  session.beginTransaction();
		session.update(contaTwitter);
		tx.commit();
		
		
	}

	public void deletar( UserTwitter contaTwitter) {
		session.delete(contaTwitter);
	}

	
	public List<UserTwitter> listarTudo() {
		return session.createCriteria(UserTwitter.class).list();
	}

	public UserTwitter carrega(long id) {
		return (UserTwitter) this.session.load(UserTwitter.class, id);
	}

}
