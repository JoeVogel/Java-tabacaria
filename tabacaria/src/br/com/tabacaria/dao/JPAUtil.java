package br.com.tabacaria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("tabacaria");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public static void main(String[] args) {
		JPAUtil.getEntityManager();
	}
	
}
