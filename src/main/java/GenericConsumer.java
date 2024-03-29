import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GenericConsumer {

    // Name of the queue we will receive messages from
    private static String subject = "/queues/poyantesting";

    public static void main(String[] args) throws JMSException, NamingException {
        Context jndiContext = new InitialContext();

        // Getting JMS connection from the server
        ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Creating session for seding messages
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        Destination destination = (Destination) jndiContext.lookup(subject);

        // MessageConsumer is used for receiving (consuming) messages
        MessageConsumer consumer = session.createConsumer(destination);

        // Here we receive the message.
        // By default this call is blocking, which means it will wait
        // for a message to arrive on the queue.
        Message message = consumer.receive();

        // There are many types of Message and TextMessage
        // is just one of them. Producer sent us a TextMessage
        // so we must cast to it to get access to its .getText()
        // method.
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message '"
                    + textMessage.getText() + "'");
        }
        connection.close();
    }
}
