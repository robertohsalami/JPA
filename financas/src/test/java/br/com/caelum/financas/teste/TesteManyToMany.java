package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteManyToMany {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		Categoria categoria = new Categoria();
		categoria.setId(1);

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		// encapsular num Objeto Query
		Query query = manager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getId());
			System.out.println("Valor: " + movimentacao.getValor());
		}

		manager.getTransaction().commit();
		manager.close();

	}

}
