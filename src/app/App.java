package app;

import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        ArrayList<Depart> listaDepart = new ArrayList<Depart>();
        
        Persona p = new Persona("Laura", 26, "48923657M");
        listaPersonas.add(p);
        p = new Persona("Alex", 27, "56201458R");
        listaPersonas.add(p);

        Depart d = new Depart(1, "A Coruña", 15);
        listaDepart.add(d);
        d = new Depart(2, "Santander", 10);
        listaDepart.add(d);

        File f = new File("src/app/lista.txt");
        Ejer10.introducirObj(f, listaPersonas, listaDepart);
        p = new Persona("Carme", 59, "31053212H");
        Ejer10.incluirPersona(f, p);
        d = new Depart(3, "Santiago", 16);
        Ejer10.incluirDepart(f, d);
        Ejer10.consultarDeparts(f);
        Ejer10.consultarPersonas(f);
        System.out.println();
        // Ejer10.borrarPersona(f, p);
        // Ejer10.consultarPersonas(f);
        // Ejer10.borrarDepart(f, d);
        // Ejer10.consultarDeparts(f);
        Ejer10.consultarDepart(f, d);
        Ejer10.consultarPersona(f, p);
    }
    
}