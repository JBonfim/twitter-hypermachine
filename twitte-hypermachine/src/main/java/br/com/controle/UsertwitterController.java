package br.com.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.dao.UserTwitterDao;
import br.com.interceptor.Restrito;
import br.com.modelo.UserTwitter;
import br.com.util.TweetsUser;

@Resource
public class UsertwitterController {
	
	private final UserTwitterDao dao;
	private final Result result;
	private final Validator validator;
	public UsertwitterController(UserTwitterDao dao,Result result,Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	@Restrito
	public void menu(){
		
	}
	
	
	
	@Restrito
	public void remover(long id) {
		UserTwitter conta = dao.carrega(id);
		dao.deletar(conta);
		this.result.redirectTo(this).lista();
		}
	
	@Path("usertwitter/lista")
	@Get
	@Restrito
	public void lista(){
		List<UserTwitter> userTwitter = new ArrayList<UserTwitter>();
		List<UserTwitter> p = dao.listarTudo();
		for(UserTwitter pro:p){
			UserTwitter c = new UserTwitter();
			c.setId(pro.getId());
			c.setNome(pro.getNome());
			userTwitter.add(c);
		}
		result.include("userTwitter", userTwitter);
	}
	@Restrito
	@Path("usertwitter/formulario")
	public void formulario(){
		
	}
	@Restrito
	@Path("usertwitter/adiciona")
	public void adiciona(UserTwitter contaTwitter) {
		if(contaTwitter.getNome() == null || contaTwitter.getNome().length()<2){
			validator.add(new ValidationMessage("Campo conta invalido verifique e tente novamente. Preencha por exemplo (@Nome)", "contaTwitter"));
		}
		validator.onErrorUsePageOf(this).formulario();
		 dao.salvar(contaTwitter);
		 //new TweetsUser();
		 this.result.redirectTo(this).lista();
		 }

}
