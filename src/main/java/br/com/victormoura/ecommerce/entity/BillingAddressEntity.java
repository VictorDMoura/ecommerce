package br.com.victormoura.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_billing_address")
public class BillingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_address_id")
    private Long billingAddressId;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    // opcional
    @OneToOne(mappedBy = "billingAddress")
    private UserEntity user;

    public BillingAddressEntity() {
    }

    public Long getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
