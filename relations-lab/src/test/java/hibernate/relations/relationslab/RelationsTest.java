package hibernate.relations.relationslab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class RelationsTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void init(){

        Address katowice = new Address("Katowice", "Katowicka", 10, "40-486");
        Address warszawa = new Address("Warszawa", "Warszawska", 14, "40-209");
        Address radom = new Address("Radom", "Radomska", 43, "40-732");

        Person jan = new Person("Jan", "Janowski", "9020372846", 43, Arrays.asList(katowice, warszawa));
        Person adam = new Person("Adam", "Adamowski", "9020372845", 47, Arrays.asList(radom));

        personRepository.save(jan);
        personRepository.save(adam);

    }

    @Test
    public void should() {
        // When
        List<Person> result = personRepository.findAll();
        // Then
        System.out.println("result" + result);
    }

}