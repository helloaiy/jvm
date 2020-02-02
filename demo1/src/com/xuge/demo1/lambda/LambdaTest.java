package com.xuge.demo1.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 
 * @author zx
 *
 */
public class LambdaTest {

	/**常规方法*/
	@Test
	public void test1() {
		System.out.println("测试方法1 --------------------------------");
		
		//筛选出名字中带 “五”的名字
		List<String> nameList = Arrays.asList("张三","李四","王五","钱五");
		
		List<String> newList = new ArrayList<>();
		for(String str : nameList) {
			if(str.indexOf("五") != -1) {
				newList.add(str);
			}
		}
		
		newList.stream().forEach(System.out::println);
	}
	
	/**匿名内部类的方法*/
	@Test
	public void test2() {
		System.out.println("测试方法2 --------------------------------");
		List<String> nameList = Arrays.asList("张三","李四","王五","钱五");
		
		List<String> newList = LambdaUtils.filter(nameList, new FilterProcess<String>() {
			public boolean process(String str) {
				return str.indexOf("五") != -1;
			}
		});
		newList.stream().forEach(System.out::println);
	}
	
	
	/** lambda语法 1 */
	@Test
	public void test3() {
		System.out.println("测试方法3 --------------------------------");
		
		List<String> nameList = Arrays.asList("张三","李四","王五","钱五");
		
		List<String> newList = LambdaUtils.filter(nameList, e -> e.indexOf("五") != -1);
		
		newList.stream().forEach(System.out::println);
	}
	
	
	/** 终极 lambda语法 2 */
	@Test
	public void test4() {
		System.out.println("测试方法4 --------------------------------");
		
		List<String> nameList = Arrays.asList("张三","李四","王五","钱五");
		
		Stream<String> newStream = nameList.stream().filter(e -> e.indexOf("五") != -1);
		
		newStream.forEach(System.out::println);
	}
	
}
