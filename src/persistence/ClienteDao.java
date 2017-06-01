package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import entity.Despesa;

public class ClienteDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(cliente);
		transaction.commit();
		session.close();
	}

	public void delete(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(cliente);
		transaction.commit();
		session.close();
	}

	public void update(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(cliente);
		transaction.commit();
		session.close();
	}
	
	public List<Cliente> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> clientes = session.createQuery("from Cliente").list();
		session.close();
		return clientes;
	}
	
	public Cliente findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Cliente resp =  (Cliente) session.get(Cliente.class, cod);
		session.close();
		return resp;
	}
}
