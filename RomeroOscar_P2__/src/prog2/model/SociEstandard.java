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
public class SociEstandard extends Soci {
    
    private Asseguranca assegur;
    
    public SociEstandard(String _nom, String _dni, Asseguranca _assegur) throws ExcepcioClub{
        super(_nom, _dni);
        if(comprova(_assegur)){
            this.assegur = _assegur;
        }
    }
    
    /**
     * Mètode que comprova si el tipus d'assegurança indicat és vàlid
     * @return true sempre que l'assegurança sigui bàsica o completa
     * @throws ExcepcioClub 
     */
    public boolean comprova(Asseguranca ass) throws ExcepcioClub{
        if(!ass.getTipus().equals("Bàsica") && !ass.getTipus().equals("Completa") ){
            throw new ExcepcioClub("El tipus d'assegurança no és correcte\n");
        }
        return true;
    }
    
    /**
     * Mètode que calcula el preu total de cada excursió
     * @param preuExcursioBase
     * @return variable float amb el preu de l'excursió
     * @throws ExcepcioClub 
     */
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{
        return preuExcursioBase + assegur.getPreu();
    }
    
    /**
     * Mètode per obtenir l'assegurança de cada soci estàndard
     * @return objecte assegur de tipus Assegurança
     */
    public Asseguranca getAsseguranca(){
        return assegur;
    }
    
    /**
     * Metode toString per mostrar per pantalla les dades d'un soci estàndard
     * @return cadena de caràcters amb les dades
     */
    public String toString(){
        String sortida = "Nom = " + this.getNom() + ", DNI = " + this.getDNI();
        sortida += ". Assegurança: Tipus = " + assegur.getTipus() + ", Preu = " + assegur.getPreu() + "\n";
        return sortida;
    }
    
    /**
     * Mètode que retorna el tipus de soci, en aquest cas, estàndard
     * @return cadena de caràcters que indica que el soci és estàndard
     */
    public String tipus(){
        return "Estàndard";
    }    
}
