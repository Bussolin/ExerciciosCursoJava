package program;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Pessoa;

public class Program {

		
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null,"Luis","luis@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin();
//		em.persist( p1 );
//		em.getTransaction().commit();
		System.out.println( em.find(Pessoa.class, 1));
	}
}
