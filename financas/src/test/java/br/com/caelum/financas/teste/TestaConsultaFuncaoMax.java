package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsultaFuncaoMax {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		String jpql = "select count(m.id) from Movimentacao m where m.conta = :pConta";

		Query query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);

		Long singleResult = (Long) query.getSingleResult();

		System.out.println(singleResult);

		manager.getTransaction().commit();
		manager.close();

	}

}
