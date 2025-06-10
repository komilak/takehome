import java.util.*;

// Households hold occupants with the same unique addresses
public class Household {
    Household(String street, String city, String state, String householdKey) {
        this.street = street.replaceAll("\\p{Punct}", "");
        this.city = city.replaceAll("\\p{Punct}", "");
        this.state = state.replaceAll("\\p{Punct}", "");
        this.householdKey = householdKey.replaceAll("\\p{Punct}", "");
        this.occupants = new ArrayList<Person>();
        this.occupantsCount = 0;
    }

    public void addOccupant(String firstName, String lastName, String age) {
        this.occupants.add(new Person(firstName, lastName, age));
        this.occupantsCount++;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
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
    public String getHouseholdKey() {
        return householdKey;
    }
    public int getOccupantsCount() {
        return occupantsCount;
    }
    public ArrayList<Person> getOccupants() {
        return occupants;
    }

    private String street;
    private String city;
    private String state;
    private String householdKey;
    private int occupantsCount;
    private ArrayList<Person> occupants;
}