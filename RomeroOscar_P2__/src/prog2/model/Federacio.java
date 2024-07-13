/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

/**
 *
 * @author diana
 */
public class Federacio {
    private String nom;
    private float preu;
    
    Federacio(String nom, float preu){
        this.nom = nom;
        this.preu = preu;
    }
    
    /**
     * Mètode setNom per establir el nom de la federació
     * @param preu 
     */
    public void setNom(String tipus){
        this.nom = nom;
    }
    
    /**
     * Mètode setPreu per establir el preu de la federació
     * @param preu 
     */
    public void setPreu(float preu){
        this.preu = preu;
    }
    
    /**
     * Mètode getNom per obtenir el nom de la federació
     * @return cadena de caràcters que indica el nom
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Mètode getPreu per obtenir el preu de la federació
     * @return variable de tipus float amb el preu de la federació
     */
    public float getPreu(){
        return this.preu;
    }
    
    /**
     * Mètode toString per mostrar per pantalla el nom i el preu de la federació
     * @return cadena de caràcters que indica el preu i el nom de la federació
     */
    public String toString(){
        return "Federació: Nom=" + getNom() + ", Preu=" + getPreu();
    }
}
