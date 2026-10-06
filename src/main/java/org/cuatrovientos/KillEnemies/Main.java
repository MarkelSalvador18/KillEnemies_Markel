package org.cuatrovientos.KillEnemies;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        
    	ArrayList<Character> personajes = new ArrayList<Character>();
    	
    		for (int i = 0; i < 5; i++) {
    			personajes.add(new Friend());
    			
    		}
    		
    		for (int i = 0; i < 5; i++) {
    			personajes.add(new Enemy());
    			
    		}
    		
    		Collections.shuffle(personajes);
    		
    		for (Character p : personajes) {
				if (p.isEnemy() == true) {
					System.out.println("El personaje ");
				}
			}
    		
    		
    }
}
