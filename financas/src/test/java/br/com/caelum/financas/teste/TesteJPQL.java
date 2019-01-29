package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta"
				+ " and m.tipo = :pTipo"
				+ " order by m.valor desc ";
		
		//encapsular num Objeto Query
		Query query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
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
