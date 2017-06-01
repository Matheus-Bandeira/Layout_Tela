package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Usuario;

public class UsuarioDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;

	public void create(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(usuario);
		transaction.commit();
		session.close();
	}

	public void update(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(usuario);
		transaction.commit();
		session.close();
	}

	public void delete(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(usuario);
		transaction.commit();
		session.close();
	}

	public List<Usuario> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> lista = session.createQuery("from Usuario").list();
		session.close();
		return lista;
	}

	public Usuario findByCode(Integer cod) {
		session = HibernateUtil.getSessionFactory().openSession();
		Usuario resp = (Usuario) session.get(Usuario.class, cod);
		session.close();
		return resp;
	}

	public Usuario findByLogin(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();

		query = session.createQuery("from Usuario u where u.codigo=:param1 and u.senha=:param2");
		query.setString("param1", usuario.getCodigo());
		query.setString("param2", usuario.getSenha());

		Usuario resp = (Usuario) query.uniqueResult();
		session.close();
		return resp;
	}
}
