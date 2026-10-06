package org.cuatrovientos.KillEnemiesHero;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Character> listaDePersonajes = new ArrayList<Character>();
		Scanner scn = new Scanner(System.in);
		boolean continua = false;
		
		do {
			
			String texto;
			System.out.print("Introduce el nombre del Hero: ");
			texto = scn.nextLine();
			if (texto != null) {
				continua = true;
				System.out.println("¡Acaba con los enemigos " + texto + "!");
			}
		} while (continua);
		
	}

}
