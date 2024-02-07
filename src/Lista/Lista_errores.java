/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import Clases.Errores;
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
    
    
    
}
