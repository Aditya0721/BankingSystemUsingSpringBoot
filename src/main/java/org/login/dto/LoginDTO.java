package org.login.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {
    //here we rae declaring the attributes that are required for login
    private String username;
    private String password;

    //default constructor
    public LoginDTO() {
        super();
    }

    //parameterized constructor
    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //defeing getters and setters methods
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
