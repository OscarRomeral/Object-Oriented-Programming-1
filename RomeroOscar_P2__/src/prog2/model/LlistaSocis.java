/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/**
 *
 * @author diana
 */
public class LlistaSocis implements InSociList, Serializable{
    
    private ArrayList <Soci> llistaSocis;
    private int midamax;
    
    LlistaSocis(){
        llistaSocis = new ArrayList ();
        this.midamax = 100;
    }
    
    LlistaSocis(int _midamax){
        llistaSocis = new ArrayList ();
        this.midamax = _midamax;
    }
    
    /**
     * Mètode contains que comprova si un soci és a la llista o no
     * @param s
     * @return variable booleana que retorna fals si l'usuari no és a la llista
     * i true en el cas contrari
     */
    public boolean contains(Soci s){
        boolean flag = false;
        Iterator<Soci> it = llistaSocis.iterator();
        
        while(it.hasNext() && flag == false){
            Soci soci = it.next();
            if(s.equals(soci)){
                flag = true;
            }   
        }
        return flag;
    }
    
    
    /**
     * Donar el nÃºmero d'elemnts que hi ha actualment emmagatzemants a la llista.
     * @return int amb el nÃºmero d'elements de la llista.
     */
    public int getSize(){
        return this.llistaSocis.size();
    }
    
    /**
     * Afegir un nou soci
     * @param soci objecte per afegir a la llista.
     * @throws prog2.vista.ExcepcioClub 
     */
    public void addSoci(Soci soci) throws ExcepcioClub{
        if(this.isFull()){
            throw new ExcepcioClub("La llista de socis ja està plena\n"); 
        }
        if(this.llistaSocis.contains(soci)){
            throw new ExcepcioClub("El soci que es vol afegir ja apareix a la llista\n");
        }
        else{
            this.llistaSocis.add(soci);
        }
    }
    
    /**
     * Eliminar un objecte de la llista
     * @param soci objecte per eliminar.
     * @throws prog2.vista.ExcepcioClub
     */
    public void removeSoci(Soci soci) throws ExcepcioClub{
        if(this.isEmpty()){
            throw new ExcepcioClub("La llista ja està buida, no es por eliminar cap soci\n");
        }
        else{
            this.llistaSocis.remove(soci);
        }
    }
    
    /**
     * Obtenir el soci guardat a una certa posiciÃ³ donada
     * @param position posiciÃ³ a la llista de socis.
     * @return objecte soci a la posiciÃ³ donada o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Soci getAt(int position) throws ExcepcioClub{
        if(position >= this.getSize() || position < 0){
            throw new ExcepcioClub("La posició introduida no és correcta\n");
        }
        else{
            Iterator<Soci> it = llistaSocis.iterator();
            Soci soci = it.next();
            for(int i=0; i<position; i++){
                soci = it.next();
            }
            return soci;
        }
    }
    
    /**
     * Obtenir el soci donat el seu DNI 
     * @param dni DNI del soci al que volem accedir.
     * @return Objecte soci amb el dni donat o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    
    public Soci getSoci(String dni) throws ExcepcioClub{
        Soci soci;
        Iterator<Soci> it = llistaSocis.iterator();
        while(it.hasNext()){
            soci = it.next();
            if(dni.equals(soci.getDNI())){
                return soci;
            }
        }
        throw new ExcepcioClub("El soci no apareix a la llista\n");
    }
    
    
    /**
     * Eliminar tots els elements de la llista
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public void clear() throws ExcepcioClub{
        if(this.llistaSocis.isEmpty()){
            throw new ExcepcioClub("La llista ja és buida\n");
        }
        Iterator<Soci> it = llistaSocis.iterator();
        while(it.hasNext()){
            Soci soci = it.next();
            this.removeSoci(soci);
        }
    }
    
    /**
     * Comprovar si la llista estÃ  a la seva capacitat mÃ xima o no.
     * @return True si la llista estÃ  plena (no hi ha lloc per mÃ©s elements) o false sinÃ³.
     */
    @Override
    public boolean isFull(){
        return this.getSize() >= this.midamax;
    }
    
    /**
     * Comprovar si la llista estÃ  buida o no.
     * @return True si la llista estÃ  buida (no hi ha cap elements) o false sinÃ³.
     */
    @Override
    public boolean isEmpty(){
        return this.getSize() == 0;
    }
    
    /**
     * Mètode toString per mostrar per pantalla la llista de socis
     * @return cadena de caràcters on trobem la llista 
     */
    @Override
    public String toString(){
        int comp = 0;
        String sortida = "Llista de socis:\n==============\n";
        Iterator<Soci> it = llistaSocis.iterator();
        while(it.hasNext()){
            Soci soci = it.next();
            sortida += "[" + ++comp + "]" + soci.toString() + "\n";
        }
        if (comp == 0) sortida += "Buida\n";
        return sortida;
    }
    
}