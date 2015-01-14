package com.bioimagene.iii.ims.messaging.publish;

public interface ImsMessagePublisher {

  void publishToConnectVOutboundQueue( String text );

}
