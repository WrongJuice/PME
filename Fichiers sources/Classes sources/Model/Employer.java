package Model;


import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alfred
 */
class Employer implements Serializable {
    private String name;
    private int ca;
    protected ArrayList<Employee> employees;

    /**
     *
     * @param name
     */
    public Employer(String name) {
        ca = -1;
        this.name = name;
        employees = new ArrayList<Employee>();
    }
    
    /**
     *
     * @param employee
     */
    public void recruit(Employee employee){
        employees.add(employee);
    }

    /**
     *
     * @return employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getCa() {
        return ca;
    }

    /**
     *
     * @param ca
     */
    public void setCa(int ca) {
        this.ca = ca;
    }
    
    public String toSgtring(){
        return "Présentation entreprise :\nNom entreprise : " + name + "\nNombre d'employés : "  + Integer.toString(employees.size()) + '\n';
    }
    
}
