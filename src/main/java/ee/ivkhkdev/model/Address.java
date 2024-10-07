package ee.ivkhkdev.model;

import java.util.Objects;
import java.util.UUID;

public class Address {
    private UUID id;
    private String street;
    private String city;
    private String house;
    private String apartment;

    public Address() {
        this.id = UUID.randomUUID();
    }

    public Address(String city, String street, String house, String apartment) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.city = city;
        this.house = house;
        this.apartment = apartment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(house, address.house) && Objects.equals(apartment, address.apartment);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(street);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(house);
        result = 31 * result + Objects.hashCode(apartment);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
