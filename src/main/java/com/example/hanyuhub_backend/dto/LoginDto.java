package com.example.hanyuhub_backend.dto;

public class LoginDto {
    private String mail;
    private String pass;

    public LoginDto(){
        this.mail = "";
        this.pass = "";
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
