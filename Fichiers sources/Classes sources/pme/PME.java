    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pme;

import Model.*;
import java.io.IOException;

/**
 *
 * @author alfred
 */
public class PME {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Bienvenu sur le programme de gestion de PME !");
        new Station();
    }
    
}
