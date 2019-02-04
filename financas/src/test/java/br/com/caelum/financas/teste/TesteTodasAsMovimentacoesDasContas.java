package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		/*
		 * // Mandando uma query para o banco utilizando JPQL String jpql =
		 * "select c from Conta c"; Query query = em.createQuery(jpql);
		 * 
		 * // lista de todas as contas registradas no banco List<Conta> todasAsConta =
		 * query.getResultList();
		 * 
		 * // percorrer Conta a Conta pra saber movimentaçoes de cada conta for (Conta
		 * conta : todasAsConta) { System.out.println("Titular: " + conta.getTitular());
		 * System.out.println("Movimentacoes: ");
		 * 
		 * // aqui é feita a busca de todas as movimentaçoes de cada conta // isso é
		 * chamado de N + 1 // Pra cada uma das contas é feito o select de suas
		 * movimentaçoes // isso acontece porque os relacionamentos desse tipo:
		 * // @OneToMany(mappedBy="conta") private List<Movimentacao> movimentacoes; //
		 * sao chamados de Lazy System.out.println(conta.getMovimentacoes()); }
		 */

		// Aqui vamos alterar o comportamento para EAGER. Junto a conta as suas movimentações;
		String jpql1 = "select c from Conta c join fetch c.movimentacoes";
		Query query1 = em.createQuery(jpql1);

		// lista de todas as contas registradas no banco
		List<Conta> todasAsConta1 = query1.getResultList();

		for (Conta conta : todasAsConta1) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes: ");
			System.out.println(conta.getMovimentacoes());
		}

	}

}
