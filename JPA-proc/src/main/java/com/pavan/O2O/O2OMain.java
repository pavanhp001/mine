package com.pavan.O2O;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.pavan.manager.CategoryManager;

public class O2OMain {
	private static Logger log = Logger.getLogger(O2OMain.class);

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		O2ODao o2ODao = (O2ODao)ctx.getBean("o2ODao");
		
		/* Create EntityManagerFactory */
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");

		/* Create EntityManager */
		EntityManager em = o2ODao.getEntityManager();

		Employee employee;

		employee = new Employee();
		employee.setFirstname("pranil");
		employee.setLastname("gilda");
		employee.setEmail("sdfsdf");
		
		log.info("employee Data to be load" + employee.toString());
		
		Desk desk = new Desk();
		
		desk.setLocation("hyd");
		desk.setNumber(3);
		employee.setDesk(desk);

		/*Desk desk = em.find(Desk.class, 1); // retrieves desk from database
		employee.setDesk(desk);*/
		
		//em.persist(employee);

		o2ODao.insertEmployee(employee);  // this operation should perform in @Transactional
		
		log.info("employee created");

		/*desk = em.find(Desk.class, 1); // retrieves desk from database
		desk.setEmployee(employee);
		System.out.println(desk.getEmployee());*/
		
	}

}

/*
log4j:WARN No appenders could be found for logger (org.springframework.core.env.StandardEnvironment).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
Exception in thread "main" org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.pavan.O2O.Employee.desk -> com.pavan.O2O.Desk; nested exception is java.lang.IllegalStateException: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.pavan.O2O.Employee.desk -> com.pavan.O2O.Desk
	at org.springframework.orm.jpa.EntityManagerFactoryUtils.convertJpaAccessExceptionIfPossible(EntityManagerFactoryUtils.java:298)
	at org.springframework.orm.jpa.vendor.HibernateJpaDialect.translateExceptionIfPossible(HibernateJpaDialect.java:106)
	at org.springframework.orm.jpa.JpaTransactionManager.doCommit(JpaTransactionManager.java:516)
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.processCommit(AbstractPlatformTransactionManager.java:754)
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.commit(AbstractPlatformTransactionManager.java:723)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.commitTransactionAfterReturning(TransactionAspectSupport.java:393)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:120)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at org.springframework.aop.framework.Cglib2AopProxy$DynamicAdvisedInterceptor.intercept(Cglib2AopProxy.java:622)
	at com.pavan.O2O.O2ODao$$EnhancerByCGLIB$$cdbdd5cb.insertEmployee(<generated>)
	at com.pavan.O2O.O2OMain.main(O2OMain.java:50)
Caused by: java.lang.IllegalStateException: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.pavan.O2O.Employee.desk -> com.pavan.O2O.Desk
	at org.hibernate.ejb.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1232)
	at org.hibernate.ejb.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1168)
	at org.hibernate.ejb.TransactionImpl.commit(TransactionImpl.java:81)
	at org.springframework.orm.jpa.JpaTransactionManager.doCommit(JpaTransactionManager.java:512)
	... 8 more


======================> This exception is gone by adding @OneToOne(cascade=CascadeType.ALL)  "cascade=CascadeType.ALL"  https://stackoverflow.com/questions/2302802/object-references-an-unsaved-transient-instance-save-the-transient-instance-be
*
*
*Exception in thread "main" javax.persistence.PersistenceException: org.hibernate.exception.SQLGrammarException: could not get or update next value
*
*Caused by: org.hibernate.exception.SQLGrammarException: could not get or update next value
*
*Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column 'gen_value' in 'field list'
*/
