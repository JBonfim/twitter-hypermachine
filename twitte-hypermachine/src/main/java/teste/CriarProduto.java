package teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.dao.ContaTwitterDao;
import br.com.dao.UsuarioDao;
import br.com.modelo.ContaTwitter;
import br.com.modelo.Usuario;

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
		 ContaTwitterDao dao = new ContaTwitterDao(session);
		 ContaTwitter caont = criarconta();
		 dao.salvar(caont);

	}
	public static Usuario criarUsuario(){
		Usuario usr = new Usuario();
		usr.setNome("Jose");
		usr.setLogin("Jose");
		usr.setSenha("123");
		return usr;
	}
	public static ContaTwitter criarconta(){
		ContaTwitter usr = new ContaTwitter();
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
