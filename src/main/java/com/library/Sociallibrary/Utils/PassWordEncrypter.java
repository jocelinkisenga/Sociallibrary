package com.library.Sociallibrary.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PassWordEncrypter {

    private String Encriptedpassword;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    

    public PassWordEncrypter(String encriptedpassword) {
        Encriptedpassword = encriptedpassword;
    }

    public String getEncriptedpassword() {
        return Encriptedpassword;
    }

    public void setEncriptedpassword(String encriptedpassword) {
        Encriptedpassword = encriptedpassword;
    }
    
    public String generatePassword(){
        return this.bCryptPasswordEncoder.encode(this.Encriptedpassword);
    }

    



}
