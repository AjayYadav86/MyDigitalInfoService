package model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

import lombok.Getter;
import lombok.Setter;



@DynamoDBTable(tableName = "CustomerInfo")
@Getter
@Setter
public class Customer {

    @DynamoDBHashKey(attributeName = "customerId")
    private String customerId;
    
	@DynamoDBAttribute(attributeName = "firstName")
    private String firstName;
    
    @DynamoDBAttribute(attributeName = "lastName")
    private String lastName;
    
    @DynamoDBAttribute(attributeName = "address1")
    private String address1;
    
    @DynamoDBAttribute(attributeName = "address2")
    private String address2;
    
    @DynamoDBAttribute(attributeName = "city")
    private String city;
    
    @DynamoDBAttribute(attributeName = "state")
    private String state;
    
    @DynamoDBAttribute(attributeName = "zipCode")
    private String zipcode;
    
    @DynamoDBAttribute(attributeName = "emailAddress")
    private String emailAddress;
    
    @DynamoDBAttribute(attributeName = "phoneNumber")
    private String phoneNumber;
    
    @DynamoDBTyped(DynamoDBAttributeType.BOOL)
    private boolean fever;
    
    @DynamoDBTyped(DynamoDBAttributeType.BOOL)
    private boolean cough;
    
    @DynamoDBTyped(DynamoDBAttributeType.BOOL)
    private boolean travel;
    
    @DynamoDBTyped(DynamoDBAttributeType.BOOL)
    private boolean virusExposed;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isFever() {
		return fever;
	}

	public void setFever(boolean fever) {
		this.fever = fever;
	}

	public boolean isCough() {
		return cough;
	}

	public void setCough(boolean cough) {
		this.cough = cough;
	}

	public boolean isTravel() {
		return travel;
	}

	public void setTravel(boolean travel) {
		this.travel = travel;
	}

	public boolean isVirusExposed() {
		return virusExposed;
	}

	public void setVirusExposed(boolean virusExposed) {
		this.virusExposed = virusExposed;
	}

    
}