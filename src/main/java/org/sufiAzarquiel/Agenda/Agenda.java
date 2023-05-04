package org.sufiAzarquiel.Agenda;

import java.util.ArrayList;

public class Agenda implements java.io.Serializable {

    //Atributo
    ArrayList<Contacto> contactos;

    //Constructores

    //Este constructor sirve para crear una agenda en blanco
    public Agenda() {
        this.contactos = new ArrayList<Contacto>();
    }

    //Este constructor sirve para crear una agenda con una lista de contactos ya creada
    public Agenda(ArrayList<Contacto> contactos) {
        super();
        this.contactos = contactos;
    }

    //Métodos
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "Agenda [contactos=" + contactos + "]";
    }

    //añadir un contacto
    public void add(Contacto contacto) {
        this.contactos.add(contacto);
    }

    //borrar un contacto
    public boolean delete(Contacto contacto) {
        return this.contactos.remove(contacto);
    }

    public boolean delete(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                this.contactos.remove(contacto);
                return true;
            }
        }
        return false;
    }

    //buscar un contacto
    public Contacto get(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public Contacto get(int posicion) {
        return this.contactos.get(posicion);
    }

    //actualizar un contacto
    public void update(String nombreAntiguo, String nombreNuevo) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombreAntiguo)) {
                contacto.setNombre(nombreNuevo);
                return;
            }
        }
    }

    public void update(Contacto antiguo, Contacto nuevo) {
        this.contactos.remove(antiguo);
        this.contactos.add(nuevo);
    }

    //preguntar el tamaño de la agenda
    public int length() {
        return this.contactos.size();
    }
}
