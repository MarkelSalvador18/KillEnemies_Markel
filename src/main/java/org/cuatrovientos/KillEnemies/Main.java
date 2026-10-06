package org.cuatrovientos.KillEnemies;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        
    	ArrayList<Character> listaDePersonajes = new ArrayList<Character>();
    	
    		for (int i = 0; i < 5; i++) {
    			listaDePersonajes.add(new Friend());
    			
    		}
    		
    		for (int i = 0; i < 5; i++) {
    			listaDePersonajes.add(new Enemy());
    			
    		}
    		
    		Collections.shuffle(listaDePersonajes);
    	
    		for (int i = 0; i < listaDePersonajes.size(); i ++) {
    			Character personaje = listaDePersonajes.get(i);
    			
    			if (personaje.isEnemy()) {
    				System.out.println("El personaje " + i + " es un enemigo! ¡Matalo!");
    				Enemy enemigo = (Enemy) personaje;
    				enemigo.kill();
    			} else {
    				System.out.println("El personaje " + i + " es un amigo!");
    			}
    		}
    }
}
