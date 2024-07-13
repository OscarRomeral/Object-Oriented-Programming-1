/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;
import prog2.vista.ExcepcioClub;

/**
 *
 * @author diana
 */
public class Asseguranca {
    private String tipus;
    private float preu;
    
    Asseguranca(String tipus, float preu){
        this.tipus = tipus;
        this.preu = preu;
    }
    
    /**
     * Mètode setTipus per establir el tipus d'assegurança
     * @param tipus 
     */
    public void setTipus(String tipus) throws ExcepcioClub{
        if(!tipus.equals("Bàsica") && !tipus.equals("Completa") ){
            throw new ExcepcioClub("El tipus d'assegurança no és correcte\n");
        }
        this.tipus = tipus;
    }
    
    /**
     * Mètode setPreu per establir el preu de l'assegurança
     * @param preu 
     */
    public void setPreu(float preu){
        this.preu = preu;
    }
    
    /**
     * Mètode getTipus per obtenir el tipus d'assegurança
     * @return cadena de caràcters que indica el tipus d'assegurança
     */
    public String getTipus(){
        return this.tipus;
    }
    
    /**
     * Mètode getPreu per obtenir el preu de l'assegurança
     * @return variable de tipus float amb el preu de l'assegurança
     */
    public float getPreu(){
        return this.preu;
    }
    
    /**
     * Mètode toString per mostrar per pantalla el tipus i el preu de l'assegurança
     * @return cadena de caràcters que indica el preu i el tipus de l'assegurança
     */
    public String toString(){
        return "Assegurança: Tipus=" + getTipus() + ", Preu=" + getPreu();
    }
}
