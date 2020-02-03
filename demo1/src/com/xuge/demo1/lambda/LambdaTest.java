package com.xuge.demo1.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 
 * 使用 lambda表达式 实现函数式编程
 * @author zx
 *
 */
public class LambdaTest {

	/**常规方法：通过for循环，过滤出符合条件的数据*/
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
	
	/**匿名内部类的方法：
	 *  1.创建过滤器处理接口： FilterProcess
	 *  2.创建一个过滤的公共方法，LambdaUtils.filter
	 *  3.调用该公共方法，并使用内部类的方式，实现过滤规则
	 **/
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
	
	
	/** lambda语法 1 （半lambda支持）
	 *   原来调用公共的过滤方法中，把内部类的写法 替换为 lambda语法
	  */
	@Test
	public void test3() {
		System.out.println("测试方法3 --------------------------------");
		
		List<String> nameList = Arrays.asList("张三","李四","王五","钱五");
		
		List<String> newList = LambdaUtils.filter(nameList, e -> e.indexOf("五") != -1);
		
		newList.stream().forEach(System.out::println);
	}
	
	
	/** lambda语法 2 （完全的lambda实现）
	 *   抛弃原来公共的过滤方法，完全使用 Stream API，和 lambda语法实现过滤
	 *  */
	@Test
	public void test4() {
		System.out.println("测试方法4 --------------------------------");
		
		List<String> nameList = Arrays.asList("张三","李四","王五","钱五");
		
		Stream<String> newStream = nameList.stream().filter(e -> e.indexOf("五") != -1);
		newStream.forEach(System.out::println);
	}
	
	/**
	 * lambda语法 3 
	 */
	@Test
	public void test5() {
		System.out.println("测试方法5 --------------------------------");
	
		List<String> nameList = Arrays.asList("张三","李四","王五","钱五");
		
		FilterProcess<String> filter1 = (x) -> x.indexOf("五") != -1;
		FilterProcess<String> filter2 = (x) -> x.indexOf("四") != -1;
		
		List<String> newList = LambdaUtils.filter(nameList, filter1);
		
		List<String> newList2 = LambdaUtils.filter(nameList, filter2);
		
		System.out.println("筛选出‘五’的名字：");
		newList.stream().forEach(System.out::println);
		
		System.out.println("筛选出‘四’的名字：");
		newList2.stream().forEach(System.out::println);
	}
}
