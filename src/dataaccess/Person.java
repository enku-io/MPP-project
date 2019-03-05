package dataaccess;

import util.Storage;

public class Person{

    private String username;
    private String password;
    private PersonRole personRole;

    public Person(String username, String password, PersonRole personRole) {
        this.username = username;
        this.password = password;
        this.personRole = personRole;
    }

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

    public PersonRole getPersonRole() {
        return personRole;
    }

    public void setPersonRole(PersonRole personRole) {
        this.personRole = personRole;
    }

    public static Person login(String username, String password){
        Person p = Storage.users
                .stream()
                .filter(person -> person.getUsername().equals(username) && person.getPassword().equals(password))
                .findFirst().orElse(null);
        Storage.session = p;
        return p;
    }

}