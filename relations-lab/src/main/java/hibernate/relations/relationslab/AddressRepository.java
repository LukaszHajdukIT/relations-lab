package hibernate.relations.relationslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select Address from Address a where a.person = :person")
    List<Address> findMateusz(@Param("person") Person person);
}
