package br.com.tabacaria.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.tabacaria.model.Categoria;

public class CategoriaDao extends JpaDaoBase<Categoria> implements IDao<Categoria>  {

	public Categoria buscaPorDescricao(String descricao) {
		Query query = em.createNamedQuery("Categoria.buscaPorDescricao").setParameter("descricao", descricao);
		List<Categoria> categorias = query.getResultList();
		if (!categorias.isEmpty())
			return categorias.get(0);
		return null;
	}
	
	public void remove(String descricao) {
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Categoria c WHERE c.descricao = :descricao ").setParameter("descricao", descricao);
		query.executeUpdate();
		em.getTransaction().commit();
	}
}
