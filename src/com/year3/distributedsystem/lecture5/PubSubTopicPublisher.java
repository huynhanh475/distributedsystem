package com.year3.distributedsystem.lecture5;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PubSubTopicPublisher {
    public static void main (String[] args){
        PubSubTopicPublisher publisher = new PubSubTopicPublisher();
        publisher.publishMultipleMessages();
    }

    public void publishMultipleMessages() {
        BufferedReader inlineReader = new BufferedReader(new InputStreamReader(System.in) ) ;
        try {
            //Prompt for the JNDI topic connection factory name
            //System.out.println ("Enter the Publish Subscribe Topic Connection Factory name: ") ;
            String connectionFactoryName = "ConnectionFactory"; //inlineReader.readLine();

            // Prompt for topic name for the Pub sub
            //System.out.println ("Enter the Publish Subscribe Topic name: ") ;
            String pubsubTopicName = "dynamicTopics/testTopic"; //inlineReader.readLine () ;

            //Setup properties
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");

            // Look up for the administered objects of Pub Sub
            InitialContext context = new InitialContext (props) ;
            TopicConnectionFactory topicConnFactory = (TopicConnectionFactory) context.lookup(connectionFactoryName);
            Topic pubsubTopic = (Topic) context.lookup(pubsubTopicName);
            context.close();

            // Create the JMS objects from administered objects
            TopicConnection topicConnection = topicConnFactory.createTopicConnection();
            TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE) ;
            TopicPublisher topicPublisher = topicSession.createPublisher(pubsubTopic);

            // Publish multiple text messages entered one after the other
            String messageContent = null;
            while (true) {
                System.out.println ("Enter the new message to send or 'abandon' to exit the program: ") ;
                messageContent = inlineReader.readLine();
                TextMessage textMessage = topicSession.createTextMessage(messageContent);
                topicPublisher.publish(textMessage);
                if ("abandon".equals(messageContent))
                    break;
            }

            // Clean Up
            System.out.println ("Messages Successfully posted to the queue...");
            inlineReader.close();
            topicConnection.close();
        } catch (IOException | NamingException | JMSException e) {
            e.printStackTrace();
        }

    }

}
