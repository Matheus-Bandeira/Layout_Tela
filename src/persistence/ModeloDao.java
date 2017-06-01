package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.ModeloAr;

public class ModeloDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(ModeloAr modelo) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(modelo);
		transaction.commit();
		session.close();
	}

	public void delete(ModeloAr modelo) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(modelo);
		transaction.commit();
		session.close();
	}

	public void update(ModeloAr modelo) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(modelo);
		transaction.commit();
		session.close();
	}
	
	public List<ModeloAr> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<ModeloAr> modelos = session.createQuery("from ModeloAr").list();
		session.close();
		return modelos;
	}
}
