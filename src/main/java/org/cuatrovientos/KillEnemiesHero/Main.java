package org.cuatrovientos.KillEnemiesHero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Character> listaDePersonajes;
		Scanner scn = new Scanner(System.in);
		File archivo = new File("juego.dat");
		boolean continua = false;
		
		if (archivo.exists()) {
			System.out.println("Cargando partida...");
			FileInputStream file = new FileInputStream("juego.dat");
			ObjectInputStream objectInput = new ObjectInputStream(file);
			listaDePersonajes = (ArrayList<Character>) objectInput.readObject();
			objectInput.close();
		} else {
			System.out.println("Creando nuevos personajes...");
            listaDePersonajes = new ArrayList<>();
		}
		
		String nombreDelHeroe;
		do {
			
			System.out.print("Introduce el nombre del Hero: ");
			nombreDelHeroe = scn.nextLine();
			if (nombreDelHeroe != null) {
				continua = true;
				System.out.println("¡Acaba con los enemigos " + nombreDelHeroe + "!");
			}
		} while (continua);
		
		for (int i = 0; i < 5; i++) {
			listaDePersonajes.add(new Friend(100));
		}
		
		for (int i = 0; i < 5; i++) {
			listaDePersonajes.add(new Enemy(100));	
		}
		Collections.shuffle(listaDePersonajes);
		
		String txt = "";
		boolean quiereMatar = false;
		boolean tienePiedad = false;
		for (int i = 0; i < listaDePersonajes.size(); i++) {
		    Character per = listaDePersonajes.get(i);

		    if (per.isEnemy()) {
		        boolean respuestaValida = false;
		        
		        do {
		            System.out.println("El personaje " + i + " es un enemigo. ¿Quieres matarlo? (S/N)");
		            	txt = scn.nextLine();

		            if (txt.equalsIgnoreCase("S")) {
		                Enemy enemigo = (Enemy) per;
		                enemigo.kill();
		                
		                listaDePersonajes.remove(i);
		                i = i-1; 
		                
		                System.out.println("¡Este enemigo ha muerto!");
		                respuestaValida = true;
		            } else if (txt.equalsIgnoreCase("N")) {
		                System.out.println("Vaya... Tenemos un héroe llamado " + nombreDelHeroe + " con piedad!");
		               
		                listaDePersonajes.add(per);
		                System.out.println("¡Al dejarlo con vida, el enemigo se ha duplicado al final de la lista!");
		                
		                respuestaValida = true;
		            } else {
		                System.out.println("Introduce bien la opción (S/N)");
		            }
		        } while (!respuestaValida);

		    } else {
		        boolean respuestaValida = false;

		        do {
		            System.out.println("El personaje " + i + " es un amigo. ¿Quieres defenderlo? (S/N)");
		            txt = scn.nextLine();

		            if (txt.equalsIgnoreCase("S")) {
		                System.out.println("¡Buena elección!");
		                System.out.println("Gracias " + nombreDelHeroe + ", ¡has defendido a tu amigo!");
		                respuestaValida = true;
		            } else if (txt.equalsIgnoreCase("N")) {
		                System.out.println("Al parecer " + nombreDelHeroe + " quiere matar a un amigo...");
		                
		                listaDePersonajes.remove(i);
		                i = i-1;
		                
		                System.out.println("Has matado a tu amigo.");
		                respuestaValida = true;
		            } else {
		                System.out.println("Introduce bien la opción (S/N)");
		            }
		        } while (!respuestaValida);
		    }
		}
		
		int contadorDeEnemigos = 0;
		int contadorDeAmigos = 0;
		for (Character per : listaDePersonajes) {
			if (per.isEnemy()) {
				contadorDeEnemigos = contadorDeEnemigos + 1;
				
			} else {
				contadorDeAmigos = contadorDeAmigos +1;
			}
		}
		System.out.println("Enemigos actuales: " + contadorDeEnemigos);
		System.out.println("Amigos actuales: " + contadorDeAmigos);
		
		showCharacters(listaDePersonajes);
		FileOutputStream fileOutput = new FileOutputStream("juego.dat");
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
		
		objectOutput.writeObject(listaDePersonajes);
		objectOutput.close();
		System.out.println("Se ha guardado la partida");
	}

	public static void showCharacters(ArrayList<Character> lista) {
		for (int i = 0; i < lista.size(); i++) {
			Character personaje = lista.get(i);
			if (personaje.isEnemy()) {
				System.out.println("Indice " + i + " Es enemigo!");
			} else {
				System.out.println("Indice " + i + " Es amigo");
			}
		}
	}
	
	
}
