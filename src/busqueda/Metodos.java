/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busqueda;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP PORTATIL
 */
public class Metodos {
    
    /**
     * Retorna un arraylist con numero aleatoreos
     * @param size Tamaño del array
     * @return El array generado
    **/
    public static ArrayList<Integer> generateRandomArrayList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(1, size+1));
        }
        return arrayList;
    }
    
    /**
     * Retorna un arraylist con una recta numerica
     * @param tamano Tamaño del array
     * @return El array generado
    **/
    public static ArrayList<Integer> generarRectaNumerica(int tamano) {
        ArrayList<Integer> arrayList = new ArrayList<>(tamano);
        for (int i = 0; i < tamano; i++) {
            arrayList.add(i+1);
        }
        return arrayList;
    }
    
    /**
     * Retorna un arraylist Organizado
     * @param Lista El arraylis desordenado
     * @return El arraylis Ordenado
    **/
    public static ArrayList<Integer> Quicksort(ArrayList<Integer> Lista){
        if (Lista.size() <= 1){
            return Lista;
        }
        
        int pivotIndex = Lista.size()/2;
        int pivotValue = Lista.get(pivotIndex);
        
        ArrayList<Integer> menores = new ArrayList<>();
        ArrayList<Integer> mayores = new ArrayList<>();
        ArrayList<Integer> iguales = new ArrayList<>();
        
        for (int i = 0; i < Lista.size(); i++) {
            int value = Lista.get(i);
            if (value < pivotValue) {
                menores.add(value);
            } else if (value > pivotValue) {
                mayores.add(value);
            } else {
                iguales.add(value);
            }
        }
        
        ArrayList<Integer> ordenado = new ArrayList<>();
        ordenado.addAll(Quicksort(menores));
        ordenado.addAll(iguales);
        ordenado.addAll(Quicksort(mayores));
        
        return ordenado;
    }
}
