/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import Clases.Errores;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Lista_errores {
    
    
    List<Errores> lista =  new ArrayList<>();
    
    
    public void agegarLista(Errores error){
        lista.add(error);
    }
    
    public void recorrer(){
        for (int i = 0; i < lista.size(); i++) {
            Errores error =  lista.get(i);
            System.out.println("#: " + error.conteo + "tipo: " + error.tipo + "Despcion: " + error.descip);
        }
    }
    
    public void limpiar(){
        lista.clear();
    }
    
    
    public void reportesErrores(){
        
        StringBuilder htmlCodigo =  new StringBuilder();
        
        htmlCodigo.append("<!DOCTYPE html>");
        htmlCodigo.append("<html lang=\"en\">");
        htmlCodigo.append("<head>");
        htmlCodigo.append(" <meta charset=\"UTF-8\">");
        htmlCodigo.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        htmlCodigo.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        htmlCodigo.append("<title>Reportes errores</title>");
        htmlCodigo.append("</head>");
        htmlCodigo.append("<h1>Reporte de Errores</h1>");
        htmlCodigo.append("<center>");
        htmlCodigo.append("<table border=\"1\">");
        htmlCodigo.append("<thead>");
        htmlCodigo.append("<tr>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">#</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Tipo</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Descripción</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Línea</th>");
        htmlCodigo.append("<th style=\"background-color: #1E1E1E; color: #FFFFFF;\">Columna</th>");

        htmlCodigo.append("</tr>");
        htmlCodigo.append("</thead>");
        htmlCodigo.append("<body>");
        htmlCodigo.append("<tr>");
        
        
        for(int i=0;i <lista.size();i++){
             Errores error =  lista.get(i);
             htmlCodigo.append("<td>" + error.conteo+ "</td>");
             htmlCodigo.append("<td>"+ error.tipo + "</td>");
             htmlCodigo.append("<td>"+ error.descip+"</td>");
             htmlCodigo.append("<td></td>");
             htmlCodigo.append("<td></td>");
             htmlCodigo.append("</tr>");
             
        }
        
        htmlCodigo.append("</table>");
        htmlCodigo.append("</center>");
        htmlCodigo.append("<h5>Jose Luis Espinoza Jolon</h5>");
        htmlCodigo.append("<h5>202202182</h5>");
        htmlCodigo.append("</body>");
        htmlCodigo.append("</html>");
        
          try {

            File file = new File("C:/Users/Usuario/Desktop/Usac/reporte-errores" + ".html");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(htmlCodigo.toString());
            fileWriter.close();

            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    
}
