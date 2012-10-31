import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GenericProducer {

    // Name of the queue we will be sending messages to
    private static String subject = "dynamicQueues/ActiveMQ";

    public static void main(String[] args) throws JMSException, NamingException {
        Context jndiContext = new InitialContext();
        ConnectionFactory connectionFactory =
                (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // JMS messages are sent and received using a Session. We will
        // create here a non-transactional session object. If you want
        // to use transactions you should set the first parameter to 'true'
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // Destination represents here our queue 'TESTQUEUE' on the
        // JMS server. You don't have to do anything special on the
        // server to create it, it will be created automatically.
        Destination destination = (Destination) jndiContext.lookup("/queues/poyantesting");

        // MessageProducer is used for sending messages (as opposed
        // to MessageConsumer which is used for receiving them)
        MessageProducer producer = session.createProducer(destination);

        // We will send a small text message saying 'Hello' in Japanese
        TextMessage message = session.createTextMessage("POYANNN");

        // Here we are sending the message!
        producer.send(message);
        System.out.println("Sent message '" + message.getText() + "'");

        connection.close();

    }

}
