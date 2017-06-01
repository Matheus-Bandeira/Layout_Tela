package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.TipoDespesa;


public class TipoDespesaDao {

	Session session;
	Criteria criteria;
	Transaction transaction;
	Query query;

	public void create(TipoDespesa despesa) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(despesa);
		transaction.commit();
		session.close();
	}

	public void delete(TipoDespesa despesa) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(despesa);
		transaction.commit();
		session.close();
	}

	public void update(TipoDespesa despesa) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(despesa);
		transaction.commit();
		session.close();
	}

	public List<TipoDespesa> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<TipoDespesa> lista = session.createQuery("from TipoDespesa").list();
		session.close();
		return lista;
	}
	
	public TipoDespesa findByCode(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		TipoDespesa resp = (TipoDespesa) session.get(TipoDespesa.class, cod);
		session.close();
		return resp;
	}
}
