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
public class IniciadorClubUB {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomClub = "Club UB";
        
        VistaClubUB vistaClub = new VistaClubUB(nomClub);
        vistaClub.gestioClubUB();
    }
  
}
