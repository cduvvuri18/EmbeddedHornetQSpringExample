package com.bioimagene.iii.ims.messaging;

import org.junit.Assert;
import org.junit.Test;

import com.bioimagene.iii.ims.messaging.consume.impl.ImsToConnectVReciever;
import com.bioimagene.iii.ims.messaging.publish.ImsMessagePublisher;
import com.bioimagene.iii.ims.messaging.utils.ImsMessagingBeanFactory;

public class TestMessaging {
  static {
    System.setProperty( "hornetq.data.dir", "target" );
  }

  @Test
  public void testInitialize() {
    ImsMessagingBeanFactory.getInstance();
  }

  @Test
  public void testSendRecieve() {
    ImsMessagePublisher imsMessagePublisher = ImsMessagingBeanFactory.getInstance().getPublisher();
    imsMessagePublisher.publishToConnectVOutboundQueue( "Hello" );
    try {
      Thread.sleep( 1000 );
    }catch(Exception e) {
      e.printStackTrace();
      assert(false);
    }    
    Assert.assertEquals( 1, ImsToConnectVReciever.messages.size() );
    System.out.println(ImsToConnectVReciever.messages.get( 0 ));
  }
}
