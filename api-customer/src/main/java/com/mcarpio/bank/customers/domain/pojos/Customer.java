package com.mcarpio.bank.customers.domain.pojos;
import com.mcarpio.bank.people.domain.pojos.Person;

public class Customer extends Person {

    private Integer customerId;
    private String password;
    private Boolean status;

    public Customer(String name, String surname, String gender, Integer age, String identification, String address, String email, String phone, Integer customerId, String password, Boolean status) {
        super(name, surname, gender, age, identification, address, email, phone);
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public Customer(Integer customerId, String password, Boolean status) {
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public Customer(){}

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
