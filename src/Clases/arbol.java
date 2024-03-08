/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Analisador.LexerCup;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JTextArea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Luis Jolon
 */
public class arbol {
    
    public String lex;
    public ArrayList<arbol>hijos;
    public Map<String, String> hashMap = new HashMap<>();
    public static int imageCounter = 0;
    public static int imageCounter1 = 0;
    public static int imageCounter2 = 0;
    public static int imageCounter3 = 0;
    private String result;
    public int conteo = 1;
    
    public arbol(String lex){
        this.lex = lex;
        this.hijos = new ArrayList();
    }
    
    
    public void addHijo(arbol hijo){
        this.hijos.add(hijo);
    }
    
    public void printArbol(arbol raiz){
        for (arbol hijo : raiz.hijos ) {
            printArbol(hijo);
        }
        System.out.println(raiz.lex);
    }
    
    public String getValor(ArrayList<nodoArbol>Ts,String nombre){
        for(nodoArbol elemento : Ts){
            if(elemento.nombre.equals(nombre)){
                return elemento.valor;
            }
        }
        return "Error semantcio";
    }
    
    public String getArreglo(ArrayList<nodoArbol>Ts,String nombre){
        
        for(nodoArbol elemento : Ts){
            if(elemento.nombre.equals(nombre)){
                System.out.println(elemento.nombre + "=" + nombre);
                return elemento.valor;
            }
        }
        return "Error semantcio";
    }
    
    public String imprimir(String titulo, String contenido) {
        StringBuilder result = new StringBuilder();
        result.append("------------\n");
        result.append(titulo).append("\n");
        result.append("------------\n");
        String[] arregloN = contenido.split(",");
        for (String elemento : arregloN) {
            result.append(elemento).append("\n");
        }

        return result.toString();
    }
    public static void Graficar(String tipo,Map<String, String> hashMap,JTextArea txtconsola) throws IOException{
        System.out.println(tipo);
        switch (tipo){
            case "graphbar":
                System.out.println("obtengo una grafica graphbar");
                System.out.println("----------------------------");
                String valor = hashMap.get("titulo");
                String valor1 = hashMap.get("ejeX");
                String[] categorias = valor1.split(",");
                String valor2 = hashMap.get("ejeY");
                String[] valoresStr = valor2.split(",");
                double[] valores = new double[valoresStr.length];
        
                // Convertir elementos de valoresStr a double y guardarlos en valores[]
                for (int i = 0; i < valoresStr.length; i++) {
                    valores[i] = Double.parseDouble(valoresStr[i]);
                }

                String valor3 = hashMap.get("tituloX");
                String valor4 = hashMap.get("tituloY");

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                for (int i = 0; i < categorias.length; i++) {
                    dataset.addValue(valores[i], valor4, categorias[i]);
                }

                JFreeChart chart = ChartFactory.createBarChart3D(
                        valor, valor3, valor4, dataset);

                // Crear un nombre de archivo único con un contador
                String fileName = "barChart_" + imageCounter++ + ".png";

                // Guardar la gráfica como imagen PNG con el nombre de archivo único
                int width = 800;
                int height = 600;
                File barChart = new File("C:/Users/Usuario/Desktop/img/" + fileName);
                ChartUtilities.saveChartAsPNG(barChart, chart, width, height);
                        
                
                break;
            case "graphpie":
                System.out.println("obtengo una grafica graphpie");
                System.out.println("----------------------------");
                String valor11 = hashMap.get("label");
                String[] categoriasLabel = valor11.split(",");
                String valor12 = hashMap.get("values");
                String[] valoresStr1 = valor12.split(",");
                double[] valores1 = new double[valoresStr1.length];
        
                // Convertir elementos de valoresStr a double y guardarlos en valores[]
                for (int i = 0; i < valoresStr1.length; i++) {
                    valores1[i] = Double.parseDouble(valoresStr1[i]);
                }
                String valor13 = hashMap.get("titulo");
                
                DefaultPieDataset dataset1 = new DefaultPieDataset();
                
                for (int i = 0; i < categoriasLabel.length; i++) {
                    
                    dataset1.setValue(categoriasLabel[i],valores1[i]);
                }
                
                JFreeChart grafica_circular = ChartFactory.createPieChart(valor13, dataset1);
                
                String fileName1 = "pieChart_" + imageCounter1++ + ".png";

                // Guardar la gráfica como imagen PNG con el nombre de archivo único
                int width1 = 800;
                int height1 = 600;
                File pieChart = new File("C:/Users/Usuario/Desktop/img/" + fileName1);
                ChartUtilities.saveChartAsPNG(pieChart, grafica_circular, width1, height1);

                
                
                break;
            case "graphline":
                System.out.println("obtengo una grafica graphline");
                System.out.println("----------------------------");
                String titulo = hashMap.get("titulo");
                String tituloX = hashMap.get("tituloX");
                String tituloY = hashMap.get("tituloY");
                String ejeX = hashMap.get("ejeX");
                String ejeY = hashMap.get("ejeY");

                String[] categoriasLinea = ejeX.split(","); // Datos para el eje X
                String[] valoresLineaStr = ejeY.split(","); // Datos para el eje Y
                double[] valoresLinea = new double[valoresLineaStr.length];

                // Convertir elementos de valoresLineaStr a double y guardarlos en valoresLinea
                for (int i = 0; i < valoresLineaStr.length; i++) {
                    valoresLinea[i] = Double.parseDouble(valoresLineaStr[i]);
                }

                DefaultCategoryDataset datasetLinea = new DefaultCategoryDataset();

                for (int i = 0; i < categoriasLinea.length; i++) {
                    datasetLinea.addValue(valoresLinea[i], tituloY, categoriasLinea[i]);
                }

                JFreeChart chartLinea = ChartFactory.createLineChart(
                        titulo, // Título del gráfico
                        tituloX, // Etiqueta del eje X
                        tituloY, // Etiqueta del eje Y
                        datasetLinea, // Dataset
                        PlotOrientation.VERTICAL, // Orientación del gráfico
                        true, // Incluir leyenda
                        true, // Incluir tooltips
                        false // Incluir URLs
                );

                // Crear un nombre de archivo único con un contador
                String fileNameLinea = "lineChart_" + imageCounter2++ + ".png";

                // Guardar la gráfica como imagen PNG con el nombre de archivo único
                int widthLinea = 800;
                int heightLinea = 600;
                File lineChart = new File("C:/Users/Usuario/Desktop/img/" + fileNameLinea);
                ChartUtilities.saveChartAsPNG(lineChart, chartLinea, widthLinea, heightLinea);
   
                break;
                
            case "histogram":
                System.out.println("----------------------------");
                String valora1 = hashMap.get("titulo");
                String valorb2 = hashMap.get("values");
                String[] valoresDato = valorb2.split(",");
                int[] valoresINT = new int[valoresDato.length];

                // Convertir elementos de valoresLineaStr a double y guardarlos en valoresLinea
                for (int i = 0; i < valoresDato.length; i++) {
                    valoresINT[i] = Integer.parseInt(valoresDato[i]);
                }
                
                

                Map<Integer, Integer> frecuenciaAbsoluta = new HashMap<>();
                for (int i = 0; i < valoresINT.length; i++) {
                    int valordato = valoresINT[i];
                    frecuenciaAbsoluta.put(valordato, frecuenciaAbsoluta.getOrDefault(valordato, 0) + 1);
                }

                int frecuenciaAcumulada = 0;
                Map<Integer, Integer> frecuenciaAcumuladaMap = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : frecuenciaAbsoluta.entrySet()) {
                    frecuenciaAcumulada += entry.getValue();
                    frecuenciaAcumuladaMap.put(entry.getKey(), frecuenciaAcumulada);
                }

                int totalDatos = valoresINT.length;
                Map<Integer, Double> frecuenciaRelativa = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : frecuenciaAbsoluta.entrySet()) {
                    frecuenciaRelativa.put(entry.getKey(), (double) entry.getValue() / totalDatos);
                }
                
                

                txtconsola.append(valora1 +"\n");
                txtconsola.append("---------------------------\n");
                txtconsola.append("valor     fb     fa   fr\n");

                for (Map.Entry<Integer, Integer> entry : frecuenciaAbsoluta.entrySet()) {
                    int valorres = entry.getKey();
                    int fb = entry.getValue();
                    int fa = frecuenciaAcumuladaMap.get(valorres);
                    double fr = frecuenciaRelativa.get(valorres) * 100;

                    txtconsola.append(String.format("%-9d %-6d %-6d %.0f%%\n", valorres, fb, fa, fr));
                }

                txtconsola.append("---------------------------\n");
                txtconsola.append("totales:   " + frecuenciaAcumulada + "       " + totalDatos + "     100%\n");
                
                //grafica 
                
                DefaultCategoryDataset datasetLinea1 = new DefaultCategoryDataset();
                
                for (Map.Entry<Integer, Integer> entry : frecuenciaAbsoluta.entrySet()) {
                    int valorres = entry.getKey();
                    int fb = entry.getValue();
                    datasetLinea1.addValue(fb , "",String.valueOf(valorres) );

                    
                }

                

                JFreeChart chartLinea1 = ChartFactory.createBarChart3D(
                        valora1, // Título del gráfico
                        "", // Etiqueta del eje X
                        "", // Etiqueta del eje Y
                        datasetLinea1, // Dataset
                        PlotOrientation.VERTICAL, // Orientación del gráfico
                        true, // Incluir leyenda
                        true, // Incluir tooltips
                        false // Incluir URLs
                );

                // Crear un nombre de archivo único con un contador
                String fileNameLinea1 = "HistromChart_" + imageCounter3++ + ".png";

                // Guardar la gráfica como imagen PNG con el nombre de archivo único
                int widthLinea1 = 800;
                int heightLinea1 = 600;
                File lineChart1 = new File("C:/Users/Usuario/Desktop/img/" + fileNameLinea1);
                ChartUtilities.saveChartAsPNG(lineChart1, chartLinea1, widthLinea1, heightLinea1);
                break;
            default:
                System.out.println("Tipo de gráfico no reconocido");
        }
    }
    
    
    public String imprimirHistrogram(String titulo, String contenido) {
        StringBuilder result = new StringBuilder();
        result.append("------------\n");
        result.append(titulo).append("\n");
        result.append("------------\n");
        String[] arregloN = contenido.split(",");
        for (String elemento : arregloN) {
            result.append(elemento).append("\n");
        }

        return result.toString();
    }


    
    

    
    public static double FuncionEstaditicos(String tipo, String arreglo) {
        String[] arregloN = arreglo.split(",");
        double[] valores = new double[arregloN.length];
        
        // Convertir elementos de arregloN a double y guardarlos en valores[]
        for (int i = 0; i < arregloN.length; i++) {
            valores[i] = Double.parseDouble(arregloN[i]);
        }
        
        System.out.println(valores);

        switch (tipo) {
            case "media":
                double sumaMedia = 0;
                for (double valor : valores) {
                    sumaMedia += valor;
                }
                return sumaMedia / valores.length;
            case "mediana":
                Arrays.sort(valores);
                int longitud = valores.length;
                if (longitud % 2 == 0) {
                    return (valores[longitud / 2 - 1] + valores[longitud / 2]) / 2.0;
                } else {
                    return valores[longitud / 2];
                }
            case "moda":
                Map<Double, Integer> frecuencia = new HashMap<>();
                for (double valor : valores) {
                    frecuencia.put(valor, frecuencia.getOrDefault(valor, 0) + 1);
                }

                double moda = Double.MIN_VALUE;
                int maxFrecuencia = Integer.MIN_VALUE;
                for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
                    if (entry.getValue() > maxFrecuencia) {
                        moda = entry.getKey();
                        maxFrecuencia = entry.getValue();
                    }
                }
                return moda;
            case "varianza":
                double sumaCuadrados = 0;
                double mediaVarianza = FuncionEstaditicos("media", arreglo);
                for (double valor : valores) {
                    sumaCuadrados += Math.pow(valor - mediaVarianza, 2);
                }
                return sumaCuadrados / valores.length;
            case "max":
                double maximo = Double.MIN_VALUE;
                for (double valor : valores) {
                    if (valor > maximo) {
                        maximo = valor;
                    }
                }
                return maximo;
            case "min":
                double minimo = Double.MAX_VALUE;
                for (double valor : valores) {
                    if (valor < minimo) {
                        minimo = valor;
                    }
                }
                return minimo;
            default:
                throw new IllegalArgumentException("Tipo de función estadística no válido: " + tipo);
        }
    }


    
    public void run(arbol raiz, ArrayList<nodoArbol> Ts, JTextArea txtconsola) throws IOException{
        
        for(arbol hijo : raiz.hijos){
            run(hijo,Ts, txtconsola);
        }
        
        if(raiz.lex == "GRAFIC" && raiz.hijos.size() == 2){
            Graficar(raiz.hijos.get(0).lex,hashMap,txtconsola);
            //System.out.println(raiz.hijos.get(0).lex);
            //System.out.println(raiz.hijos.get(1).result);
            raiz.result = raiz.hijos.get(0).lex;
            raiz.result = raiz.hijos.get(1).result;
            
        }else if(raiz.lex == "COMSENTENCIAS" && raiz.hijos.size() == 2){
            //System.out.println("2");
            raiz.result = raiz.hijos.get(0).result + raiz.hijos.get(1);
            //System.out.println(raiz.hijos.get(0).result + raiz.hijos.get(1));
        }else if(raiz.lex == "COMSENTENCIAS" && raiz.hijos.size() == 1){
            //System.out.println("3");
            raiz.result = raiz.hijos.get(0).result;
            //System.out.println(raiz.hijos.get(0).result);
        }else if(raiz.lex == "ATRIBUGRAFIC" && raiz.hijos.size()==3){
            //obtengo todo los datos 
            
        
        
            
            //System.out.println(raiz.hijos.get(0).lex);
            if(raiz.hijos.get(0).lex.equalsIgnoreCase("values")){
                //System.out.println(raiz.hijos.get(2).result);
                raiz.result = raiz.hijos.get(1).lex;
                raiz.result = raiz.hijos.get(2).result;
                hashMap.put("values", raiz.hijos.get(2).result);
                
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("label")){
                //System.out.println(raiz.hijos.get(2).result);
                raiz.result = raiz.hijos.get(1).lex;
                raiz.result = raiz.hijos.get(2).result;
                hashMap.put("label", raiz.hijos.get(2).result);
                
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("tituloX")){
                //System.out.println(raiz.hijos.get(2).lex);
                raiz.result = raiz.hijos.get(1).lex;
                raiz.result = raiz.hijos.get(2).lex;
                hashMap.put("tituloX", raiz.hijos.get(2).lex);
                
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("tituloY")){
                //System.out.println(raiz.hijos.get(2).lex);
                raiz.result = raiz.hijos.get(1).lex;
                raiz.result = raiz.hijos.get(2).lex;
                hashMap.put("tituloY", raiz.hijos.get(2).lex);
                
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("ejeY")){
                //System.out.println(raiz.hijos.get(2).result);
                raiz.result = raiz.hijos.get(1).lex;
                raiz.result = raiz.hijos.get(2).result;
                hashMap.put("ejeY", raiz.hijos.get(2).result);
                
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("ejeX")){
                //System.out.println(raiz.hijos.get(2).result);
                raiz.result = raiz.hijos.get(1).lex;
                raiz.result = raiz.hijos.get(2).result;
                hashMap.put("ejeX", raiz.hijos.get(2).result);
                
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("titulo")){
                //System.out.println("--" +raiz.hijos.get(2).lex);
                raiz.result = raiz.hijos.get(1).lex;
                raiz.result = raiz.hijos.get(2).lex;
                hashMap.put("titulo", raiz.hijos.get(2).lex);
            }
     
         
        }else if(raiz.lex == "COMENT" && raiz.hijos.size()==2){
            //agregarElemento(raiz.hijos.get(1).result);
            
            //System.out.println("que traer: " + raiz.hijos.get(1).result);
        }else if(raiz.lex == "COMENTARIO" && raiz.hijos.size()==3){
            System.out.println("--" +raiz.hijos.get(0).lex);
            System.out.println("--" +raiz.hijos.get(1).result);
            System.out.println("--" +raiz.hijos.get(2).result);
            String resultado = imprimir(raiz.hijos.get(1).result, raiz.hijos.get(2).result); // Llamar a la función imprimir
    
            txtconsola.append(resultado);
            raiz.result = raiz.hijos.get(0).lex;
            raiz.result = raiz.hijos.get(1).result;
            raiz.result = raiz.hijos.get(2).result;
        }else if(raiz.lex == "COMENTARIO" && raiz.hijos.size()==2){
            
            raiz.result = raiz.hijos.get(0).lex;
            txtconsola.append(raiz.hijos.get(1).result + "\n");
            //raiz.result = raiz.hijos.get(1).result;
        }else if(raiz.lex == "ARREGLOSTIP" && raiz.hijos.size()==1){
            String val =  this.getArreglo(Ts, raiz.hijos.get(0).result);
                
                if(val.equals("Error semantcio")){
                    System.out.println("Error semantcio, variable no encontrada");
                }else{
                    raiz.result = val;
                    System.out.println("-" +val);
                }
        }else if(raiz.lex == "ARREGLOSTIP" && raiz.hijos.size()==3){
            raiz.result = raiz.hijos.get(1).result;
        }else if(raiz.lex == "FUNES" && raiz.hijos.size()==1){
            System.out.println("estoy aqui");
            
                String val =  this.getArreglo(Ts, raiz.hijos.get(0).result);
                
                if(val.equals("Error semantcio")){
                    System.out.println("Error semantcio, variable no encontrada");
                }else{
                    raiz.result = val;
                    System.out.println("-" +val);
                }
            
            
        }else if(raiz.lex == "FUNES" && raiz.hijos.size()==3){
            raiz.result = raiz.hijos.get(1).result;
        }
        else if(raiz.lex == "LISTA_VALORES" && raiz.hijos.size()==1){ //obtener los arreglos 
            raiz.result = raiz.hijos.get(0).result;    
        }else if(raiz.lex == "LISTA_VALORES" && raiz.hijos.size()==3){
            raiz.result = raiz.hijos.get(0).result + raiz.hijos.get(1).lex + raiz.hijos.get(2).result;
        }else if(raiz.lex == "TARRELGOS" && raiz.hijos.size()==5){ //Arr:a Tipo:t  Arroba:ar Identificador:i  LISTA_VALORES:li  
            nodoArbol nA= new nodoArbol(conteo,raiz.hijos.get(2).lex + raiz.hijos.get(3).lex, "arreglo", raiz.hijos.get(1).lex, "local", "--", raiz.hijos.get(4).result);
            Ts.add(nA);
            conteo++;
        }
        else if(raiz.lex == "TIPCONTENIDO" && raiz.hijos.size()==1){ //produccion de numero,cadenas e identificadores
            if(raiz.hijos.get(0).lex.substring(0,1).equals("\"")){ //obtengo la primera indice
                raiz.result = raiz.hijos.get(0).lex;
            }else{
                try {
                double variable = Double.parseDouble(raiz.hijos.get(0).lex);  //sum(hola,3)
                raiz.result = raiz.hijos.get(0).lex;
            } catch (Exception e) {
                String val =  this.getValor(Ts, raiz.hijos.get(0).lex);
                if(val.equals("Error semantcio")){
                    System.out.println("Error semantcio, variable no encontrada");
                }else{
                    raiz.result = val;
                }
            }
                
            }
            
        }else if(raiz.lex == "TIPCONTENIDO" && raiz.hijos.size()==2){ //produccion del arroba 
            raiz.result = raiz.hijos.get(0).lex + raiz.hijos.get(1).lex;
        }else if(raiz.lex == "TIPCONTENIDO" && raiz.hijos.size()==3){
            if(raiz.hijos.get(0).lex.equalsIgnoreCase("sum")){
                raiz.result = String.valueOf(Double.parseDouble(raiz.hijos.get(1).result) + Double.parseDouble(raiz.hijos.get(2).result));
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("res")){
                raiz.result = String.valueOf(Double.parseDouble(raiz.hijos.get(1).result) - Double.parseDouble(raiz.hijos.get(2).result));
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("mul")){
                raiz.result = String.valueOf(Double.parseDouble(raiz.hijos.get(1).result) * Double.parseDouble(raiz.hijos.get(2).result));
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("div")){
                raiz.result = String.valueOf(Double.parseDouble(raiz.hijos.get(1).result) / Double.parseDouble(raiz.hijos.get(2).result));
            }else if(raiz.hijos.get(0).lex.equalsIgnoreCase("mod")){
                raiz.result = String.valueOf(Double.parseDouble(raiz.hijos.get(1).result) % Double.parseDouble(raiz.hijos.get(2).result));
            }
        }else if(raiz.lex == "TIPCONTENIDO" && raiz.hijos.size()==4){
            
            raiz.result = String.valueOf(this.FuncionEstaditicos(raiz.hijos.get(0).lex, raiz.hijos.get(2).result));
      
            
        }else if(raiz.lex == "DECLRACION" && raiz.hijos.size()==4){ //Var:v  Tipo:t  Identificador:i  CONTENIDO:N  
            //System.out.println("Var: " + raiz.hijos.get(2));
            nodoArbol nA= new nodoArbol(conteo,raiz.hijos.get(2).lex, "variable", raiz.hijos.get(1).lex, "local", "--", raiz.hijos.get(3).result);
            conteo++;
            Ts.add(nA);
            
        }
    }
    
    
    
}
