package util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.Table;

/**
 * 泛型操作类
 * 
 * @author zhiqiang li
 * 
 */
public class GenericUtil {

	/**
	 * 获取类的父类的泛型
	 * 
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGeneric(Class clazz, int index) {
		Type type = clazz.getGenericSuperclass();
		if (type == null) {
			return Object.class;
		}
		if (!(type instanceof ParameterizedType)) {
			return Object.class;
		}
		ParameterizedType ptType = (ParameterizedType) type;
		Type[] types = ptType.getActualTypeArguments();
		if (types == null || types.length <= 0) {
			return Object.class;
		}
		return (Class) types[index];
	}

	/**
	 * 获取类的父类第一个泛型对象
	 * 
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenericOne(Class clazz) {
		return getSuperClassGeneric(clazz, 0);
	}
	
	/**
	 * 获取类的父类第一个泛型对象简单名称
	 * 
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getSuperClassGenericOneObjSimpleName(Class clazz) {
		return getSuperClassGeneric(clazz, 0).getSimpleName();
	}
	
	/**
	 * 获取类的父类第一个泛型对象名称
	 * 
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getSuperClassGenericOneObjName(Class clazz) {
		return getSuperClassGeneric(clazz, 0).getName();
	}
	
	/**
	 * 获取类的父类泛型实体对象表名称
	 * 
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getSuperClassGenericObjTableName(Class clazz, int index) {
		Class claxx = getSuperClassGeneric(clazz, index);
		String tableName = claxx.getSimpleName();
		tableName = (tableName.substring(0, 1)).toLowerCase() + tableName.substring(1, tableName.length());
		Table table = (Table) claxx.getAnnotation(Table.class);
		String annoTableName = table.name();
		if(annoTableName != null && !"".equals(annoTableName)){
			tableName = annoTableName;
		}
		return tableName;
	}
	
	/**
	 * 获取类的父类第一个泛型实体对象表名称
	 * 
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getSuperClassGenericOneObjTableName(Class clazz) {
		return getSuperClassGenericObjTableName(clazz, 0);
	}
}
