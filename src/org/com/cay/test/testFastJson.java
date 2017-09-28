package org.com.cay.test;

import java.util.ArrayList;
import java.util.List;

import org.com.cay.entity.Customer;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class testFastJson {

	// 将一个对象转换成json字符串
	@Test
	public void testObject() {
		Customer c = new Customer();
		c.setCustId(30L);
		c.setCustMobile("10086");
		c.setCustName("张三");

		System.out.println(JSON.toJSONString(c));
	}

	// 将一个对象集合转换成json字符串
	@Test
	public void testList1() {
		List<Customer> list = new ArrayList<Customer>();
		Customer c = new Customer();
		c.setCustId(30L);
		c.setCustMobile("10086");
		c.setCustName("张三");
		list.add(c);

		Customer c2 = new Customer();
		c2.setCustId(20L);
		c2.setCustMobile("10086000");
		c2.setCustName("李四");
		list.add(c2);

		System.out.println(JSON.toJSONString(list));
	}

	// fastjson默认循环引用
	// 如果在集合中存在两个或以上相同的对象，默认之后的对象使用"$ref"来引用第一个对象
	// 为了防止在传给前端解析json字符串的时候，无法解析"$ref"，
	// 则可以在解析json集合时使用SerializerFeature.DisableCircularReferenceDetect属性来禁止fastjson的循环引用
	@Test
	public void testList2() {
		List<Customer> list = new ArrayList<Customer>();
		Customer c = new Customer();
		c.setCustId(30L);
		c.setCustMobile("10086");
		c.setCustName("张三");
		list.add(c);
		list.add(c);

		// [{"custId":30,"custMobile":"10086","custName":"张三"},{"$ref":"$[0]"}]
		System.out.println(JSON.toJSONString(list));

		// [{"custId":30,"custMobile":"10086","custName":"张三"},{"custId":30,"custMobile":"10086","custName":"张三"}]
		System.out.println(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));// 禁止循环引用
	}

	// 使用禁止循环引用会造成死循环问题
	// 解决方法：需要在相互引用的两个对象中的其中一个的引用对象属性上加上@JSONField(serialize=false)来指定该属性不需要被json化
	@Test
	public void testCycle() {
		// 相互引用

		Person person = new Person();
		person.setPname("aaa");

		Role role = new Role();
		role.setRname("admin");

		person.setRole(role);
		role.setPerson(person);

		// 不使用@JSONField(serialize=false)会造成堆栈溢出
		System.out.println(JSON.toJSONString(person, SerializerFeature.DisableCircularReferenceDetect));

		System.out.println(JSON.toJSONString(role, SerializerFeature.DisableCircularReferenceDetect));
	}
}
