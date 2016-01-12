package service.basic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.basic.BasicEntity;
import domain.entity.Report;
import domain.persistence.HibernateUtil;

public class BasicDao<T> implements BasicDaoInterface<Report> {

	private Session session = null;
	private Transaction transaction = null;

	public BasicDao() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	public BasicEntity addEntity(BasicEntity Entity) {
		try {
			session.save(Entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {

			session.close();
		}
		return Entity;
	}

	public BasicEntity deleteEntity(BasicEntity Entity) {
		Query q = session.createQuery("delete Entity where id = ?");
		q.setInteger(0, Entity.getId());
		q.executeUpdate();

		return Entity;
	}

	public BasicEntity updateEntity(BasicEntity updatedEntity) {
		try {

			session.update(updatedEntity);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {

			session.close();
		}
		return updatedEntity;
	}


	public List<BasicEntity> findAllEntities(Class className) {

		return session.createCriteria(className).list();
	}

	public Object findEntityById(int entityId, Class<Report> className) {
		return  session.load(className, new Integer(entityId));

	}

}
