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
 * Home object for domain model class ProductProductCatalog.
 * @see .ProductProductCatalog
 * @author Hibernate Tools
 */
public class ProductProductCatalogHome {

	private static final Log log = LogFactory
			.getLog(ProductProductCatalogHome.class);

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

	public void persist(ProductProductCatalog transientInstance) {
		log.debug("persisting ProductProductCatalog instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductProductCatalog instance) {
		log.debug("attaching dirty ProductProductCatalog instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductProductCatalog instance) {
		log.debug("attaching clean ProductProductCatalog instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProductProductCatalog persistentInstance) {
		log.debug("deleting ProductProductCatalog instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductProductCatalog merge(ProductProductCatalog detachedInstance) {
		log.debug("merging ProductProductCatalog instance");
		try {
			ProductProductCatalog result = (ProductProductCatalog) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductProductCatalog findById(java.math.BigDecimal id) {
		log.debug("getting ProductProductCatalog instance with id: " + id);
		try {
			ProductProductCatalog instance = (ProductProductCatalog) sessionFactory
					.getCurrentSession().get("ProductProductCatalog", id);
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

	public List findByExample(ProductProductCatalog instance) {
		log.debug("finding ProductProductCatalog instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ProductProductCatalog")
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
