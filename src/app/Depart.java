package app;

import java.io.Serializable;

public class Depart implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 8975836099640759423L;
    
    int idDepart;
    String ciudad;
    int numEmpleados;

    public Depart(int id, String ciudad, int empleados){
        this.idDepart = id;
        this.ciudad = ciudad;
        this.numEmpleados = empleados;
    }

    public int getIDdepart() {
        return idDepart;
    }

    public void setIDdepart(int id) {
        this.idDepart = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public void mostrarDatos(){
        System.out.println("ID depart: "+idDepart);
        System.out.println("Ciudad: "+ciudad);
        System.out.println("Número de empleados: "+numEmpleados);
    }
    
}