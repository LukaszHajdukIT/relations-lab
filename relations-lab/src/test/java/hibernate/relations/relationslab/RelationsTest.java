package hibernate.relations.relationslab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RelationsTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void init(){
        Person jan = new Person("Jan", "Janowski", "9020372846", 43);
        Person adam = new Person("Adam", "Adamowski", "9020372845", 47);
        Person grzegorz = new Person("Grzegorz", "Grzegorzewski", "9020372844", 34);
        Person mateusz = new Person("Mateusz", "Mateuszowski", "9020372842", 23);
        Person andrzej = new Person("Andrzej", "Andrzejowski", "9020372841", 54);
        personRepository.save(jan);
        personRepository.save(adam);
        personRepository.save(grzegorz);
        personRepository.save(mateusz);
        personRepository.save(andrzej);

        Address katowice = new Address("Katowice", "Katowicka", 10, "40-486", mateusz);
        Address krakow = new Address("Kraków", "Krakowska", 17, "40-405", mateusz);
        Address warszawa = new Address("Warszawa", "Warszawska", 14, "40-209", adam);
        Address radom = new Address("Radom", "Radomska", 43, "40-732", jan);
        addressRepository.save(katowice);
        addressRepository.save(krakow);
        addressRepository.save(warszawa);
        addressRepository.save(radom);
    }

    @Test
    public void mateuszHasTwoFlats() {
        // When
        List<Address> result = addressRepository.findMateusz();
        // Then
        assertThat(result.size()).isEqualTo(2);
    }
}