package br.com.controle;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;
import br.com.dao.UserTwitterDao;
import br.com.interceptor.Restrito;
import br.com.modelo.UserTwitter;

@Resource
public class UsertwitterController {
	//private static final Logger LOG = Logger.getLogger(ContatwitterController.class);
	
	private final UserTwitterDao dao;
	private final Result result;
	private final Validator validator;
	public UsertwitterController(UserTwitterDao dao,Result result,Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	@Restrito
	@Path("usertwitter/editar")
	@Get
	public UserTwitter editar(long id) {
		return dao.carrega(id);
		}
	@Restrito
	public void altera(UserTwitter contaTwitter) {
		dao.alterar(contaTwitter);
		this.result.redirectTo(this).lista();
		
		}
	
	
	public void menu(){
		
	}
	@Restrito
	public void remover(long id) {
		UserTwitter produto = dao.carrega(id);
		dao.deletar(produto);
		this.result.redirectTo(this).lista();
		}
	
	@Path("usertwitter/lista")
	@Get
	@Restrito
	public void lista(){
		List<UserTwitter> contaTwitter = new ArrayList<UserTwitter>();
		List<UserTwitter> p = dao.listarTudo();
		for(UserTwitter pro:p){
			UserTwitter c = new UserTwitter();
			c.setId(pro.getId());
			c.setNome(pro.getNome());
			contaTwitter.add(c);
		}
		result.include("contaTwitter", contaTwitter);
	}
	@Restrito
	@Path("usertwitter/formulario")
	public void formulario(){
		
	}
	@Restrito
	@Path("usertwitter/adiciona")
	public void adiciona(final UserTwitter contaTwitter) {
		if(contaTwitter.getNome() == null || contaTwitter.getNome().length()<2){
			validator.add(new ValidationMessage("Campo conta invalido verifique e tente novamente. Preencha por exemplo (@Nome)", "contaTwitter"));
			System.out.println("Veio Usuario Null");
			
		}
		validator.onErrorUsePageOf(this).formulario();
		
		 dao.salvar(contaTwitter);
		 this.result.redirectTo(this).lista();
		 }

}
