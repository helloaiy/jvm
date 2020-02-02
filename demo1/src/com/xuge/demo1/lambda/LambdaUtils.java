package com.xuge.demo1.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaUtils {

	/**根据过滤器，返回过滤结果*/
	public static <T> List<T> filter(List<T> list, FilterProcess<T> processer){
		List<T> newList = new ArrayList<>();
		
		for(T t : list) {
			if(processer.process(t)) {
				newList.add(t);
			}
		}
		return newList;
	}
}
