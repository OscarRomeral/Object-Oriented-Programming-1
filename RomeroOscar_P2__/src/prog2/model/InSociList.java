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
public interface InSociList {
    
    /**
     * Donar el nÃºmero d'elemnts que hi ha actualment emmagatzemants a la llista.
     * @return int amb el nÃºmero d'elements de la llista.
     */
    public int getSize();
    
    /**
     * Afegir un nou soci
     * @param soci objecte per afegir a la llista.
     * @throws prog2.vista.ExcepcioClub 
     */
    public void addSoci(Soci soci) throws ExcepcioClub;
    
    /**
     * Eliminar un objecte de la llista
     * @param soci objecte per eliminar.
     * @throws prog2.vista.ExcepcioClub
     */
    public void removeSoci(Soci soci) throws ExcepcioClub;
    
    /**
     * Obtenir el soci guardat a una certa posiciÃ³ donada
     * @param position posiciÃ³ a la llista de socis.
     * @return objecte soci a la posiciÃ³ donada o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Soci getAt(int position) throws ExcepcioClub;
    
    /**
     * Obtenir el soci donat el seu DNI 
     * @param dni DNI del soci al que volem accedir.
     * @return Objecte soci amb el dni donat o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Soci getSoci(String dni) throws ExcepcioClub;
    
    /**
     * Eliminar tots els elements de la llista
     * @throws prog2.vista.ExcepcioClub
     */
    public void clear() throws ExcepcioClub;
    
    /**
     * Comprovar si la llista estÃ  a la seva capacitat mÃ xima o no.
     * @return True si la llista estÃ  plena (no hi ha lloc per mÃ©s elements) o false sinÃ³.
     * @throws prog2.vista.ExcepcioClub
     */
    public boolean isFull() throws ExcepcioClub;
    
    /**
     * Comprovar si la llista estÃ  buida o no.
     * @return True si la llista estÃ  buida (no hi ha cap elements) o false sinÃ³.
     * @throws prog2.vista.ExcepcioClub
     */
    public boolean isEmpty() throws ExcepcioClub;    
}
