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
    
    public static int Buscar(int Iinicial, int BNum, ArrayList<Integer> lista){
        int posicion = Iinicial;
        int centro = lista.size()/2;
        
        if(lista.size()<=1){
            posicion = -1;
        }else if(lista.get(centro)== BNum){
            posicion = posicion + centro;
        }else{
            ArrayList<Integer> sublista = new ArrayList<>();
            int inicio;
            if (BNum < lista.get(centro)){
                inicio = Iinicial;
                for(int i = inicio ; i<centro ; i++){
                    sublista.add(lista.get(i));
                }
            }else{
                inicio = Iinicial + centro+1;
                for(int i = inicio ; i<lista.size() ; i++){
                    sublista.add(lista.get(i));
                }
            }
            posicion=Buscar(inicio, BNum, sublista);
        }
        
        return posicion;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresa el tipo del arreglo\n- ");
        int Tipo = in.nextInt();
        System.out.print("Ingresa el tamaño del arreglo\n- ");
        int Tamaño = in.nextInt();
        
        long TiempoGeneracion = Generar(Tipo, Tamaño);
        
        System.out.println("Arreglo: "+Lista+"\nTiempo de generacion: "+TiempoGeneracion);
        
        System.out.print("\nIngrese el numero que busca\n- ");
        int busqueda = in.nextInt();
        
        System.out.println("El indise es "+Buscar(0, busqueda, Lista));
    }
    
}
