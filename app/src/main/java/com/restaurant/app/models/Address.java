package com.restaurant.app.models;

/**
 * Delivery / billing address.
 */
public class Address {
    private final String addressLine;
    private final String city;
    private final String zip;
    private final String phone;

    public Address(String addressLine, String city, String zip, String phone) {
        this.addressLine = addressLine != null ? addressLine : "";
        this.city = city != null ? city : "";
        this.zip = zip != null ? zip : "";
        this.phone = phone != null ? phone : "";
    }

    public String getAddressLine() { return addressLine; }
    public String getCity() { return city; }
    public String getZip() { return zip; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return addressLine + ", " + city + " " + zip + "\n" + phone;
    }
}
