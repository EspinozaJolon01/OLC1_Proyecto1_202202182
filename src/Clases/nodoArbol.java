/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class nodoArbol {
    
    public String nombre;
    public String rol;
    public String tipo;
    public String entorno;
    public String pertenece_a;
    public String valor;
    public int conteo;

    public nodoArbol(int conteo,String nombre, String rol, String tipo, String entorno, String pertenece_a, String valor) {
        this.conteo = conteo;
        this.nombre = nombre;
        this.rol = rol;
        this.tipo = tipo;
        this.entorno = entorno;
        this.pertenece_a = pertenece_a;
        this.valor = valor;
    }
    
    
    
    
}
