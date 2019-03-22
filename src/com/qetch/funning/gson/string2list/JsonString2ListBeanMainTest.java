package com.qetch.funning.gson.string2list;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import javax.lang.model.element.Parameterizable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonString2ListBeanMainTest {

	public static void main(String[] args) {
		String jsonString1 = "[{\"name\":\"zhaoxa\",\"score\":100},{\"name\":\"zhaoxa2\",\"score\":76},{\"name\":\"zhaoxa3\",\"score\":99},{\"name\":\"zhaoxa4\",\"score\":48}]";
		String jsonString2 = "[{\"author\":\"zhaoxa\",\"name\":\"如何入门android\",\"price\":100},{\"author\":\"zhaoxa2\",\"name\":\"如何入门android2\",\"price\":76},{\"author\":\"zhaoxa3\",\"name\":\"如何入门android3\",\"price\":99},{\"author\":\"zhaoxa4\",\"name\":\"如何入门android4\",\"price\":48}]";
		
//		function1(jsonString1);
//		function2(jsonString1);
		
		/**
		 * 测试通用方法
		 */
//		List<Student> list1 = parseString2List(jsonString1);
//		System.out.println(list1);
//		List<Book> list2 = parseString2List(jsonString2);
//		System.out.println(list2);
		
//		List<Student> list1 = parseString2List2(jsonString1);
//		System.out.println(list1);
//		List<Book> list2 = parseString2List2(jsonString2);
//		System.out.println(list2);
		
		
		List<Student> list1 = new JsonString2ListBeanMainTest().parseString2List(jsonString1, Student.class);
		System.out.println(list1);
		List<Book> list2 = new JsonString2ListBeanMainTest().parseString2List(jsonString2, Book.class);
		System.out.println(list2);
	}
	
	/**
	 * 1. 先转成数组，再转成List
	 * @param jsonString
	 */
	public static void function1(String jsonString) {
		Student[] array = new Gson().fromJson(jsonString, Student[].class);
		List<Student> students = Arrays.asList(array);
		System.out.println("--->function1--->students:" + students);
	}
	
	/**
	 * 使用TypeToken进行转化
	 * @param jsonString
	 */
	public static void function2(String jsonString) {
		Type type = new TypeToken<List<Student>>() {}.getType();
		List<Student> students = new Gson().fromJson(jsonString, type);
		System.out.println("--->function2--->students:" + students);
	}
	
	/**
	 * 第一次尝试：同function1()
	 * @param jsonString
	 * @return
	 */
	/*public static <T> List<T> parseString2List(String jsonString) {
		T[] array = new Gson().fromJson(jsonString, T[].class);// 报错，fromJson不支持使用泛型解析
		List<T> list = Arrays.asList(array);
		return list;
	}*/
	
	/**
	 * 第二次尝试：同function2()
	 * 测试结果：
	 * 虽然没有报错，也能打印list的结果，但是list中的数据类型不是student，而是LinkedTreeMap，LinkedTreeMap是Gson
	 * 库内部数据类型，也就是说解析失败了。
	 * @param jsonString
	 * @return
	 */
	public static <T> List<T> parseString2List(String jsonString) {
		Type type = new TypeToken<List<T>>() {}.getType();
		List<T> list = new Gson().fromJson(jsonString, type);
		return list;
	}
	
	/**
	 * 第二次尝试：同function2()续
	 * 把泛型T去掉，运行结果一样，说明Gson解析时不支持泛型。
	 * @param jsonString
	 * @return
	 */
	public static List parseString2List2(String jsonString) {
		Type type = new TypeToken<List>() {}.getType();
		List list = new Gson().fromJson(jsonString, type);
		return list;
	}
	
	/**
	 * 3. 如何使用泛型抽象（整理出一个通用方法）
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public <T> List<T> parseString2List(String jsonString, Class clazz) {
		Type type = new ParameterizedTypeImpl(clazz);
		List<T> list = new Gson().fromJson(jsonString, type);
		return list;
	}
	
	/**
	 * 实现了ParameterizedType接口的内部类
	 * @author ZCW
	 *
	 */
	private class ParameterizedTypeImpl implements ParameterizedType {
		private Class clazz;
		
		public ParameterizedTypeImpl(Class clazz) {
			this.clazz = clazz;
		}
		
		@Override
		public Type[] getActualTypeArguments() {
			return new Type[] {clazz};
		}

		@Override
		public Type getRawType() {
			return List.class;
		}

		@Override
		public Type getOwnerType() {
			return null;
		}
	}
}
