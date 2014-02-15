package teste;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ComponentFactory;


public class CriadorDeSessionFactory implements ComponentFactory<SessionFactory> {
	private final SessionFactory factory;
	public CriadorDeSessionFactory() {
		AnnotationConfiguration configuration =
				 new AnnotationConfiguration();
				 configuration.configure();
				
				 this.factory = configuration.buildSessionFactory();
	}
	public SessionFactory getInstance() {
		 
		 return factory;
	}
}