package com.bioimagene.iii.ims.messaging.publish.impl;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.bioimagene.iii.ims.messaging.publish.ImsMessagePublisher;

public class ImsMessagePublisherImpl
  implements ImsMessagePublisher {
  private ConnectionFactory connectionFactory;
  private Queue queue;

  public void setConnectionFactory( ConnectionFactory connectionFactory ) {
    this.connectionFactory = connectionFactory;
  }

  public void setConnectVoutboundDestination( Queue queue ) {
    this.queue = queue;
  }

  @Override
  public void publishToConnectVOutboundQueue( String text ) {
    Connection conn = null;
    Session session = null;
    try {
      conn = connectionFactory.createConnection();
      session = conn.createSession( false, Session.AUTO_ACKNOWLEDGE );
      MessageProducer producer = session.createProducer( queue );
      TextMessage message = session.createTextMessage( text );
      producer.send( message );
    } catch( Exception e ) {
      e.printStackTrace();
    } finally {
      try { 
        session.close();
        conn.close();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }

}
