package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;
import model.User;

public class UserHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserMediaList");
	
	public void insertUser(User s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> showAllUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT s FROM User s").getResultList();
		return allUsers;
	}
	
	public User searchForUserByName(String userName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select s from Shopper s where s.shopperName = :selectedName", User.class);
		typedQuery.setParameter("selectedName", userName);
		typedQuery.setMaxResults(1);

		User found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
}
