package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import entity.ModeloAr;
import entity.Receita;

public class ReceitaDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Receita receita, Cliente cliente, ModeloAr modelo) {
		receita.setCliente(cliente);
		receita.setModeloAr(modelo);
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(receita);
		transaction.commit();
		session.close();
	}

	public List<Receita> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("from Receita");
		List<Receita> lista = query.list();
		session.close();
		return lista;
	}
}
