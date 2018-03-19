package org.ssm.zhb.common.utils;

import org.dozer.Mapper;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;


/**
 * <P>dozer mapper util</P>
 * 
 * @author 韦宗华 2015年2月4日 下午3:04:41
 */
//@Resource
@Component
public class DozerMapper implements Mapper {
	protected Logger log = LoggerFactory.getLogger(DozerMapper.class);

	private Mapper mapper;

	@Required
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	public DozerMapper() {
	}

	public DozerMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * 
	 * <p>将bean属性复制到指定目标类创建的实例</p>
	 * 
	 * @param source
	 * @param destinationClass
	 * @return
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:04:36
	 */
	public <T> T map(Object source, Class<T> destinationClass) throws MappingException {
		if (source != null) {
			return this.mapper.map(source, destinationClass);
		}
		return null;
	}

	/**
	 * 
	 * <p>将bean属性复制到指定目标bean</p>
	 * 
	 * @param source
	 * @param destination
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:08:00
	 */
	public void map(Object source, Object destination) throws MappingException {
		if (source != null) {
			this.mapper.map(source, destination);
		}
	}

	/**
	 * 
	 * <p>根据指定mapId配置，将bean属性复制到指定目标类新创建的实例</p>
	 * 
	 * @param source
	 * @param destinationClass
	 * @param mapId
	 * @return
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:08:21
	 */
	public <T> T map(Object source, Class<T> destinationClass, String mapId) throws MappingException {
		if (source != null) {
			return this.mapper.map(source, destinationClass, mapId);
		}
		return null;
	}

	/**
	 * 
	 * <p>根据指定mapId配置，将bean属性复制到指定目标bean</p>
	 * 
	 * @param source
	 * @param destination
	 * @param mapId
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:12:09
	 */
	public void map(Object source, Object destination, String mapId) throws MappingException {
		this.mapper.map(source, destination, mapId);
	}

	/**
	 * 
	 * <p>复制source集合中元素属性到目标集合dest</p>
	 * 
	 * @param source
	 * @param dest
	 * @param destinationClass
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:12:40
	 */
	public <T> void map(Collection<?> source, Collection<T> dest, Class<T> destinationClass) throws MappingException {
		if ((source != null) && (source.size() > 0) && (dest != null)) {
			for (Object object : source) {
				T map = this.mapper.map(object, destinationClass);
				dest.add(map);
			}
		}
	}

	/**
	 * 
	 * <p>根据指定目标集合类创建目标集合和集合元素，并复制源集合类中元素属性到指定目标集合对应元素中</p>
	 * 
	 * @param source
	 * @param destinationClass
	 * @return
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:25:00
	 */
	public <T> List<T> map(Collection<?> source, Class<T> destinationClass) throws MappingException {
		if (source == null) {
			return null;
		}
		List<T> dest = new ArrayList<T>();
		this.map(source, dest, destinationClass);
		return dest;
	}

	/**
	 * 
	 * <p>复制source集合中元素属性到目标集合dest</p>
	 * 
	 * @param source
	 * @param dest
	 * @throws MappingException
	 * @author 韦宗华 John 2015年5月19日 下午3:12:40
	 */
	/*public <T> void map(Collection<?> source, Collection<T> dest) throws MappingException {
		if ((source != null) && (source.size() > 0) && (dest != null)) {
			this.mapper.map(source, dest);
		}
	}*/

	/**
	 * 
	 * <p>根据配置名称mapId，复制source集合中元素属性到目标集合dest</p>
	 * 
	 * @param source
	 * @param dest
	 * @param destinationClass
	 * @param mapId
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:21:12
	 */
	public <T> void map(Collection<?> source, Collection<T> dest, Class<T> destinationClass, String mapId)
			throws MappingException {
		if ((source != null) && (source.size() > 0) && (dest != null)) {
			for (Object object : source) {
				dest.add(this.mapper.map(object, destinationClass, mapId));
			}
		}
	}

	/**
	 * 
	 * <p>根据destinationCollectionClass创建目标集合，复制source集合中元素属性到目标集合</p>
	 * 
	 * @param source
	 * @param destinationClass
	 * @param destinationCollectionClass
	 * @return
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:22:01
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> Collection<T> map(Collection<?> source, Class<T> destinationClass,
			Class<? extends Collection> destinationCollectionClass) throws MappingException {
		try {
			if (source != null) {
				Collection result = getCollectionIns(destinationCollectionClass);
				if (source.size() > 0) {
					for (Object obj : source) {
						T dest = this.mapper.map(obj, destinationClass);
						result.add(dest);
					}
				}
				return result;
			}
			return null;
		} catch (Exception e) {
			throw new MappingException(e);
		}
	}

	/**
	 * 
	 * <p>根据配置名mapId，根据destinationCollectionClass创建目标集合，复制source集合中元素属性到目标集合</p>
	 * 
	 * @param source
	 * @param destinationClass
	 * @param destinationCollectionClass
	 * @param mapId
	 * @return
	 * @throws MappingException
	 * @author 韦宗华 2015年2月4日 下午3:23:26
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> Collection<T> map(Collection<?> source, Class<T> destinationClass,
			Class<? extends Collection> destinationCollectionClass, String mapId) throws MappingException {
		try {
			if ((source != null) && (destinationCollectionClass != null)) {
				Collection result = getCollectionIns(destinationCollectionClass);
				if (source.size() > 0) {
					for (Object obj : source) {
						result.add(this.mapper.map(obj, destinationClass, mapId));
					}
				}
				return result;
			}
			return null;
		} catch (Exception e) {
			throw new MappingException(e);
		}
	}

	/**
	 * 
	 * <p>根据指定集合类，创建集合实例</p>
	 * 
	 * @param destinationCollectionClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @author 韦宗华 2015年2月4日 下午3:23:54
	 */
	@SuppressWarnings("rawtypes")
	private Collection getCollectionIns(Class<? extends Collection> destinationCollectionClass)
			throws InstantiationException, IllegalAccessException {
		Collection result = null;
		if (destinationCollectionClass.isInterface()) {
			if (List.class.equals(destinationCollectionClass)) {
				result = new ArrayList();
			} else if (Set.class.equals(destinationCollectionClass)) {
				result = new HashSet();
			} else if (Queue.class.equals(destinationCollectionClass)) {
				result = new LinkedList();
			}
		} else {
			result = (Collection) destinationCollectionClass.newInstance();
		}
		return result;
	}

}