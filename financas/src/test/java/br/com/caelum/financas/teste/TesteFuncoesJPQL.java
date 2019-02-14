package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);
		
		TypedQuery<Double> query = manager.createNamedQuery("MediasPorDiaETipo", Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		List<Double> medias = query.getResultList();
		
		for (Double media : medias) {
			System.out.println("A media é: " + media);
		}

		/*
		 * String jpql =
		 * "select sum(m.valor) from Movimentacao m where m.conta = :pConta" +
		 * " and m.tipo = :pTipo" + " order by m.valor desc ";
		 */
		
		/*
		 * String jpql =
		 * "select avg(m.valor) from Movimentacao m where m.conta = :pConta" +
		 * " and m.tipo = :pTipo" +
		 * " group by day(m.data), month(m.data), year(m.data)  ";
		 */

		// encapsular num Objeto Query
		//Query query = manager.createQuery(jpql);
		/*
		 * TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
		 * query.setParameter("pConta", conta); query.setParameter("pTipo",
		 * TipoMovimentacao.SAIDA);
		 */
		
		//Double result = (Double) query.getSingleResult();
		/*
		 * List<Double> resultList = query.getResultList();
		 * 
		 * System.out.println(resultList.get(0)); System.out.println(resultList.get(1));
		 */

		manager.getTransaction().commit();
		manager.close();
	}

}
