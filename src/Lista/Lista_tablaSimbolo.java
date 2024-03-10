/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import Analisador.LexerCup;
import Clases.Tokens_L;
import Clases.nodoArbol;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Lista_tablaSimbolo {
    
    public void reporte(ArrayList<nodoArbol> Ts){
        StringBuilder htmlCodigo =  new StringBuilder();
        
        htmlCodigo.append("<!DOCTYPE html>");
        htmlCodigo.append("<html lang=\"en\">");
        htmlCodigo.append("<head>");
        htmlCodigo.append(" <meta charset=\"UTF-8\">");
        htmlCodigo.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        htmlCodigo.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        htmlCodigo.append("<title>Reporte Simbolos</title>");
        htmlCodigo.append("</head>");
        htmlCodigo.append("<h1>Reporte de Simbolos</h1>");
        htmlCodigo.append("<center>");
        htmlCodigo.append("<table border=\"1\">");
        htmlCodigo.append("<thead>");
        htmlCodigo.append("<tr>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">#</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Nombre</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Tipo</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Valor</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Linea</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Columna</th>");

        htmlCodigo.append("</tr>");
        htmlCodigo.append("</thead>");
        htmlCodigo.append("<body>");
        htmlCodigo.append("<tr>");
       
        
        for(nodoArbol elemento: Ts){
             
             htmlCodigo.append("<td>" + elemento.conteo+ "</td>");
             htmlCodigo.append("<td>"+ elemento.nombre + "</td>");
             htmlCodigo.append("<td>"+ elemento.rol + " " + elemento.tipo +"</td>");
             htmlCodigo.append("<td>"+ elemento.valor+"</td>");
             htmlCodigo.append("<td>"+ elemento.linea+"</td>");
             htmlCodigo.append("<td>"+ elemento.columna+"</td>");
             htmlCodigo.append("</tr>");
             
        }
        
        htmlCodigo.append("</table>");
        htmlCodigo.append("</center>");
        htmlCodigo.append("<h5>Jose Luis Espinoza Jolon</h5>");
        htmlCodigo.append("<h5>202202182</h5>");
        htmlCodigo.append("</body>");
        htmlCodigo.append("</html>");
        
          try {

            File file = new File("C:/Users/Usuario/Desktop/Usac/Tabla_de_simbolos" + ".html");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(htmlCodigo.toString());
            fileWriter.close();

            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void limpiar(ArrayList<nodoArbol> Ts){
        Ts.clear();
    }
    
}
