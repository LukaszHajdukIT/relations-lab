package hibernate.relations.relationslab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class RelationTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void should() {
        // Given
        Address katowice = addressRepository.save(new Address("Katowice", "Katowicka", 10, "40-456"));
        Address krakow = addressRepository.save(new Address("Krakow", "Krakowska", 12, "40-756"));

        Person jan = personRepository.save(new Person("Jan", "Janowski", "90983647581", 20));
        Person adam = personRepository.save(new Person("Adam", "Adamowski", "90983647531", 26));
        Person andrzej = personRepository.save(new Person("Andrzej", "Andrzejowski", "94983647581", 45));
        Person grzegorz = personRepository.save(new Person("Grzegorz", "Grzegorzweski", "90583647581", 34));
        // When
        katowice.setPersons(Stream.of(jan, adam).collect(Collectors.toSet()));
        krakow.setPersons(Stream.of(andrzej, grzegorz).collect(Collectors.toSet()));

        addressRepository.save(katowice);
        addressRepository.save(krakow);

        // Then
        List<Address> allAddresses = addressRepository.findAll();
        List<Person> allPersons = personRepository.findAll();
        System.out.println("result" + allAddresses);
        System.out.println("result" + allPersons);

        assertThat(allAddresses).isNotEmpty();
        assertThat(allPersons).isNotEmpty();

    }

}