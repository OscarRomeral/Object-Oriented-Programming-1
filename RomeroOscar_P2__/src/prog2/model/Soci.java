/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;
import java.io.Serializable;

/**
 *
 * @author diana
 */
public abstract class Soci implements InSoci, Serializable{
    private String nom;
    private String dni;
    
    
    Soci(){
        this.nom = "";
        this.dni = "";
    }
    
    Soci(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }
    
    public abstract String tipus();
    
    /**
     * Mètode setNom per establir el nom del soci
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Mètode getNom per obtenir el nom del soci
     * @return cadena de caràcters amb el nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Mètode setDNI per establir el DNI del soci
     * @param dni 
     */
    public void setDNI(String dni) {
        this.dni = dni;
    }
    
    /**
     * Mètode getDNI per obtenir el DNI del soci
     * @return cadena de caràcters amb el DNI
     */
    public String getDNI() {
        return dni;
    }
    
    /**
     * Mètode que comprova si dos DNI són iguals
     * @param obj
     * @return true si són iguals i false si no ho són
     */
    public boolean equals(Object obj){
        Soci soci = (Soci) obj;
        if(soci.getDNI().equals(getDNI())){
            return true;
        }
        else return false;
    }
    
    public abstract String toString();
    
    /**
     * Calcular la quota mensual del soci
     * @param quotaBase quota mensual base del club.
     * @return float amb la quota mensual d'aquest soci.
     * @throws ExcepcioClub 
     */
    public float calculaQuota(float quotaBase) throws ExcepcioClub{
        return quotaBase;
    }
    
    /**
     * Calcualr el preu de les excursions del soci
     * @param preuExcursioBase preu de les excursions del club.
     * @return float amb el preu de les excursions d'aquest soci.
     * @throws ExcepcioClub 
     */
    public abstract float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub;
    
}
