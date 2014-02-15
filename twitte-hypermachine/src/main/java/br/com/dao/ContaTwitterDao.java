package br.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.modelo.ContaTwitter;

@Component
public class ContaTwitterDao {
	
	private final Session session;
	public ContaTwitterDao(Session session) {
		this.session = session;
	}

	public void salvar(ContaTwitter contaTwitter) {
		//Transaction tx =  session.beginTransaction();
		session.save(contaTwitter);
		//tx.commit();
	}

	public void alterar( ContaTwitter contaTwitter) {
		//Transaction tx = session.beginTransaction();
		session.update(contaTwitter);
		//tx.commit();
	}

	public void deletar( ContaTwitter contaTwitter) {
		//Transaction tx = session.beginTransaction();
		session.delete(contaTwitter);
		//tx.commit();
	}

	
	public List<ContaTwitter> listarTudo() {
		return session.createCriteria(ContaTwitter.class).list();
	}

	public ContaTwitter carrega(long id) {
		return (ContaTwitter) this.session.load(ContaTwitter.class, id);
	}

}
