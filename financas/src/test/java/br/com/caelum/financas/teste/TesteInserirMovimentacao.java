package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInserirMovimentacao {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		//Conta conta = em.find(Conta.class, 1);
		
		String jpql = "select m from Movimentacao m join fetch m.conta where m.conta.id = 2";
		Query query = em.createQuery(jpql);
		List<Movimentacao> movimentacoes = query.getResultList();

		//List<Movimentacao> movimentacoes = conta.getMovimentacoes();

		em.close();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Movimentação: " + movimentacao.getDescricao());
		}

	}

}
