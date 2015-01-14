package com.bioimagene.iii.ims.messaging.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bioimagene.iii.ims.messaging.publish.ImsMessagePublisher;

public class ImsMessagingBeanFactory {
  private static final String SPRING_CONFIG_FILE = "classpath:spring-config/spring-messaging.xml";
  
  private static volatile ImsMessagingBeanFactory instance = null;
  private ClassPathXmlApplicationContext ctx;

  private ImsMessagingBeanFactory() {
    ctx = new ClassPathXmlApplicationContext( SPRING_CONFIG_FILE );
  }
  
  public static synchronized ImsMessagingBeanFactory getInstance() {
    if ( instance == null ) {
      instance = new ImsMessagingBeanFactory();
    }
    return instance;
  }
  
  public ImsMessagePublisher getPublisher() {
    return (ImsMessagePublisher)ctx.getBean( "imsMessagePublisher" );
  }
}