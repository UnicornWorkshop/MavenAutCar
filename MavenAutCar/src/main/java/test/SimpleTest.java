package test;

import entities.*;
import services.KlientDao;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class SimpleTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		KlientDao dao = (KlientDao) context.getBean("KlientDAO", KlientDao.class);
		dao.add(new Klient("Pepa"));
	}
}