/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class Tokens_L {
    
    public int conteo;
    public String lexema;
    public String tipo;
    public int Linea;
    public int Columna;
    
    
    public Tokens_L(int conteo, String lexema,String tipo, int Linea, int Columna){
        this.conteo = conteo;
        this.lexema = lexema;
        this.tipo = tipo;
        this.Columna = Columna;
        this.Linea = Linea;
    }



    
}
