package teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.dao.UserTwitterDao;
import br.com.dao.AdministradorDao;
import br.com.modelo.UserTwitter;
import br.com.modelo.Administrador;

public class CriarProduto {
	
	public static void main(String[] args) {
//		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
//		Session session = new CriadorDeSession(factory).getInstance();
//		ProdutoDao dao = new ProdutoDao(session);
//		Produto produto = criarProduto();
//		
//		// Adi��o do produto no banco de dados
//		dao.salvar(produto);
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		 configuration.configure();
		
		 SessionFactory factory = configuration.buildSessionFactory();
		 Session session = factory.openSession();
		
//		UsuarioDao dao = new UsuarioDao(session);
//		Usuario usr  = criarUsuario();
//		dao.adiciona(usr);
		 AdministradorDao dao = new AdministradorDao(session);
		 Administrador caont = criarUsuario();
		 dao.adiciona(caont);

	}
	public static Administrador criarUsuario(){
		Administrador usr = new Administrador();
		usr.setNome("Jabes");
		usr.setLogin("JBonfim");
		usr.setSenha("123");
		return usr;
	}
	public static UserTwitter criarconta(){
		UserTwitter usr = new UserTwitter();
		usr.setNome("@JGBonfim");
		
		return usr;
	}

//	private static Produto criarProduto() {
//		Produto produto = new Produto();
//		produto.setNome("Televisao");
//		produto.setDescricao("Marca Philco");
//		produto.setPreco(3500.90);
//		return produto;
//	}

}
