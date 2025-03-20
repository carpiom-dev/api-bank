package com.mcarpio.bank.domain.pojos;

public class CustomerPojo extends PersonPojo {

    private Integer customerId;
    private String password;
    private Boolean status;

    public CustomerPojo(String name, String surname, String gender, Integer age, String identification, String address, String email, String phone, Integer customerId, String password, Boolean status) {
        super(name, surname, gender, age, identification, address, email, phone);
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public CustomerPojo(Integer customerId, String password, Boolean status) {
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public CustomerPojo(){}

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
        return "CustomerPojo{" +
                "customerId=" + customerId +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
