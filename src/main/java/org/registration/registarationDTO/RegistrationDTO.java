package org.registration.registarationDTO;

public class RegistrationDTO {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailID;
    private String address;
    private Gender gender;

    public RegistrationDTO(){
        System.out.println("its a default constructor");
    }

    public RegistrationDTO(String firstName, String lastName, String mobileNumber, String emailID, String address, Gender gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailID = emailID;
        this.address  = address;
        this.gender = gender;
    }

    public String getfirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
