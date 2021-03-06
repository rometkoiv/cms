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
 * Home object for domain model class EnterpriseCustomer.
 * @see .EnterpriseCustomer
 * @author Hibernate Tools
 */
public class EnterpriseCustomerHome {

	private static final Log log = LogFactory
			.getLog(EnterpriseCustomerHome.class);

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

	public void persist(EnterpriseCustomer transientInstance) {
		log.debug("persisting EnterpriseCustomer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EnterpriseCustomer instance) {
		log.debug("attaching dirty EnterpriseCustomer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EnterpriseCustomer instance) {
		log.debug("attaching clean EnterpriseCustomer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EnterpriseCustomer persistentInstance) {
		log.debug("deleting EnterpriseCustomer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EnterpriseCustomer merge(EnterpriseCustomer detachedInstance) {
		log.debug("merging EnterpriseCustomer instance");
		try {
			EnterpriseCustomer result = (EnterpriseCustomer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EnterpriseCustomer findById(java.math.BigDecimal id) {
		log.debug("getting EnterpriseCustomer instance with id: " + id);
		try {
			EnterpriseCustomer instance = (EnterpriseCustomer) sessionFactory
					.getCurrentSession().get("EnterpriseCustomer", id);
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

	public List findByExample(EnterpriseCustomer instance) {
		log.debug("finding EnterpriseCustomer instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("EnterpriseCustomer")
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
