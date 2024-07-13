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
public class SociFederat extends Soci {
    
    private Federacio fede;
    private float descomptequota;
    private float descompteexcursions;
    
    public SociFederat(String _nom, String _dni, Federacio _fede, float _descomptequota, float _descompteexcursions) throws ExcepcioClub{
        super(_nom, _dni);
        if(comprova(_fede)){
            this.fede = _fede;
            this.descomptequota = _descomptequota;
            this.descompteexcursions = _descompteexcursions;
        }
    }
    
    /**
     * Mètode que comprova si el preu introduït per a la federació és correcte
     * @return true quan el preu és correcte
     * @throws ExcepcioClub 
     */
    public boolean comprova(Federacio _fede) throws ExcepcioClub{
        if(_fede.getPreu() < 100){
            throw new ExcepcioClub("El preu de la federació no és correcte\n");
        }
        return true;
    }
    
    /**
     * Mètode per obtenir la federació d'un soci federat
     * @return objecte fede de tipus Federacio
     */
    public Federacio getFede(){
        return this.fede;
    }
    
    /**
     * Mètode que calcula la quota mensual per als socis federats
     * @param quotaBase
     * @return variable float que té per valor el preu de la quota amb descompte
     * @throws ExcepcioClub 
     */
    public float calculaQuota(float quotaBase) throws ExcepcioClub{
        return quotaBase*(100-descomptequota)/100;
    }
    
    /**
     * Mètode que calcula el preu de cada excursió per als socis federats
     * @param preuExcursioBase
     * @return variable de tipus float amb el preu de l'excursió amb descompte
     * @throws ExcepcioClub 
     */
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{
        return preuExcursioBase*(100-descompteexcursions)/100;
    }
    
    /**
     * Metode toString per mostrar per pantalla les dades d'un soci federat
     * @return cadena de caràcters amb les dades
     */
    public String toString(){
        String sortida = "Nom = " + this.getNom() + ", DNI = " + this.getDNI();
        sortida += ". Federació: Nom = " + fede.getNom() + ", Preu = " + fede.getPreu() + "\n";
        return sortida;
    }
    
    /**
     * Mètode que retorna el tipus de soci, en aquest cas, federat
     * @return cadena de caràcters que indica que el soci és federat
     */
    public String tipus(){
        return "Federat";
    }     
}
