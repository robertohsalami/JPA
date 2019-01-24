package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta2 {

	public static void main(String[] args) {
				
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
				
		Conta conta =em.find(Conta.class, 1);
			
		conta.setTitular("Joao");
		conta.setAgencia("456");
				
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Paulo");
		//transforma essa conta que ja foi gerenciada alguma vez pela JPA em Managed.
		//ou seja de DETACHED para MANAGED
		em2.merge(conta);
		
		em2.getTransaction().commit();
		em2.close();
		
		

	}

}
