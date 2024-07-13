/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

/**
 *
 * @author diana
 */
public class ExcepcioClub extends Exception {
    public ExcepcioClub(){ // Constructor per defecte
        super();
    }
    public ExcepcioClub(String s){ // Constructor amb missatge
        super(s);
    }
    
}
