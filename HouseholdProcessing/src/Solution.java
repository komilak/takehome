import java.io.*;
import java.util.*;

// Pre and post processing of text done here, creating households at each unique address with the occupants living there.
public class Solution {
    public static void readFile(Map<String, Household> households) {
        String fileName = "input.txt"; // Assuming static file locations
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\",\"");
                
                String firstName = parts[0].substring(1);
                String lastName = parts[1];
                String street = parts[2];
                String city = parts[3];
                String state = parts[4];
                String age = parts[5].substring(0, parts[5].length() - 1);

                // This key is the unique identifier of each Household. String manipulation is done to handle unnecessary punctuation and trailing whitespaces.
                String householdKey = (street.toUpperCase().trim() + ", " + city.toUpperCase().trim() + ", " + state.toUpperCase().trim()).replaceAll("\\p{Punct}", "");

                if (!households.containsKey(householdKey)) {
                    households.put(householdKey, new Household(street, city, state, householdKey));
                }

                households.get(householdKey).addOccupant(firstName, lastName, age);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file.\n" + e.getMessage());
        }
    }

    public static void writeFile(Map<String, Household> households) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (Map.Entry<String, Household> household : households.entrySet()) {
                writer.write(household.getValue().getHouseholdKey() + " (" + household.getValue().getOccupantsCount() + ")\n");
                ArrayList<Person> occupants = household.getValue().getOccupants();
                Collections.sort(occupants);
                for (int i = 0; i < occupants.size(); i++) {
                    if (occupants.get(i).getAge() >= 18) {
                        writer.write("- " + occupants.get(i).getFirstName() + " " + occupants.get(i).getLastName() + " " + occupants.get(i).getAge() + "\n");
                    }
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, Household> households = new HashMap<>();
        
        readFile(households);

        writeFile(households);

    }
}