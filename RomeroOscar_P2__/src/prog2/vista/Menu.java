/*
 * Universitat de Barcelona
 * ProgramaciÃ³ 2
 * Curs 2015-2016
 */
package prog2.vista;

import java.util.Scanner;

/**
 * Implements a text menu from a list of options.
 * @author Xavi BarÃ³
 */
public class Menu<TEnum> {
     /**
     * Llista de les opcions
     */
    TEnum[] _llistaOpcions=null;

    /**
     * TÃ­tol del menÃº
     */
    String _titol="";

    /**
     * Llista amb els missatges associats a les accions
     */
    String[] _descripcions=null;

    /**
     * Constructor per defecte. Se li ha de passar un enumeraciÃ³ de les opcions.
     * @param titol TÃ­tol del menÃº
     * @param llistaOpcions EnumeraciÃ³ amb les opcions
     */
    public Menu(String titol,TEnum[] llistaOpcions) {
        _titol=titol;
        _llistaOpcions=llistaOpcions;
    }

    /**
     * Permet assignar una descripciÃ³ personalitzada a les opcions del menÃº
     * @param descripcions Llista de descripcions
     */
    public void setDescripcions(String[] descripcions) {
        if(descripcions.length!=_llistaOpcions.length) {
            _descripcions=null;
        } else {
            _descripcions=descripcions;
        }
    }
    
    /**
     * Mostra el menÃº d'opcions
     */
    public void mostrarMenu() {
        // Mostrem les opcions
        String lines="--------------";
        for(int i=0;i<getMaxLen();i++) {
            lines+="-";
        }
        System.out.println(lines);
        System.out.println(_titol.toUpperCase());
        System.out.println(lines);
        for(TEnum c : _llistaOpcions){
            
            // Mostrem la posiciÃ³
            int pos=((Enum)c).ordinal();
            System.out.print("\t" + (pos+1) + ".- ");
            
            // Mostrem la descripciÃ³
            if(_descripcions!=null) {
                System.out.println(_descripcions[pos]);
            } else {
                System.out.println(c);
            }
        }
        System.out.println(lines);
    }

    /**
     * Demana una opciÃ³ utilitzant la entrada passada per parÃ metre.
     * @param sc Canal d'entrada utilitzat per a obtenir la opciÃ³
     * @return OpciÃ³ seleccionada.
     */
    public TEnum getOpcio(Scanner sc) {
        TEnum opcio=null;

        // Demanem una opciÃ³ assegurant que sigui correcta
        int opcioInt=-1;
        do {
            System.out.print("Entra una opcio >> ");
            opcioInt=sc.nextInt();
            sc.nextLine();

            if(opcioInt>0 && opcioInt<=_llistaOpcions.length) {
                // Passem de l'enter a una opcio i la retornem
                opcio=_llistaOpcions[opcioInt-1];
            } else {
                System.err.println("La opciÃ³ seleccionada no Ã©s correcta. Selecciona una opciÃ³ entre 1 i " + (_llistaOpcions.length));
            }
        } while(opcio==null);

        return opcio;
    }

    /**
     * Troba la longitud mÃ xima en les descripcions de les opcions
     * @return Longitud de la descripciÃ³ mÃ©s llarga
     */
    private int getMaxLen() {
        int maxLen=0;

        for(TEnum c : _llistaOpcions){

            // Obtenim la posiciÃ³
            int pos=((Enum)c).ordinal();

            // Mostrem la descripciÃ³
            if(_descripcions!=null) {
                maxLen=Math.max(maxLen, _descripcions[pos].length());
            } else {
                maxLen=Math.max(maxLen, c.toString().length());                
            }
        }

        return maxLen;
    }
}

