package teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.ComponentFactory;





public class CriadorDeSession implements ComponentFactory<Session> {
	private final SessionFactory factory;
	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}
	public Session getInstance() {
		Session session = factory.openSession();	
		return session;	
	}
}