package Model;


import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author alfred
 */
public abstract class Person implements Serializable {

    /**
     * firstname
     */
    protected String firstname,

    /**
     *and surname of person
     */
    surname;

    /**
     *
     */
    protected LocalDate birthDate;
    
    /**
     *
     * @param surname
     * @param firstname
     * @param birth
     */
    public Person(String surname, String firstname, LocalDate birth){
        this.surname = surname;
        this.firstname = firstname;
        birthDate = birth;
    }

    /**
     *
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
}
