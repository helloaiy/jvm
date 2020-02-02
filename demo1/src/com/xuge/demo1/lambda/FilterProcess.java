package com.xuge.demo1.lambda;

/**
 * 过滤器
 * @author zx
 *
 * @param <T>
 */
public interface FilterProcess<T> {
	
	boolean process(T t);
}
