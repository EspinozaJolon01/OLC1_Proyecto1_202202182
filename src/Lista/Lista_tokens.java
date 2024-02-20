/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import Analisador.LexerCup;
import Clases.Errores;
import Clases.Tokens_L;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Lista_tokens {
    
    //public static List<Tokens_L> lista_T =  new ArrayList<>();
    
    
//    public void agegarLista(Tokens_L tokens){
//        lista.add(tokens);
//    }
    
    public void recorrer(){
        for (int i = 0; i < LexerCup.lista_T.size(); i++) {
            Tokens_L tokens =  LexerCup.lista_T.get(i);
            System.out.println("#: " + tokens.conteo + "lexem: " + tokens.lexema + "tipo: " + tokens.tipo);
        }
    }
    
    public void limpiar(){
        LexerCup.lista_T.clear();
    }
    
    public void reporte(){
        StringBuilder htmlCodigo =  new StringBuilder();
        
        htmlCodigo.append("<!DOCTYPE html>");
        htmlCodigo.append("<html lang=\"en\">");
        htmlCodigo.append("<head>");
        htmlCodigo.append(" <meta charset=\"UTF-8\">");
        htmlCodigo.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        htmlCodigo.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        htmlCodigo.append("<title>Reporte Tokens</title>");
        htmlCodigo.append("</head>");
        htmlCodigo.append("<h1>Reporte de tokens</h1>");
        htmlCodigo.append("<center>");
        htmlCodigo.append("<table border=\"1\">");
        htmlCodigo.append("<thead>");
        htmlCodigo.append("<tr>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">#</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Lexema</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Tipo</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Línea</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Columna</th>");

        htmlCodigo.append("</tr>");
        htmlCodigo.append("</thead>");
        htmlCodigo.append("<body>");
        htmlCodigo.append("<tr>");
        
        
        for(int i=0;i <LexerCup.lista_T.size();i++){
             Tokens_L tokens_L =  LexerCup.lista_T.get(i);
             htmlCodigo.append("<td>" + tokens_L.conteo+ "</td>");
             htmlCodigo.append("<td>"+ tokens_L.lexema + "</td>");
             htmlCodigo.append("<td>"+ tokens_L.tipo+"</td>");
             htmlCodigo.append("<td>"+ tokens_L.Linea+"</td>");
             htmlCodigo.append("<td>"+ tokens_L.Columna+"</td>");
             htmlCodigo.append("</tr>");
             
        }
        
        htmlCodigo.append("</table>");
        htmlCodigo.append("</center>");
        htmlCodigo.append("<h5>Jose Luis Espinoza Jolon</h5>");
        htmlCodigo.append("<h5>202202182</h5>");
        htmlCodigo.append("</body>");
        htmlCodigo.append("</html>");
        
          try {

            File file = new File("C:/Users/Usuario/Desktop/Usac/reporte-tokens" + ".html");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(htmlCodigo.toString());
            fileWriter.close();

            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
