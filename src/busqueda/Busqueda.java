/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busqueda;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HP PORTATIL
 */
public class Busqueda {

    private static ArrayList<Integer> Lista = new ArrayList<>();
    
    /**
     * Genera el arraylist dependiendo de una eleccion
     * @param Tipo 1. Recta Numerica 2. Aleatoreo
     * @param Tamaño El tamaño del arraylis
     * @return tiempo que se tarda generando en milisegundos
     */
    public static long Generar(int Tipo, int Tamaño){
        long tiempo = System.currentTimeMillis();
        
        switch(Tipo){
            case 1:
                Lista=Metodos.generarRectaNumerica(Tamaño);
                break;
            case 2:
                Lista = Metodos.generateRandomArrayList(Tamaño);
                Lista = Metodos.Quicksort(Lista);
                break;
        }
        
        tiempo = System.currentTimeMillis() - tiempo;
        
        return tiempo;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresa el tipo del arreglo\n- ");
        int Tipo = in.nextInt();
        System.out.print("Ingresa el tamaño del arreglo\n- ");
        int Tamaño = in.nextInt();
        
        long TiempoGeneracion = Generar(Tipo, Tamaño);
        
        System.out.print("Arreglo: "+Lista+"\nTiempo de generacion"+TiempoGeneracion);
    }
    
}
