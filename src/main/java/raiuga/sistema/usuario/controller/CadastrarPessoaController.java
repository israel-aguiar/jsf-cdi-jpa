package raiuga.sistema.usuario.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import raiuga.sistema.model.PessoaModel;
import raiuga.sistema.repository.PessoaRepository;
import raiuga.sistema.util.Util;
 
@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {
 
	@Inject
	PessoaModel pessoaModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	PessoaRepository pessoaRepository;
 
 
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
 
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void salvarNovaPessoa(){
 
		pessoaModel.setUsuarioModel(this.usuarioController.getUsuarioSession());
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");
 
		pessoaRepository.salvarNovoRegistro(this.pessoaModel);
 
		this.pessoaModel = null;
 
		Util.MensagemInfo("Registro cadastrado com sucesso");
 
	}
 
}