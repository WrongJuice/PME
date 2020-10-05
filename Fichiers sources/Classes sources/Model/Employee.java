package Model;


import java.time.LocalDate;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred
 */
public class Employee extends Person {

    /**
     * salary in euros
     */
    protected int salary;
    
    /**
     *
     * @param surname
     * @param firstname
     * @param birth
     * @param company
     */
    public Employee(String surname, String firstname, LocalDate birth, Employer company){
        super(surname, firstname, birth);
        salary = (Calendar.getInstance().get(Calendar.YEAR) - birth.getYear())*100;
    }
    
    /**
     *
     * @param surname
     * @param firstname
     * @param birth
     * @param company
     * @param salary
     */
    public Employee(String surname, String firstname, LocalDate birth, Employer company, int salary){
        super(surname, firstname, birth);
        this.salary = salary;
    }

    /**
     *
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString(){
        return "Nom : " + super.surname + "\t| Prénom : " + super.firstname + "\t| Date de naissance : " + super.getBirthDate().toString() + "\t| Salaire : " + Integer.toString(salary)  ;
    }
    
}
