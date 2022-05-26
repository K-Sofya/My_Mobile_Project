package com.example.mymobileproject.model;

import java.util.Objects;

public class Enter {

    private String phone, pass;

    public Enter(String phone, String pass) {
        this.phone = phone;
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enter enter = (Enter) o;
        return Objects.equals(phone, enter.phone) && Objects.equals(pass, enter.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, pass);
    }

    @Override
    public String toString() {
        return "Enter{" +
                "phone='" + phone + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
