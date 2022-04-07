package com.year3.distributedsystem.lecture5;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class PubSubTopicSubscriber implements MessageListener {
    private boolean quitMessageSubscription = false;
    public static void main (String[] args) {
    PubSubTopicSubscriber pubsubTopicsubscriber = new PubSubTopicSubscriber();
    pubsubTopicsubscriber.subscribelopic();
}
    public void subscribelopic() {
        BufferedReader inlineReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //Prompt for the JNDI topic connection factory name
            //System.out.println ("Enter the Publish Subscribe Topic Connection Factory name: ") ;
            String connectionFactoryName = "ConnectionFactory"; //inlineReader.readLine();

            // Prompt for topic name for the Pub sub
            //System.out.println ("Enter the Publish Subscribe Topic name: ") ;
            String pubsubTopicName = "dynamicTopics/testTopic"; //inlineReader.readLine () ;
            inlineReader.close();

            //Setup properties
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");

            // Look up for the administered objects of Pub sub
            InitialContext context = new InitialContext (props) ;
            TopicConnectionFactory topicConnFactory = (TopicConnectionFactory) context.lookup(connectionFactoryName);
            Topic pubsubTopic = (Topic) context.lookup (pubsubTopicName);
            context.close () ;

            // Create the MS objects from administered objects
            TopicConnection topicConnection = topicConnFactory.createTopicConnection();
            TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber topicSubscriber = topicSession.createSubscriber(pubsubTopic);
            topicSubscriber.setMessageListener(this);
            topicConnection.start();
            // Keep listening to the pub sub until
            // the Quit subscription command
            while (!quitMessageSubscription) {
                Thread.sleep (1000) ;
            }

            // Clean Up
            System.out.println ("Messages successfully listened so far. Quitting Subscription!");
            topicConnection.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            String messageContent = ((TextMessage) message).getText();
            System. out.println (messageContent);
            if ("abandon".equals(messageContent))
                quitMessageSubscription = true;
        } catch (JMSException e) {
            e.printStackTrace();
            quitMessageSubscription = true;
        }
    }
}
