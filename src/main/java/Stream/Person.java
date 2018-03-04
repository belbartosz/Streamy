package Stream;

public class Person {
    String firstName;
    String lastName;
    int age;
    isMale plec;

    public Person(String firstName, String lastName, int age, isMale plec) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.plec = plec;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public isMale getPlec() {
        return plec;
    }

    public void setPlec(isMale plec) {
        this.plec = plec;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age + " " + plec;
    }
}
