package br.com.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.modelo.Tweets;
import br.com.modelo.Video;
import org.hibernate.Transaction;

@Component
public class VideoDao {
	
	
	private final Session session;
	public VideoDao(Session session) {
		this.session = session;
	}
	
	public void salvar(Video video) {
		Transaction tx =  session.beginTransaction();
		session.save(video);
		tx.commit();
	}
	
	public List<Video> listarTudo() {
		return session.createCriteria(Video.class).list();
	}
	public Video carrega(long id) {
		return (Video) this.session.load(Video.class, id);
	}


}
