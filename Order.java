package gla.delivery.deliveryback.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String namee;
    private String country;
    @Column(name="address_line1")
    private String addressline1;
    @Column(name="address_line2")
    private String addressline2;
    private String city;
    @Column(name="postal_code")
    private String postalcode;
    private String phone;
    @Column(name="additionnal_notes")
    private String additionnalnotes;
    private String gate_code;

    public Order() {
    }

    public Order(String namee, String country, String adressline1, String adressline2, String city, String postal_code, String phone, String additionnal_notes, String gate_code) {

        this.namee = namee;
        this.country = country;
        this.addressline1 = adressline1;
        this.addressline2 = adressline2;
        this.city = city;
        this.postalcode = postal_code;
        this.phone = phone;
        this.additionnalnotes = additionnal_notes;
        this.gate_code = gate_code;
    }

    public long getId() {
        return id;
    }



    public String getName() {
        return namee;
    }

    public void setName(String namee) {
        this.namee = namee;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postalcode;
    }

    public void setPostal_code(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdditionnalnotes() {
        return additionnalnotes;
    }

    public void setAdditionnalnotes(String additionnalnotes) {
        this.additionnalnotes = additionnalnotes;
    }

    public String getGate_code() {
        return gate_code;
    }

    public void setGate_code(String gate_code) {
        this.gate_code = gate_code;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + namee + '\'' +
                ", country='" + country + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postalcode + '\'' +
                ", phone='" + phone + '\'' +
                ", additionnal_notes='" + additionnalnotes + '\'' +
                ", gate_code='" + gate_code + '\'' +
                '}';
    }
}
