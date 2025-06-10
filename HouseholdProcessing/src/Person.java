// Created as a separate Person class for possible future modifications to age, name, etc.
public class Person implements Comparable<Person>{
    Person(String firstName, String lastName, String age) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.age = Integer.parseInt(age);
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getLastName().compareTo(other.getLastName()) == 0) {
            return this.getFirstName().compareTo(other.getFirstName());
        }
        return this.getLastName().compareTo(other.getLastName());
    }

    private String firstName;
    private String lastName;
    private Integer age;
}