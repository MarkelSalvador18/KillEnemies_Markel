package org.cuatrovientos.KillEnemiesHero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Character> listaDePersonajes = new ArrayList<Character>();
		Scanner scn = new Scanner(System.in);
		boolean continua = false;
		
		System.out.println("Bienvenido al mundo de Pamplona, te dejo un pequeño resumen sobre el mundo:");
		System.out.println("Año 1512, una guerra que lleva 10 años en pie");
		System.out.println("Existen dos bandos: La última llama y El imperio Carmesi");
		System.out.println("Perteneces al bando de La última llama y debes elegir un rol para ayudar a ganar la guerra");
		
		do {
			System.out.println("Debes elegir personaje: ");
			System.out.println("");
			
			String texto;
			System.out.print("Introduce el nombre del Hero: ");
			texto = scn.nextLine();
			if (texto != null) {
				continua = true;
				System.out.println("¡Acaba con los enemigos " + texto + "!");
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
		
		for (Character per : listaDePersonajes) {
			if (per.isEnemy()) {
				System.out.println("Quedan enemigos, quieres matarlo?(S/N)");
				txt = scn.nextLine()
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
