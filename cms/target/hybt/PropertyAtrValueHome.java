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
 * Home object for domain model class PropertyAtrValue.
 * @see .PropertyAtrValue
 * @author Hibernate Tools
 */
public class PropertyAtrValueHome {

	private static final Log log = LogFactory
			.getLog(PropertyAtrValueHome.class);

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

	public void persist(PropertyAtrValue transientInstance) {
		log.debug("persisting PropertyAtrValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PropertyAtrValue instance) {
		log.debug("attaching dirty PropertyAtrValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PropertyAtrValue instance) {
		log.debug("attaching clean PropertyAtrValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PropertyAtrValue persistentInstance) {
		log.debug("deleting PropertyAtrValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PropertyAtrValue merge(PropertyAtrValue detachedInstance) {
		log.debug("merging PropertyAtrValue instance");
		try {
			PropertyAtrValue result = (PropertyAtrValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PropertyAtrValue findById(java.math.BigDecimal id) {
		log.debug("getting PropertyAtrValue instance with id: " + id);
		try {
			PropertyAtrValue instance = (PropertyAtrValue) sessionFactory
					.getCurrentSession().get("PropertyAtrValue", id);
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

	public List findByExample(PropertyAtrValue instance) {
		log.debug("finding PropertyAtrValue instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("PropertyAtrValue")
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