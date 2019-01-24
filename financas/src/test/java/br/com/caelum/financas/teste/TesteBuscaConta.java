package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		Conta conta =em.find(Conta.class, 1);
		
		//Automaticamente o JPA conseguiu atualizar os dados da conta, atualizou pra Joao
		//Isso acontece porque o metodo find acima retorna um estado Managed, é um estado da JPA que
		//automaticamente os dados sao sincronizados
		conta.setTitular("Joao");
		conta.setAgencia("7788");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();

	}

}
