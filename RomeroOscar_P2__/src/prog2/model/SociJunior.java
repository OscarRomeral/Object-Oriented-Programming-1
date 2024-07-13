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
public class SociJunior extends Soci {
    public SociJunior(String _nom, String _dni){
        super(_nom, _dni);
    }
    
    /**
     * Mètode que calcula el preu de cada excursió per als socis junior
     * @param preuExcursioBase
     * @return 0, ja que els socis junior no paguen les excursions
     * @throws ExcepcioClub 
     */
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{
        return 0;
    }
    
    /**
     * Metode toString per mostrar per pantalla les dades d'un soci junior
     * @return cadena de caràcters amb les dades
     */
    public String toString(){
        return "Nom = " + this.getNom() + ", DNI = " + this.getDNI() + "\n";
    }
    
    /**
     * Mètode que retorna el tipus de soci, en aquest cas, junior
     * @return cadena de caràcters que indica que el soci és junior
     */
    public String tipus(){
        return "Junior";
    }     
}
