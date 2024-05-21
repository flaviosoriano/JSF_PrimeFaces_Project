package br.ufmg.dcc.luar.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufmg.dcc.luar.erp.model.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Empresas() {
		
	};
	
	public Empresas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Empresa procuraPorId(long id) {
		return manager.find(Empresa.class, id);
	}
	
	public List<Empresa> pesquisarPorNome(String nome){
		TypedQuery<Empresa> query = manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		return query.getResultList();
	}
	
	public Empresa salvar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = procuraPorId(empresa.getId());
		manager.remove(empresa);
	}
	
}










