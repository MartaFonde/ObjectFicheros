package app;

import java.io.*;
import java.util.*;

public class Ejer10 {

    public static void introducirObj(File f, ArrayList<Persona> listaPersonas, ArrayList<Depart> listaDepart){
        try(FileOutputStream fis = new FileOutputStream(f); ObjectOutputStream out = new ObjectOutputStream(fis)){
            for(Persona p: listaPersonas){
                out.writeObject(p);
            }
            for(Depart d: listaDepart){
                out.writeObject(d);
            }
        }catch(IOException e){
            System.out.println("Error de escritura: "+e.getMessage());
        }
    }

    public static void incluirPersona(File f, Persona p){
        try(FileOutputStream fos = new FileOutputStream(f, true); ObjectOutputStream out = new AppendingObjectOutputStream(fos)){
            out.writeObject(p);
        }catch(IOException e){
            System.out.println("Error de escritura: "+e.getMessage());
        }
    }
    
    public static void incluirDepart(File f, Depart d){
        try(FileOutputStream fos = new FileOutputStream(f, true); ObjectOutputStream out = new AppendingObjectOutputStream(fos)){
            out.writeObject(d);
        }catch(IOException e){
            System.out.println("Error de escritura: "+e.getMessage());
        }
    }

    public static void consultarPersonas(File f){
        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream in = new ObjectInputStream(fis)){
            while(true){
                Object o = in.readObject();
                if(o instanceof Persona){
                    Persona p = (Persona)o;
                    p.mostrarDatos();
                }
            }
        }catch(EOFException eof){
            System.out.println("Fin de fichero");
        }catch(ClassNotFoundException c){
            System.out.println("Clase no encontrada");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void consultarPersona(File f, Persona p){
        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream in = new ObjectInputStream(fis)){
            while(true){
                Object o = in.readObject();
                if(o instanceof Persona){
                    Persona persona = (Persona)o;
                    if(persona.getDni().equals(p.getDni())){
                        p.mostrarDatos();
                    }
                }
            }
        }catch(EOFException eof){
            System.out.println("Fin de fichero");
        }catch(ClassNotFoundException c){
            System.out.println("Clase no encontrada");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void consultarDeparts(File f){
        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream in = new ObjectInputStream(fis)){
            while(true){
                Object o = in.readObject();
                if(o instanceof Depart){
                    Depart d = (Depart)o;
                    d.mostrarDatos();
                }
            }
        }catch(EOFException eof){
            System.out.println("Fin de fichero");
        }catch(ClassNotFoundException c){
            System.out.println("Clase no encontrada");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void consultarDepart(File f, Depart d){
        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream in = new ObjectInputStream(fis)){
            while(true){
                Object o = in.readObject();
                if(o instanceof Depart){
                    Depart depart = (Depart)o;
                    if(depart.getIDdepart() == d.getIDdepart()){
                        d.mostrarDatos();
                    }
                }
            }
        }catch(EOFException eof){
            System.out.println("Fin de fichero");
        }catch(ClassNotFoundException c){
            System.out.println("Clase no encontrada");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void borrarPersona(File f, Persona p){
        File nuevoFich = new File(f.getAbsolutePath().replace(f.getName(), "act.txt"));

        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream in = new ObjectInputStream(fis);
            FileOutputStream fos = new FileOutputStream(nuevoFich); ObjectOutputStream out = new ObjectOutputStream(fos)){
            while(true){
                Object o = in.readObject();
                if(o instanceof Persona){
                    Persona persona = (Persona)o;
                    if(!persona.getDni().equals(p.getDni())){
                        out.writeObject(persona);
                    }
                } else if(o instanceof Depart){
                    Depart d = (Depart)o;
                    out.writeObject(d);
                }
            }                
        }catch(EOFException eof){
            System.out.println("Fin de fichero");
        }catch(ClassNotFoundException c){
            System.out.println("Clase no encontrada");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
        nuevoFich.renameTo(f);
    }

    public static void borrarDepart(File f, Depart d){
        File nuevoFich = new File(f.getAbsolutePath().replace(f.getName(), "act.txt"));

        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream in = new ObjectInputStream(fis);
            FileOutputStream fos = new FileOutputStream(nuevoFich); ObjectOutputStream out = new ObjectOutputStream(fos)){
            while(true){
                Object o = in.readObject();
                if(o instanceof Depart){
                    Depart depart = (Depart)o;
                    if(depart.getIDdepart() != d.getIDdepart()){
                        out.writeObject(depart);
                    }
                } else if(o instanceof Persona){
                    Persona p = (Persona)o;
                    out.writeObject(p);
                }
            }                
        }catch(EOFException eof){
            System.out.println("Fin de fichero");
        }catch(ClassNotFoundException c){
            System.out.println("Clase no encontrada");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
        nuevoFich.renameTo(f);
    }
}