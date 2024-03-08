/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Analisador.LexerCup;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JTextArea;

/**
 *
 * @author Luis Jolon
 */
public class arbol {
    
    public String lex;
    public ArrayList<arbol>hijos;
    public Map<String, String> hashMap = new HashMap<>();

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
    public static void Graficar(String tipo,Map<String, String> hashMap){
        System.out.println(tipo);
        switch (tipo){
            case "graphbar":
                System.out.println("obtengo una grafica graphbar");
                System.out.println("----------------------------");
                String valor = hashMap.get("titulo");
                String valor1 = hashMap.get("ejeX");
                String valor2 = hashMap.get("ejeY");
                String valor3 = hashMap.get("tituloX");
                String valor4 = hashMap.get("tituloY");
                System.out.println("titulo: " + valor + "\n"
                        + "ejeX: " + valor1 + "\n"
                        + "ejeY: " + valor2 + "\n"
                        + "tituloX: " + valor3 + "\n"
                        + "tituloY: " + valor4 + "\n");
                break;
            case "graphpie":
                System.out.println("obtengo una grafica graphpie");
                System.out.println("----------------------------");
                String valor11 = hashMap.get("label");
                String valor12 = hashMap.get("values");
                String valor13 = hashMap.get("titulo");
                System.out.println("label: " + valor11 + "\n"
                        + "values: " + valor12 + "\n"
                        + "titulo: " + valor13+ "\n");
                
                break;
            case "graphline":
                System.out.println("obtengo una grafica graphline");
                System.out.println("----------------------------");
                String valora = hashMap.get("titulo");
                String valorb = hashMap.get("ejeX");
                String valorc = hashMap.get("ejeY");
                String valord = hashMap.get("tituloX");
                String valorf = hashMap.get("tituloY");
                System.out.println("titulo: " + valora + "\n"
                        + "ejeX: " + valorb + "\n"
                        + "ejeY: " + valorc + "\n"
                        + "tituloX: " + valord + "\n"
                        + "tituloY: " + valorf + "\n");
                break;
                
            case "histogram":
                System.out.println("----------------------------");
                String valora1 = hashMap.get("titulo");
                String valorb2 = hashMap.get("values");
                System.out.println("titulo: " + valora1 + "\n"
                        + "values: " + valorb2 + "\n" );
                break;
            default:
                System.out.println("Tipo de gráfico no reconocido");
        }
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


    
    public void run(arbol raiz, ArrayList<nodoArbol> Ts, JTextArea txtconsola){
        
        for(arbol hijo : raiz.hijos){
            run(hijo,Ts, txtconsola);
        }
        
        if(raiz.lex == "GRAFIC" && raiz.hijos.size() == 2){
            Graficar(raiz.hijos.get(0).lex,hashMap);
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
            txtconsola.append(raiz.hijos.get(1).result);
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
