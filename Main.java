package com.hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(City.class).buildSessionFactory();
		
		Session  session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//hql->hiberbate query language
			//from City c where c.countryCode = 'USA' OR c.countryCode ='TUR'
			//from City c ORDER BY c.name  ASC // isme göre sırala
			//ASC -> Ascenging // başlangıçta bunla gelir (Yükselme)
			//from City c ORDER BY c.name  DESC // Tersten sırala 
			//DESC -> Descending(Alçalma) //yukarıdan aşağıda
			//select c.countryCode from City c GROUP BY c.countryCode"  //ülke kodlarına göre çekiyor
			
			/*    //veritababnından veri çekerken kullan
			List<String> countryCodes = session.createQuery("").getResultList();
			
				for (String countryCode :countryCodes) {
					System.out.println(countryCode);
	
						}
*/
			
			/*  //Hibernate ile veri ekleme+  // insert kodu 
			
			City city = new City();
			city.setName("adana 100");
			city.setCountryCode("TUR");
			city.setDistrict("Akdeniz");
			city.setPopulation(1000000);
			session.save(city);
			
			*/
			
			//update
			/*
			City city = session.get(City.class, 4081);
			
			city.setPopulation(154878);
			session.save(city);
			*/
			
			//Delete islemleri yapıalcak
			
			@SuppressWarnings("deprecation")
			City city =session.get(City.class, 4102 );
			session.delete(city);
			
			
			session.getTransaction().commit();
			System.out.println("Silme başarılı");
		//	System.out.println(city.getName());
			
			
		} finally {
			factory.close();
		}

	}

}
