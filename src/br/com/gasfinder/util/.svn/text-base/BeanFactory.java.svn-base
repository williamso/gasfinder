package br.com.gasfinder.util;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {

	private static ClassPathXmlApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext("br/com/gasfinder/config/spring.xml");
	}

	private BeanFactory() {
	}

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getBean(String beanName, Class classe) {
		return ctx.getBean(beanName, classe);
	}

	public static SessionFactory getSessionFactory(){
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory", SessionFactory.class);
		return sf;
	}
}
