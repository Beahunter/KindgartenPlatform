package dao.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import util.GenericUtil;
import dao.IBaseDao;


/**
 * 所有dao基础父类，实现对数据库的所有操作
 * 所有dao需要继承此父类
 * @author : zhengyx
 * @Descriptoin : 
 * @date :2016年3月13日 下午3:49:32
 */
public abstract class BaseDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements IBaseDao<T, PK> {
    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = GenericUtil
            .getSuperClassGenericOne(getClass());
    public Session getSession1(){
        return getSession();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T getById(PK id) {
        // TODO Auto-generated method stub
        return (T) getHibernateTemplate().load(entityClass, id);
    }

    @Override
    public void save(T entity) {
        // TODO Auto-generated method stub
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        // TODO Auto-generated method stub
        getHibernateTemplate().update(entity);
    }
    
    @Override
    public void remove(T entity) {
        // TODO Auto-generated method stub
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        getHibernateTemplate().flush();
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        getHibernateTemplate().clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        // TODO Auto-generated method stub
        return (List<T>)(getHibernateTemplate().loadAll(entityClass));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(String orderBy, boolean isAsc) {
        // TODO Auto-generated method stub
        Assert.hasText(orderBy);
        if (isAsc)
            return getHibernateTemplate().findByCriteria(
                    DetachedCriteria.forClass(entityClass).addOrder(Order.asc(orderBy)));
        else
            return getHibernateTemplate().findByCriteria(
                    DetachedCriteria.forClass(entityClass).addOrder(Order.desc(orderBy)));
    }

    @Override
    public void removeById(PK id) {
        // TODO Auto-generated method stub
       remove(getById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findBy(String propertyName, Object value) {
        // TODO Auto-generated method stub
        Assert.hasText(propertyName);
        return createCriteria(Restrictions.eq(propertyName, value)).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findBy(String propertyName,
                          Object value,
                          String orderBy,
                          boolean isAsc) {
        // TODO Auto-generated method stub
        Assert.hasText(propertyName);
        Assert.hasText(orderBy);
        return createCriteria(orderBy, isAsc, Restrictions.eq(propertyName, value)).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findUniqueBy(String propertyName, Object value) {
        // TODO Auto-generated method stub
        Assert.hasText(propertyName);
        return (T) createCriteria(Restrictions.eq(propertyName, value)).uniqueResult();
    }

    @Override
    public void evit(T entity) {
        // TODO Auto-generated method stub
        getHibernateTemplate().evict(entity);
    }

    @Override
    public Query createQuery(String hql, Object... values) {
        // TODO Auto-generated method stub
        Assert.hasText(hql);
     //   hql="from User";
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query;
    }

    @Override
    public Query createSQLQuery(String sql, Object... values) {
        // TODO Auto-generated method stub
        Assert.hasText(sql);
        Query query = getSession().createSQLQuery(sql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List find(String hql, Object... values) {
        // TODO Auto-generated method stub
        Assert.hasText(hql);
        return getHibernateTemplate().find(hql, values);
    }



    @Override
    public List<T> queryEntitysByPropertys(String[] propertys, Object... params)
            throws Exception {
        // TODO Auto-generated method stub
        return queryEntitysByPropertys(null, propertys, params);
    }

    /**
     * 创建Criteria对象.
     * @param criterions 可变的Restrictions条件列表
     */
    @Override
    public  Criteria createCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }
    
    /**
     * 创建Criteria对象，带排序字段与升降序字段.
     */
    @Override
    public  Criteria createCriteria(String orderBy, boolean isAsc, Criterion... criterions) {
        Assert.hasText(orderBy);
        Criteria criteria = createCriteria(criterions);
        if (isAsc)
            criteria.addOrder(Order.asc(orderBy));
        else
            criteria.addOrder(Order.desc(orderBy));
        return criteria;
    }
    
    /**
     * 获取实体集合的另一种方式
     * 
     * @param propertys
     * @param params
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> queryEntitysByPropertys(LinkedHashMap<String, String> orderbys,
                                           String[] propertys,
                                           Object... params) {
        String hql = "from " + entityClass.getSimpleName() + " o ";
        if (params != null && params.length > 0) {
            if (propertys != null && propertys.length > 0) {
                StringBuffer buffer = new StringBuffer();
                for ( String condit : propertys ) {
                    buffer.append(" and ").append("o.").append(condit)
                            .append("=?");
                }
                String str = buffer.toString();
                if (str != null && str.trim().length() > 0) {
                    str = str.trim();
                    if (str.startsWith("and") || str.startsWith("AND")) {
                        str = str.substring(3);
                    }
                    hql += " where " + str;
                }
            }
        } else {
            if (propertys != null && propertys.length > 0) {
                StringBuffer buffer = new StringBuffer();
                for ( String condit : propertys ) {
                    buffer.append(" and ").append(condit);
                }
                String str = buffer.toString();
                if (str != null && str.trim().length() > 0) {
                    str = str.trim();
                    if (str.startsWith("and") || str.startsWith("AND")) {
                        str = str.substring(3);
                    }
                    hql += " where " + str;
                }
            }
        }

        if (orderbys != null && orderbys.size() > 0) {
            StringBuffer buffer = new StringBuffer(" order by ");
            for ( Entry<String, String> entry : orderbys.entrySet() ) {
                buffer.append(" o.").append(entry.getKey()).append(" ")
                        .append(entry.getValue()).append(",");
            }
            buffer.deleteCharAt(buffer.length() - 1);
            hql += buffer.toString();
        }
         Query query =null;
         Session session =getSession1(); 
         query = session.createQuery(hql);

        if (params != null && params.length > 0) {
            for ( int x = 0; x < params.length; x++ ) {
                query.setParameter(x, params[x]);
            }
        }
        return (List<T>) query.list();
    }
}
