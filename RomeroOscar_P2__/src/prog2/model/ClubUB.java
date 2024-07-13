/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author diana
 */
public class ClubUB implements Serializable{
    private float preuexcursio = 20;
    private float quotamens = 25;
    private float descompteexc = 20;
    private float descomptequota = 30;
    
    private LlistaSocis _llistaSocis;
    
    public ClubUB(){
        _llistaSocis = new LlistaSocis();
    }
    
    /**
     * Mètode per obtenir la llista dels socis
     * @return objecte de tipus LlistaSocis
     */
    public LlistaSocis getLlistaSocis(){
        return _llistaSocis;
    }
    
    /**
     * Mètode per obtenir els socis que van a les excursions
     * @return cadena de caràcters amb la llista dels socis 
     */
    public String getExcursions(){
        return _llistaSocis.toString();
    }
    
    /**
     * Mètode que comprova si la llista de socis està buida
     * @return true si la llista és buida i false si no ho és
     */
    public boolean llistaBuida(){
        return _llistaSocis.isEmpty();
    }
    
    /**
     * Mètode per eliminar un soci de la llista
     * @param pos
     * @throws ExcepcioClub 
     */
    public void eliminarSoci(int pos) throws ExcepcioClub{
        if(pos >_llistaSocis.getSize() || pos < 0){
            throw new ExcepcioClub("La posició no existeix");
        }
        
        Soci soci = null;
        
        if(!_llistaSocis.isEmpty()){
            soci = _llistaSocis.getAt(pos);
        }
        
        _llistaSocis.removeSoci(soci);
    }
   
    /**
     * Mètode que afegeix un nou soci federat a la llista de socis
     * @param nomSoci
     * @param dniSoci
     * @param nomFede
     * @param preu
     * @throws ExcepcioClub 
     */
    public void afegirFederat(String nomSoci, String dni, String nomFede, float preu) throws ExcepcioClub{
        Federacio fede = new Federacio(nomFede, preu);
        
        SociFederat sociNou = new SociFederat(nomSoci, dni, fede, descomptequota, descompteexc);
        if(_llistaSocis.contains(sociNou)){
            throw new ExcepcioClub("Aquest soci ja apareix a la llista\n");
        }
        else{
            _llistaSocis.addSoci(sociNou);
        }
    }
    
    /**
     * Mètode que afegeix un soci estàndard a la llista dels socis
     * @param nomSoci
     * @param dni
     * @param tipus
     * @param preu
     * @throws ExcepcioClub 
     */
    public void afegirEstandard(String nomSoci, String dni, String tipus, float preu) throws ExcepcioClub{
        
        Asseguranca asse = new Asseguranca(tipus, preu);
        
        SociEstandard sociNou = new SociEstandard(nomSoci, dni, asse);
        if(_llistaSocis.contains(sociNou)){
            throw new ExcepcioClub("Aquest soci ja apareix a la llista\n");
        }
        else{
            _llistaSocis.addSoci(sociNou);
        }
    }
    
    /**
     * Mètode que afegeix un soci junior a la llista dels socis
     * @param nomSoci
     * @param dni
     * @throws ExcepcioClub 
     */
    public void afegirJunior(String nomSoci, String dni) throws ExcepcioClub{
        SociJunior sociNou = new SociJunior(nomSoci, dni);
        if(_llistaSocis.contains(sociNou)){
            throw new ExcepcioClub("Aquest soci ja apareix a la llista\n");
        }
        else{
            _llistaSocis.addSoci(sociNou);
        }
        
    }
    
    /**
     * Mètode que calcula la factura total d'un soci
     * @param soci
     * @param excursions
     * @return variable de tipus float amb el valor de la factura 
     * @throws ExcepcioClub 
     */
    public float totalFactura(Soci soci, int excursions) throws ExcepcioClub{
        float total = 0;
        float preuexc = soci.calculaPreuExcursio(preuexcursio);
        total = soci.calculaQuota(quotamens) + (excursions * preuexc);
        return total;
    }
    
    /**
     * Mètode que transforma en un String la factura d'un soci
     * @param dni
     * @param excursions
     * @return cadena de caràcters amb el nom, el DNI i la factura d'un soci
     * @throws ExcepcioClub 
     */
    public String crearFactura(String dni, int excursions) throws ExcepcioClub{
        String sortida;
        Soci soci = _llistaSocis.getSoci(dni);
        sortida = "Factura del soci: " + soci.getNom() + " amb DNI: " + dni +":\n";
        sortida += totalFactura(soci, excursions) + " euros\n";
        
        return sortida;
    }
    
    /**
     * Mètode que modifica el nom d'un soci de la llista
     * @param dni
     * @param nom
     * @throws ExcepcioClub 
     */
    public void modificarNomSoci (String dni, String nom) throws ExcepcioClub{
        Soci soci = _llistaSocis.getSoci(dni);
        soci.setNom(nom);
    }
    
    /**
     * Mètode que modifica l'assegurança d'un soci de la llista
     * @param dni
     * @param nouTipus
     * @throws ExcepcioClub 
     */
    public void modificarAsse(String dni, String nouTipus) throws ExcepcioClub{
        Soci soci = _llistaSocis.getSoci(dni);
        
        if(soci.tipus() == "Estàndard"){
            SociEstandard estandard = (SociEstandard) soci;
            estandard.getAsseguranca().setTipus(nouTipus);
        }else{
            throw new ExcepcioClub("No correspon a un soci estàndard");
        }
    }
    
    /**
     * Mètode que carrega un fitxer amb tota la informació del club
     * @param ruta
     * @return un fitxer prèviament guardat amb la informació
     * @throws ExcepcioClub 
     */
    public static ClubUB load(String ruta) throws ExcepcioClub{
        if(ruta == null){
            throw  new ExcepcioClub("La ruta del fitxer no és vàlida");
        }
        
        File file = new File(ruta);
        
        
        FileInputStream fin = null;
        ClubUB guardat = null;
        ObjectInputStream ois = null;
        
        try{
            fin = new FileInputStream(file);
            ois = new ObjectInputStream(fin);
            guardat = (ClubUB)ois.readObject();        
        }catch(ClassNotFoundException ex){
            throw  new ExcepcioClub("No es pot castejar a objecte tipus Dades\n");
        }catch(FileNotFoundException ex){
            throw  new ExcepcioClub("No s'ha trobat el fitxer\n");
        }catch(IOException ex){
            throw  new ExcepcioClub("Problema de lectura\n");
        }finally{
            try{
                if(fin!=null){
                    fin.close();
                }
            }catch(IOException ex){
                throw  new ExcepcioClub("No es pot tancar fitxer\n");
            }
            try{
                if(ois!=null){
                    ois.close();
                }
            }catch(IOException ex){
                throw  new ExcepcioClub("No es pot tancar l'object input stream\n");
            }
        }
        
        return guardat;
    }

    /**
     * Mètode que guarda tota la informació del club en un fitxer
     * @param ruta
     * @throws ExcepcioClub 
     */
    public void save(String ruta) throws ExcepcioClub{
        File file = new File(ruta);
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        try{
            fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        }catch(FileNotFoundException ex){
            throw new ExcepcioClub("No s'ha trobat el fitxer\n");
        }catch(IOException ex){
            throw new ExcepcioClub("Problema al escriure al fitxer\n");
        }finally{
            try{
                if(fout!=null){
                    fout.close();
                }
            }catch(IOException ex){
                throw  new ExcepcioClub("No es pot tancar fitxer\n");
            }
            try{
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                throw  new ExcepcioClub("No es pot tancar l'object output stream\n");
            }
        } 
    }
}