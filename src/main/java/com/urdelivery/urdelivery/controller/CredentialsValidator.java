package com.urdelivery.urdelivery.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


@Named
@RequestScoped
public class CredentialsValidator implements Serializable{
        private String email;
        private String password;

        private String role;


        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }
        @NotNull
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        @NotNull
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
}
