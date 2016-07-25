package app4Utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import app4domain.FormBean;

public class FormbeanUtils {
	public static FormBean registFormBean(HttpServletRequest request){
		try {
			FormBean fb = new FormBean();
			BeanUtils.populate(fb, request.getParameterMap());
			return fb;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static Object Bean(HttpServletRequest request,Class clazz){
		 try {
			Object obj = clazz.newInstance();
			BeanUtils.populate(obj, request.getParameterMap());
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T>T fillBean(HttpServletRequest request,Class<T> clazz){
		try {
			T obj = clazz.newInstance();
			BeanUtils.populate(obj, request.getParameterMap());
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
