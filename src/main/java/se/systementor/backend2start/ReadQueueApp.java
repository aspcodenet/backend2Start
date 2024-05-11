package se.systementor.backend2start;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import se.systementor.backend2start.demos.Catalog;
import se.systementor.backend2start.demos.book;
import se.systementor.backend2start.events.*;

import java.net.URL;


@ComponentScan
public class ReadQueueApp implements CommandLineRunner {


    private String queueName = "0d2f3826-77ba-49c0-9523-f19e7cfda4b0";
    @Override
    public void run(String... args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("128.140.81.47");
        factory.setUsername("djk47589hjkew789489hjf894");
        factory.setPassword("sfdjkl54278frhj7");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            EventBase base = mapper.readValue(message, EventBase.class);
            if(base.getClass() == RoomCleaningFinished.class){
                RoomCleaningFinished fin = (RoomCleaningFinished) base;
                System.out.println(" [x] Received '" + fin.CleaningByUser + "'");
            }
            if(base.getClass() == RoomCleaningStarted.class){
                RoomCleaningStarted fin = (RoomCleaningStarted) base;
                System.out.println(" [x] Received '" + fin.CleaningByUser + "'");
            }
            if(base.getClass() == RoomOpened.class){
                RoomOpened fin = (RoomOpened) base;
                System.out.println(" [x] Received '" + fin.RoomNo + "'");
            }
            if(base.getClass() == RoomClosed.class){
                RoomClosed fin = (RoomClosed) base;
                System.out.println(" [x] Received '" + fin.RoomNo + "'");
            }
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });


    }

}