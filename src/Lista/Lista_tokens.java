/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import Clases.Tokens_L;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Lista_tokens {
    
    List<Tokens_L> lista =  new ArrayList<>();
    
    
    public void agegarLista(Tokens_L tokens){
        lista.add(tokens);
    }
    
    public void recorrer(){
        for (int i = 0; i < lista.size(); i++) {
            Tokens_L tokens =  lista.get(i);
            System.out.println("#: " + tokens.conteo + "lexem: " + tokens.lexema + "tipo: " + tokens.tipo);
        }
    }
    
    public void limpiar(){
        lista.clear();
    }
}
