/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

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
    
    public void run(arbol raiz, ArrayList<nodoArbol> Ts){
        for(arbol hijo : raiz.hijos){
            run(hijo,Ts);
        }
         
        //produccion de numero,cadenas e identificadores
        if(raiz.lex == "TIPCONTENIDO" && raiz.hijos.size()==1){ 
            raiz.result = raiz.hijos.get(0).lex;
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
        }else if(raiz.lex == "CONTENIDO" && raiz.hijos.size()==1){
            raiz.result = raiz.hijos.get(0).result;
        }else if(raiz.lex == "DECLRACION" && raiz.hijos.size()==4){ //Var:v  Tipo:t  Identificador:i  CONTENIDO:N  
            nodoArbol nA= new nodoArbol(raiz.hijos.get(2).lex, "variable", raiz.hijos.get(1).lex, "local", "--", raiz.hijos.get(3).result);
            Ts.add(nA);
        }
    }
    
}
