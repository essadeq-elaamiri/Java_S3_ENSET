package net.pro.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private static int generateID = 122;
    private int idConact;
    private String fallName;
    private String email;
    private String phone;

    public Contact(int idConact, String fallName, String email, String phone) {

        this.idConact = generateID+1;
        this.fallName = fallName;
        this.email = email;
        this.phone = phone;
    }

    public int getIdConact() {
        return idConact;
    }

    public void setIdConact(int idConact) {
        this.idConact = idConact;
    }

    public String getFallName() {
        return fallName;
    }

    public void setFallName(String fallName) {
        this.fallName = fallName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "idConact=" + idConact +
                ", fallName='" + fallName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
