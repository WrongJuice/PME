package Model;


import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfred
 */
public class Executive extends Employee {
    
    private Grade grade;
    
    /**
     *
     * @param surname
     * @param firstname
     * @param birth
     * @param company
     * @param grade
     */
    public Executive(String surname, String firstname, LocalDate birth, Employer company, Grade grade) {
        super(surname, firstname, birth, company);
        this.grade = grade;
        super.setSalary(super.getSalary() + grade.getValue());
    }

    /**
     *
     * @param surname
     * @param firstname
     * @param birth
     * @param company
     * @param salary
     * @param grade
     */
    public Executive(String surname, String firstname, LocalDate birth, Employer company, int salary, Grade grade) {
        super(surname, firstname, birth, company, salary);
        this.grade = grade;
        super.setSalary(super.getSalary() + grade.getValue());
    }
    
    @Override
    public String toString(){
        return super.toString() + "\t| Grade : " + grade.toString()  + "\t| Prime : " +  Integer.toString(grade.getValue());
    }
    
}
