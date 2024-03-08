/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class Errores {
    
    public int conteo;
    public String descip;
    public String tipo;
    public int columna;
    public int linea;
    
    
    public Errores(int conteo, String tipo, String descip,int linea,int columna){
        this.conteo = conteo;
        this.descip = descip;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;

    
    }


    
}
