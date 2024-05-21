package br.ufmg.dcc.luar.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.ufmg.dcc.luar.erp.model.Empresa;
import br.ufmg.dcc.luar.erp.repository.Empresas;
import br.ufmg.dcc.luar.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Inject
	private Empresas empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.salvar(empresa);
	}
		
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}
}
