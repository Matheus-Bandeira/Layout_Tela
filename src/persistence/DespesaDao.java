package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Despesa;

public class DespesaDao {

	Session session;
	Criteria criteria;
	Transaction transaction;
	Query query;

	public void create(Despesa despesa) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(despesa);
		transaction.commit();
		session.close();
	}

	public void delete(Despesa despesa) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(despesa);
		transaction.commit();
		session.close();
	}

	public void update(Despesa despesa) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(despesa);
		transaction.commit();
		session.close();
	}

	public List<Despesa> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Despesa> lista = session.createQuery("from Despesa").list();
		session.close();
		return lista;
	}

	public Despesa findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Despesa resp = (Despesa) session.get(Despesa.class, cod);
		session.close();
		return resp;
	}
}
