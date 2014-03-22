package br.com.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.modelo.Tweets;
import br.com.modelo.UserTwitter;
@Component
public class TweetsDao {
	
	private final Session session;
	public TweetsDao(Session session) {
		this.session = session;
	}
	
	public void salvar(Tweets tweets) {
		Transaction tx =  session.beginTransaction();
		session.save(tweets);
		tx.commit();
	}
	
	public List<Tweets> listarTudo() {
		return session.createCriteria(Tweets.class).list();
	}
	public void atualizar(Tweets tweets){
		Transaction tx =  session.beginTransaction();
		session.update(tweets);
		tx.commit();
		
	}

	@SuppressWarnings("unchecked")
	public Collection<Tweets> carrega(UserTwitter userTwitter) {
		
        //Transaction tx = null;
        Collection<Tweets> t = null;

        try {
            Query q;

            //tx = session.beginTransaction();
            q = session.createQuery("FROM Tweets as t where t.usertwitter=:userTwitter");
            
            q.setParameter("userTwitter", userTwitter);

            t = q.list();
            //System.out.println("QuerySize: "+t.size());
            

            return t;

        } catch (Exception e) {
            
            e.printStackTrace();
            return t;
        }

	}

}
