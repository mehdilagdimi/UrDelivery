package com.urdelivery.urdelivery.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

@Named
@RequestScoped
public class CredentialsValidator {

        private String email;
        private String password;

        @NotNull
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        @NotNull
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
}
