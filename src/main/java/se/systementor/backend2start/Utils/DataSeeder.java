package se.systementor.backend2start.Utils;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.systementor.backend2start.model.Dog;
import se.systementor.backend2start.model.DogRepository;

@Component
public class DataSeeder {
    @Autowired
    DogRepository dogRepository;

    Faker faker = new Faker();

    public void Seed(){
        if(dogRepository.count() > 0 ){
            return;
        }
        for(int i =0; i < 100; i++) {
            dogRepository.save(RandomDog());
        }
    }

    private Dog RandomDog() {
        Dog dog = new Dog();
        dog.setAge(faker.dog().age());
        dog.setName(faker.dog().name());
        dog.setBreed(faker.dog().breed());
        dog.setGender(faker.dog().gender());
        dog.setPrice(faker.random().nextInt(4,20) * 1000);
        dog.setSize(faker.dog().size());
        return dog;
    }
}
