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
        String ruta1 = "C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/Lexer.flex";
//        String ruta2 = "C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/LexerCup.flex";
//        String[] rutaS = {"-parser","Sintax","C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/Sintax.cup"};
        generarLexer(ruta1);
        
    }
    
    
   public static void generarLexer(String ruta){
        File archivo =  new File(ruta);
        JFlex.Main.generate(archivo);
    }
//    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
//        File archivo;
//        archivo = new File(ruta1);
//        JFlex.Main.generate(archivo);
//        archivo = new File(ruta2);
//        JFlex.Main.generate(archivo);
//        java_cup.Main.main(rutaS);
//        
//        Path rutaSym = Paths.get("C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/sym.java");
//        if (Files.exists(rutaSym)) {
//            Files.delete(rutaSym);
//        }
//        Files.move(
//                Paths.get("C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/sym.java"), 
//                Paths.get("C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/sym.java")
//        );
//        Path rutaSin = Paths.get("C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/Sintax.java");
//        if (Files.exists(rutaSin)) {
//            Files.delete(rutaSin);
//        }
//        Files.move(
//                Paths.get("C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/Sintax.java"), 
//                Paths.get("C:/Users/Usuario/Desktop/DataForge/OLC1_Proyecto1_202202182/src/Analisador/Sintax.java")
//        );
//    }
    
    
    
}
