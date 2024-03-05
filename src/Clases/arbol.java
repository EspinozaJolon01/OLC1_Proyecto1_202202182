/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Luis Jolon
 */
public class arbol {
    
    public String lex;
    public ArrayList<arbol>hijos;
    private String result;
    
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
            case "maximo":
                double maximo = Double.MIN_VALUE;
                for (double valor : valores) {
                    if (valor > maximo) {
                        maximo = valor;
                    }
                }
                return maximo;
            case "minimo":
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


    
    public void run(arbol raiz, ArrayList<nodoArbol> Ts){
        for(arbol hijo : raiz.hijos){
            run(hijo,Ts);
        }
        if(raiz.lex == "FUNES" && raiz.hijos.size()==1){
            raiz.result = raiz.hijos.get(0).result;
            
        }else if(raiz.lex == "FUNES" && raiz.hijos.size()==3){
            raiz.result = raiz.hijos.get(1).result;
        }
        else if(raiz.lex == "LISTA_VALORES" && raiz.hijos.size()==1){ //obtener los arreglos 
            raiz.result = raiz.hijos.get(0).result;    
        }else if(raiz.lex == "LISTA_VALORES" && raiz.hijos.size()==3){
            raiz.result = raiz.hijos.get(0).result + raiz.hijos.get(1).lex + raiz.hijos.get(2).result;
        }else if(raiz.lex == "TARRELGOS" && raiz.hijos.size()==5){ //Arr:a Tipo:t  Arroba:ar Identificador:i  LISTA_VALORES:li  
            nodoArbol nA= new nodoArbol(raiz.hijos.get(2).lex + raiz.hijos.get(3).lex, "arreglo", raiz.hijos.get(1).lex, "local", "--", raiz.hijos.get(4).result);
            Ts.add(nA);
        }
        else if(raiz.lex == "TIPCONTENIDO" && raiz.hijos.size()==1){ //produccion de numero,cadenas e identificadores
            if(raiz.hijos.get(0).lex.substring(0,1).equals("\"")){ //obtengo la primera indice
                raiz.result = raiz.hijos.get(0).lex;
            }else{
                try {
                double variable = Double.parseDouble(raiz.hijos.get(0).lex);
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
            raiz.result = raiz.hijos.get(0).lex;
            raiz.result = raiz.hijos.get(1).lex;
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
            nodoArbol nA= new nodoArbol(raiz.hijos.get(2).lex, "variable", raiz.hijos.get(1).lex, "local", "--", raiz.hijos.get(3).result);
            Ts.add(nA);
        }
    }
    
}
