/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analisador;

import java.io.File;

/**
 *
 * @author Usuario
 */
public class Compilador {
    public static void main(String[] args) {
        String ruta = "C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/Lexer.flex";
        generarLexer(ruta);
    }
    
    public static void generarLexer(String ruta){
        File archivo =  new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
    
    
}
