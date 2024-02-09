/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analisador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Usuario
 */
public class Compilador {

    
    
    public static void main(String[] args) throws Exception {
        System.out.println (new File ("").getAbsolutePath ());
        String rutap = new File ("").getAbsolutePath ()+"/";
        String ruta1 = rutap +"src/Analisador/Lexer.flex";
        String ruta2 = rutap+"src/Analisador/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", rutap+"src/Analisador/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        System.out.println (new File (".").getAbsolutePath ());
        String rutap = new File ("").getAbsolutePath ()+"/";
        Path rutaSym = Paths.get(rutap+"src/Analisador/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(rutap+"sym.java"), 
                Paths.get(rutap+"src/Analisador/sym.java")
        );
        Path rutaSin = Paths.get(rutap+"src/Analisador/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(rutap+"Sintax.java"), 
                Paths.get(rutap+"src/Analisador/Sintax.java")
        );
    
    }
    
    
}
