package se.systementor.backend2start;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import se.systementor.backend2start.events.RoomCleaningFinished;
import se.systementor.backend2start.events.RoomCleaningStarted;
import se.systementor.backend2start.events.RoomClosed;
import se.systementor.backend2start.events.RoomOpened;
import se.systementor.backend2start.model.Queue;
import se.systementor.backend2start.model.QueueRepository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@ComponentScan
public class QueueSystem implements CommandLineRunner {

    @Autowired
    private QueueRepository repository;

    private static Faker faker = new Faker();

    private static Random random = new Random();

    private static ObjectMapper mapper;

    @Override
    public void run(String... args) throws Exception {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        while(true){

            for(Queue q : repository.findAll()){
                if(q.getMessagesToSend() == 0 ){
                    continue;
                }
                String queueName = q.getId().toString();
                ensureQueue(queueName);

                for(int i = q.getMessagesToSend(); i >= 0; i--){
                    sendMessage(queueName, q.getRoomIdCSV().split(","));
                    q.setMessagesToSend(i);
                    repository.save(q);
                }
            }
            TimeUnit.SECONDS.sleep(30);
        }

    }


    private void sendMessage(String queueName, String[] rooms) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("128.140.81.47");
        factory.setUsername("djk47589hjkew789489hjf894");
        factory.setPassword("sfdjkl54278frhj7");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel( )) {

            String message = getJsonForMessage(rooms);
            channel.basicPublish("", queueName, null, message.getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


    }




    private String getJsonForMessage(String []rooms) throws JsonProcessingException {
        int val = random.nextInt(100);
        if(val > 60){
            RoomOpened data = new RoomOpened();
            data.TimeStamp = LocalDateTime.now().minus(Duration.ofMinutes(random.nextInt(24*60)));
            if(rooms.length > 0){
                data.RoomNo = rooms[random.nextInt(rooms.length)];
            }else{
                data.RoomNo = String.valueOf((random.nextInt(100)+1));
            }
            return mapper.writeValueAsString(data);

        }
        if(val > 30){
            RoomClosed data = new RoomClosed();
            data.TimeStamp = LocalDateTime.now().minus(Duration.ofMinutes(random.nextInt(24*60)));
            if(rooms.length > 0){
                data.RoomNo = rooms[random.nextInt(rooms.length)];
            }else{
                data.RoomNo = String.valueOf((random.nextInt(100)+1));
            }
            return mapper.writeValueAsString(data);

        }

        if(val > 15){
            RoomCleaningStarted data = new RoomCleaningStarted();
            data.TimeStamp = LocalDateTime.now().minus(Duration.ofMinutes(random.nextInt(24*60)));
            if(rooms.length > 0){
                data.RoomNo = rooms[random.nextInt(rooms.length)];
            }else{
                data.RoomNo = String.valueOf((random.nextInt(100)+1));
            }
            data.CleaningByUser =faker.name().fullName();
            return mapper.writeValueAsString(data);

        }

        RoomCleaningFinished data = new RoomCleaningFinished();
        data.TimeStamp = LocalDateTime.now().minus(Duration.ofMinutes(random.nextInt(24*60)));
        if(rooms.length > 0){
            data.RoomNo = rooms[random.nextInt(rooms.length)];
        }else{
            data.RoomNo = String.valueOf((random.nextInt(100)+1));
        }
        data.CleaningByUser =faker.name().fullName();
        return mapper.writeValueAsString(data);


    }

    private void ensureQueue(String queueName) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("128.140.81.47");
        factory.setUsername("djk47589hjkew789489hjf894");
        factory.setPassword("sfdjkl54278frhj7");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel( )) {

            channel.queueDeclare(queueName, false, false, false, null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


    }

}
