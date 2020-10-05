/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author alfred
 */
public enum Grade implements Serializable {

    /**
     *
     */
    A (300),

    /**
     *
     */
    B (200),

    /**
     *
     */
    C (100);
    
    private final int prime;
    
    private Grade(int prime){
        this.prime = prime;
    }
    
    /**
     *
     * @return
     */
    public int getValue(){
        return prime;
    }
}
