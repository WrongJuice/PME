/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author alfred
 */
public final class Station {
    
    private Employer employer;
    
    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Station() throws IOException, ClassNotFoundException{
        File f = new File("pme.data");
        if(f.exists() && !f.isDirectory())
            readFile(f);
        else
            firstLaunch(f);
    }
    
    /**
     * launch message of first launch and normal methods
     * @param file
     */
    private void firstLaunch(File file) throws IOException{
        System.out.println("Nom de l'entreprise : ");
        Scanner scan = new Scanner(System.in);
        employer = new Employer(scan.next());
        routine();
        writeFile(file);
    }
    
    /**
     * save file
     * @param file
     */
    private void writeFile(File file) throws FileNotFoundException, IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("pme.data");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(employer);
            objectOutputStream.flush();
        }
    }
    
    /**
     * read file
     * @param file
     */
    private void readFile(File file) throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream("pme.data");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            employer = (Employer) objectInputStream.readObject();
        }
        routine();
        writeFile(file);
    }
    
    /**
     * interact with user
     */
    private void routine(){
        Scanner scan = new Scanner(System.in);
        String res;
        int intRes;
        do{
            System.out.println("\nQue souhaitez-vous faire ?\n1 - Définir le CA\n2 - Afficher les informations de l'entreprise\n3 - Modifier les informations de l'entreprise\n4 - Ajouter un employé\n5 - Afficher le/les employés\n6 - Modifier un employé\n7 - Supprimer un employé\n8 - Quitter\n");
            res = scan.next();
            switch(res){
                
                case "1": 
                    System.out.println("Entrez le CA : ");
                    int ca = Integer.parseInt(scan.next());
                    employer.setCa(ca);
                    break;
                    
                case "2":
                    System.out.println("\nNom de l'entreprise : " + employer.getName() + "\nCA de l'entreprise : " + ((employer.getCa() == -1)?"CA non défini":Integer.toString(employer.getCa())) + "\n\nEmployé(s) : \n");
                    if(employer.getEmployees().isEmpty()) System.out.println("Il n'y a aucun employé");
                    else employer.getEmployees().forEach((e) -> {  System.out.println(employer.getEmployees().indexOf(e) + " - " + ((e.getClass().getName().equals("Executive"))?((Executive)e).toString():e.toString())); });
                    break;
                    
                case "3":
                    do{
                        System.out.println("Quelle information souhaitez-vous modifier ?\n1 - Le nom\n2 - Le CA\n3 - Aucune");
                        res = scan.next();
                        switch(res){
                            case "1": System.out.println("Entrez le nouveau nom de l'entreprise : ");
                                employer.setName(scan.next());
                                break;
                            case "2": System.out.println("Entrez le CA actuel de l'entreprise : ");
                                employer.setCa(Integer.parseInt(scan.next()));
                                break;
                            case "3": break;
                            default: break;
                        }
                    }while(!res.equals("3"));
                    break;
                    
                case "4":
                    System.out.println("Entrez le nom : ");
                    String s = scan.next();
                    System.out.println("Entrez le prénom : ");
                    String f = scan.next();
                    int y;
                    do{
                        System.out.println("Entrez l'année de naissance (il doit avoir 16 ans minimum) : ");
                        y = Integer.parseInt(scan.next());
                    }while(Calendar.getInstance().get(Calendar.YEAR) - y < 16);
                    System.out.println("Entrez le mois de naissance : ");
                    int m = Integer.parseInt(scan.next());
                    System.out.println("Entrez le jour de naissance : ");
                    int d = Integer.parseInt(scan.next());
                    System.out.println("Entrer un salaire ? (o/n)");
                    int salary = -1;
                    if(scan.next().equals("o")){
                       System.out.println("Entrez le salaire : ");
                       salary = Integer.parseInt(scan.next());
                    }
                    System.out.println("Est-ce un cadre ? (o/n) ");
                    if(scan.next().equals("o")){
                        System.out.println("Donnez son grade (A/B/C) : ");
                        if(salary == -1)
                            employer.recruit(new Executive(s, f, LocalDate.of(y, m, d) , employer, Grade.valueOf(scan.next())));
                        else
                            employer.recruit(new Executive(s, f, LocalDate.of(y, m, d) , employer, salary, Grade.valueOf(scan.next())));
                    }else{
                        if(salary == -1)
                            employer.recruit(new Employee(s, f, LocalDate.of(y, m, d) , employer));
                        else
                            employer.recruit(new Employee(s, f, LocalDate.of(y, m, d) , employer, salary));
                    }
                    break;
                    
                case "5":
                    System.out.println("Employés : ");
                    if(employer.getEmployees().isEmpty()) System.out.println("Il n'y a aucun employé");
                    else employer.getEmployees().forEach((e) -> { System.out.println(employer.getEmployees().indexOf(e) + " - " + ((e.getClass().getName().equals("Executive"))?((Executive)e).toString():e.toString())); });
                    break;
                    
                case "6":
                     if(employer.getEmployees().isEmpty()) System.out.println("Il n'y a aucun employé");
                    else employer.getEmployees().forEach((e) -> { System.out.println(employer.getEmployees().indexOf(e) + " - " + ((e.getClass().getName().equals("Executive"))?((Executive)e).toString():e.toString())); });
                    do{
                        System.out.println("\nQuel employé voulez-vous modifier ? Entrez l'index ou \"q\" pour quitter l'édition : ") ;
                        res = scan.next();
                        res = (res.equals("q"))?"-1":res;
                    }while(Integer.parseInt(res) >= employer.getEmployees().size());
                    if(!res.equals("-1")){
                        System.out.println("Employé à modifier : \n" + employer.getEmployees().get(Integer.parseInt(res)) + "\nQuelle information souhaitez-vous modifier ?\n1 - Prénom\n2 - Nom\n3 - Salaire");
                        switch(scan.next()){
                            case "1":
                                 System.out.println("Entrez le nouveau prénom : ");
                                 employer.getEmployees().get(Integer.parseInt(res)).setFirstname(scan.next());
                                break;
                            case "2":
                                System.out.println("Entrez le nouveau nom : ");
                                employer.getEmployees().get(Integer.parseInt(res)).setSurname(scan.next());
                                break;
                            case "3":
                                System.out.println("Entrez le nouveau salaire : ");
                                employer.getEmployees().get(Integer.parseInt(res)).setSalary(Integer.parseInt(scan.next()));
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                    
                case "7":
                    System.out.println("Employés : ");
                    if(employer.getEmployees().isEmpty()) System.out.println("Il n'y a aucun employé");
                    else employer.getEmployees().forEach((e) -> { System.out.println(employer.getEmployees().indexOf(e) + " - " + ((e.getClass().getName().equals("Executive"))?((Executive)e).toString():e.toString())); });
                    do{
                        System.out.println("\nQuel employé voulez-vous supprimer ? Entrez l'index ou \"q\" pour quitter la suppression : ") ;
                        res = scan.next();
                        res = (res.equals("q"))?"-1":res;
                    }while(Integer.parseInt(res) >= employer.getEmployees().size());
                    if(!res.equals("-1")){
                        intRes = Integer.parseInt(res);
                        System.out.println("Êtes-vous sûr ? (o/n)");
                        res = scan.next();
                        if(res .equals("o")) employer.getEmployees().remove(intRes);
                    }
                    break;
                default: break;
            }
        }while(!res.equals("8"));
    }
    
}
