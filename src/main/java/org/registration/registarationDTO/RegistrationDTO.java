package org.registration.registarationDTO;

import org.login.exceptions.BankingSystemLoginException;
import org.registration.exception.BankingSystemRegistrationException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
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

    public void setMobileNumber(String mobileNumber) throws BankingSystemRegistrationException{
        if(this.validateMobileNumber(mobileNumber)){
            this.mobileNumber = mobileNumber;
        }
        else{
            throw new BankingSystemRegistrationException("\n Invalid mobile number, Please enter again. Please try again. \n");
        }
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

    public void setGender(Gender gender) throws BankingSystemLoginException {
        this.gender = gender;
    }

    public boolean validateMobileNumber(String mobileNumber){
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(mobileNumber);

        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validateGender(char c){
        if (c == 'M' || c == 'F') {
            return true;
        }
        return false;
    }
}
