package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 所有dao的基础接口，提供对数据库的所有抽象方法
 * @author : zhengyx
 * @Descriptoin : 
 * @date :2016年3月13日 下午3:46:51
 */
public interface IBaseDao<T, PK extends Serializable> {

    /**
     * 获取session
     * 
     * @return
     */
    public Session getSession1();

    /**
     * 根据ID获取对象. 实际调用Hibernate的session.load()方法返回实体或其proxy对象. 如果对象不存在，抛出异常.
     */
    public T getById(PK id);

    /**
     * 保存对象.
     */
    public void save(T o);

    /**
     * 删除对象.
     */
    public void remove(T o);

    /**
     * 将缓存里的数据刷新到数据库里
     */
    public void flush();

    /**
     * 清除数据库缓存
     */
    public void clear();

    /**
     * 获取全部对象
     * 
     */
    public List<T> getAll();

    /**
     * 获取全部对象,带排序参数.
     */
    public List<T> getAll(String orderBy, boolean isAsc);

    /**
     * 根据ID移除对象.
     */
    public void removeById(PK id);

    /**
     * 根据属性名和属性值查询对象.
     * 
     * @return 符合条件的对象列表
     */
    public List<T> findBy(String propertyName, Object value);

    /**
     * 根据属性名和属性值查询对象,带排序参数.
     * 
     * @return 符合条件的对象列表
     */
    public List<T> findBy(String propertyName,
                          Object value,
                          String orderBy,
                          boolean isAsc);

    /**
     * 根据属性名和属性值查询单个对象.
     * 
     * @return 符合条件的唯一对象 or null
     */
    public T findUniqueBy(String propertyName, Object value);

    /**
     * 消除与 Hibernate Session 的关联
     * 
     */
    public void evit(T entity);

    /**
     * 创建Query对象.
     * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
     * 留意可以连续设置,如下：
     * 
     * <pre> dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
     * </pre>
     * 
     * 调用方式如下：
     * 
     * <pre> dao.createQuery(hql) dao.createQuery(hql,arg0);
     * dao.createQuery(hql,arg0,arg1); dao.createQuery(hql,new
     * Object[arg0,arg1,arg2]) </pre>
     * 
     * @param values 可变参数.
     */
    public Query createQuery(String hql, Object... values);

    /**
     * 创建SQLQuery对象.
     * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
     * 留意可以连续设置,如下：
     * 
     * <pre> dao.getQuery(sql).setMaxResult(100).setCacheable(true).list();
     * </pre>
     * 
     * 调用方式如下：
     * 
     * <pre> dao.createQuery(sql) dao.createQuery(sql,arg0);
     * dao.createQuery(sql,arg0,arg1); dao.createQuery(sql,new
     * Object[arg0,arg1,arg2]) </pre>
     * 
     * @param sql
     * @param values
     * @return
     */
    public Query createSQLQuery(String sql, Object... values);

    /**
     * 根据hql查询,直接使用HibernateTemplate的find函数.
     */
    @SuppressWarnings("rawtypes")
    public List find(String hql, Object... values);

    /**
     * 获取hibernatetemplate
     * 
     * @return
     */
    public HibernateTemplate getHibernateTemplate();

    /**
     * 在不同的session中关联修改过的托管对象
     */
    public void update(T entity);

    /**
     * 获取实体集合的另一种方式
     * 
     * @param condits
     * @param params
     * @return
     */
    public List<T> queryEntitysByPropertys(String[] propertys, Object... params)
            throws Exception;

    
    /**
     * 创建Criteria对象.
     * @param criterions
     * @return
     */
    public  Criteria createCriteria(Criterion... criterions);
    
    /**
     * 创建Criteria对象，带排序字段与升降序字段.
     * @param orderBy
     * @param isAsc
     * @param criterions
     * @return
     */
    public  Criteria createCriteria(String orderBy, boolean isAsc, Criterion... criterions);
}
