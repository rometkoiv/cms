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
 * Home object for domain model class ContractAtrTypeValue.
 * @see .ContractAtrTypeValue
 * @author Hibernate Tools
 */
public class ContractAtrTypeValueHome {

	private static final Log log = LogFactory
			.getLog(ContractAtrTypeValueHome.class);

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

	public void persist(ContractAtrTypeValue transientInstance) {
		log.debug("persisting ContractAtrTypeValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ContractAtrTypeValue instance) {
		log.debug("attaching dirty ContractAtrTypeValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContractAtrTypeValue instance) {
		log.debug("attaching clean ContractAtrTypeValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ContractAtrTypeValue persistentInstance) {
		log.debug("deleting ContractAtrTypeValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContractAtrTypeValue merge(ContractAtrTypeValue detachedInstance) {
		log.debug("merging ContractAtrTypeValue instance");
		try {
			ContractAtrTypeValue result = (ContractAtrTypeValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ContractAtrTypeValue findById(java.math.BigDecimal id) {
		log.debug("getting ContractAtrTypeValue instance with id: " + id);
		try {
			ContractAtrTypeValue instance = (ContractAtrTypeValue) sessionFactory
					.getCurrentSession().get("ContractAtrTypeValue", id);
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

	public List findByExample(ContractAtrTypeValue instance) {
		log.debug("finding ContractAtrTypeValue instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ContractAtrTypeValue")
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
