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
 * Home object for domain model class ProductCatalogAtrType.
 * @see .ProductCatalogAtrType
 * @author Hibernate Tools
 */
public class ProductCatalogAtrTypeHome {

	private static final Log log = LogFactory
			.getLog(ProductCatalogAtrTypeHome.class);

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

	public void persist(ProductCatalogAtrType transientInstance) {
		log.debug("persisting ProductCatalogAtrType instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductCatalogAtrType instance) {
		log.debug("attaching dirty ProductCatalogAtrType instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductCatalogAtrType instance) {
		log.debug("attaching clean ProductCatalogAtrType instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProductCatalogAtrType persistentInstance) {
		log.debug("deleting ProductCatalogAtrType instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductCatalogAtrType merge(ProductCatalogAtrType detachedInstance) {
		log.debug("merging ProductCatalogAtrType instance");
		try {
			ProductCatalogAtrType result = (ProductCatalogAtrType) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductCatalogAtrType findById(java.math.BigDecimal id) {
		log.debug("getting ProductCatalogAtrType instance with id: " + id);
		try {
			ProductCatalogAtrType instance = (ProductCatalogAtrType) sessionFactory
					.getCurrentSession().get("ProductCatalogAtrType", id);
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

	public List findByExample(ProductCatalogAtrType instance) {
		log.debug("finding ProductCatalogAtrType instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ProductCatalogAtrType")
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
