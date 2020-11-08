package hibernate.relations.relationslab;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String streetName;
    private int houseNo;
    private String postalCode;
    @ManyToOne
    private Person person;

    public Address() {
    }

    public Address(String city, String streetName, int houseNo, String postalCode, Person person) {
        this.city = city;
        this.streetName = streetName;
        this.houseNo = houseNo;
        this.postalCode = postalCode;
        this.person = person;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNo=" + houseNo +
                ", postalCode='" + postalCode + '\'' +
                ", person=" + person +
                '}';
    }
}
