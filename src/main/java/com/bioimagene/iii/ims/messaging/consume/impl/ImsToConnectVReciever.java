package com.bioimagene.iii.ims.messaging.consume.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * </p>
 * @author duvvuric
 * @since Nov 11, 2014
 */
public class ImsToConnectVReciever
  implements MessageListener {
  Log LOGGER = LogFactory.getLog( ImsToConnectVReciever.class );

  public static final List<String> messages = new ArrayList<String>();

  @Override
  public void onMessage( final Message message ) {
    try {
      messages.add( ( (TextMessage)message ).getText() );
    } catch( final JMSException e ) {
      e.printStackTrace();
    }
  }

  public void test() {
  }
}
