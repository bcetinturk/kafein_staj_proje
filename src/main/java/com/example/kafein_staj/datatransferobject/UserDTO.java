package com.example.kafein_staj.datatransferobject;

import com.example.kafein_staj.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Role role;
    //TODO: add BasketDTO

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String email, String phone, String address, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public static class UserDTOBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private Role role;

        public UserDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDTOBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDTOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserDTOBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserDTOBuilder setRole(Role role) {
            this.role = role;
            return this;
        }

        public UserDTO createUserDTO(){
            return new UserDTO(id, firstName, lastName, email, phone, address, role);
        }
    }
}
