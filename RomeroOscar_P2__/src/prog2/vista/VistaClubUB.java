/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.Scanner;
import prog2.model.ClubUB;

/**
 *
 * @author diana
 */
public class VistaClubUB {
    private ClubUB club;
    private String nomClub;
    
    public VistaClubUB(String nomClub){
        this.nomClub = nomClub;
        club = new ClubUB();
    }
    
    public void gestioClubUB(){
        Scanner sc = new Scanner(System.in);
        gestioMenu(sc);
    }
    /* ******************************************** */
    /* Gestion, Opciones y Descripcion del Menu (M) */
    /* ******************************************** */
    private static enum OpcionsMenu {
        M_Opcio_1_AfegirSoci,
        M_Opcio_2_MostrarLlistaSocis,
        M_Opcio_3_EliminarSoci,
        M_Opcio_4_MostrarFactura,
        M_Opcio_5_ModificarNomSoci,
        M_Opcio_6_ModificarAssegurancaSoci,
        M_Opcio_7_GuardarLlista,
        M_Opcio_8_RecuperarLlista,
        M_Opcio_9_Sortir  
    };
    // Descripcion de las opciones del menu principal
    private static final String[] descMenu = {
        "Donar d’alta un nou soci",
        "Mostrar llista de socis",
        "Eliminar soci",
        "Mostrar factura",
        "Modificar nom soci",
        "Modificar tipus assegurança soci",
        "Guardar llista",
        "Recuperar llista",
        "Sortir"
    };
    public void gestioMenu(Scanner sc) {     
        
        Menu<OpcionsMenu> menuClub = new Menu<>("Menu ", OpcionsMenu.values());
        
        menuClub.setDescripcions(descMenu);
        
        OpcionsMenu opcioMenu;
        
        Scanner inp;
        String dni;
        String fileName = "socis.dat";
        
        do {
            menuClub.mostrarMenu();
            opcioMenu = menuClub.getOpcio(sc);
            
            switch(opcioMenu) {
                case M_Opcio_1_AfegirSoci:
                    String tipus, nom, fede, asseg;
                    float preu;
                    do{
                        System.out.print("Indica el tipu de soci a afegir: Federat, Estandard o Junior\n");
                        inp = new Scanner(System.in);
                        tipus = inp.nextLine();
                    }while(!tipus.equals("Federat") && !tipus.equals("Estandard") && !tipus.equals("Junior"));
                    if(tipus.equals("Federat")){
                        System.out.print("Escriu el nom del soci\n");
                        inp = new Scanner(System.in);
                        nom = inp.nextLine();
                        System.out.print("Escriu el DNI del soci\n");
                        inp = new Scanner(System.in);
                        dni = inp.nextLine();
                        System.out.print("Escriu el nom de la federació\n");
                        inp = new Scanner(System.in);
                        fede = inp.nextLine();
                        System.out.print("Escriu el preu de la federació\n");
                        inp = new Scanner(System.in);
                        preu = inp.nextFloat();
                        try{
                            club.afegirFederat(nom, dni, fede, preu);
                        }catch(ExcepcioClub ex){
                            System.out.print(ex.getMessage());
                        }   
                    }
                    else{
                        if(tipus.equals("Estandard")){
                            System.out.print("Escriu el nom del soci\n");
                            inp = new Scanner(System.in);
                            nom = inp.nextLine();
                            System.out.print("Escriu el DNI del soci\n");
                            inp = new Scanner(System.in);
                            dni = inp.nextLine();
                            System.out.print("Escriu el nom de la assegurança\n");
                            inp = new Scanner(System.in);
                            asseg = inp.nextLine();
                            System.out.print("Escriu el preu de l'assegurança\n");
                            inp = new Scanner(System.in);
                            preu = inp.nextFloat();
                            try{
                                club.afegirEstandard(nom, dni, asseg, preu);
                            }catch(ExcepcioClub ex){
                               System.out.print(ex.getMessage());
                            }
                        }
                        else{
                            System.out.print("Escriu el nom del soci\n");
                            inp = new Scanner(System.in);
                            nom = inp.nextLine();
                            System.out.print("Escriu el DNI del soci\n");
                            inp = new Scanner(System.in);
                            dni = inp.nextLine();
                            try{
                                club.afegirJunior(nom, dni);
                            }catch(ExcepcioClub ex){
                               System.out.print(ex.getMessage());
                            }
                        }
                    }
                    
                    break;
                case M_Opcio_2_MostrarLlistaSocis:
                    System.out.print(club.getLlistaSocis().toString());
                    break;
                case M_Opcio_3_EliminarSoci:
                    System.out.print("Indica la posició de la llista del soci a eliminar\n");
                    int p;
                    try{
                        inp = new Scanner(System.in);
                        p = inp.nextInt();
                        club.eliminarSoci(p-1);
                        System.out.print("Soci eliminat\n");
                    }catch(ExcepcioClub ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
                case M_Opcio_4_MostrarFactura:
                    int numexc;
                    System.out.print("Escriu el DNI del soci el qual vols la factura\n");
                    try{
                        inp = new Scanner(System.in);
                        dni = inp.nextLine();
                        System.out.print("Escriu el número d'excursions que ha fet el soci\n");
                        inp = new Scanner(System.in);
                        numexc = inp.nextInt();
                        System.out.print(club.crearFactura(dni, numexc));
                    }catch(ExcepcioClub ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
                case M_Opcio_5_ModificarNomSoci:
                    String nounom;
                    System.out.print("Escriu el DNI del soci que vols modificar el nom\n");
                    try{
                        inp = new Scanner(System.in);
                        dni = inp.nextLine();
                        System.out.print("Escriu el nou nom del soci\n");
                        inp = new Scanner(System.in);
                        nounom = inp.nextLine();
                        club.modificarNomSoci(dni, nounom);
                    }catch(ExcepcioClub ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
                case M_Opcio_6_ModificarAssegurancaSoci:
                    String noutipus;
                    System.out.print("Escriu el DNI del soci que vols modificar l'assegurança\n");
                    try{
                        inp = new Scanner(System.in);
                        dni = inp.nextLine();
                        System.out.print("Escriu el nou tipus d'assegurança\n");
                        inp = new Scanner(System.in);
                        noutipus = inp.nextLine();
                        club.modificarAsse(dni, noutipus);
                    }catch(ExcepcioClub ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
                case M_Opcio_7_GuardarLlista:
                    try{
                        club.save(fileName);
                    }catch(ExcepcioClub ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
                case M_Opcio_8_RecuperarLlista:
                    try{
                        club = ClubUB.load(fileName);
                    }catch(ExcepcioClub ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
            }  
        } while(opcioMenu != OpcionsMenu.M_Opcio_9_Sortir);
    }  
}
