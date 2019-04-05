package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Product;

@Component
public class ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Product> getAllProducts(){
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> productList=criteria.list();
		session.close();
		return productList;
	}
	public Product searchById(int pcode){
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, pcode);
		session.close();
		return product;
	}
	public void saveProduct(Product product){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(product);
		tr.commit();
		session.close();
	}
}
