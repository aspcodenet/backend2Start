package se.systementor.backend2start.queue;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

    String []groups = {"DISTANS-RED","DISTANS-ORANGE","DISTANS-GUL",
            "DISTANS-GREEN","DISTANS-BLUE","DISTANS-GUL"
    };

    private final String QUEUE_NAME = "supportMessages111";

    public void main() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("128.140.81.47");
//        factory.setUsername("djk47589hjkew789489hjf894");
//        factory.setPassword("sfdjkl54278frhj7");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel( )) {



            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        }
    }
}