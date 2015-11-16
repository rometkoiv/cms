// default package
// Generated Apr 21, 2015 7:44:37 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class CstTypeAtrType.
 * @see .CstTypeAtrType
 * @author Hibernate Tools
 */
public class CstTypeAtrTypeHome {

	private static final Log log = LogFactory.getLog(CstTypeAtrTypeHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CstTypeAtrType transientInstance) {
		log.debug("persisting CstTypeAtrType instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CstTypeAtrType instance) {
		log.debug("attaching dirty CstTypeAtrType instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CstTypeAtrType instance) {
		log.debug("attaching clean CstTypeAtrType instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CstTypeAtrType persistentInstance) {
		log.debug("deleting CstTypeAtrType instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CstTypeAtrType merge(CstTypeAtrType detachedInstance) {
		log.debug("merging CstTypeAtrType instance");
		try {
			CstTypeAtrType result = (CstTypeAtrType) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CstTypeAtrType findById(java.math.BigDecimal id) {
		log.debug("getting CstTypeAtrType instance with id: " + id);
		try {
			CstTypeAtrType instance = (CstTypeAtrType) sessionFactory
					.getCurrentSession().get("CstTypeAtrType", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CstTypeAtrType instance) {
		log.debug("finding CstTypeAtrType instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("CstTypeAtrType")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
