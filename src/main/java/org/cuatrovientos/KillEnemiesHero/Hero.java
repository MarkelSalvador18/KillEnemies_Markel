package org.cuatrovientos.KillEnemiesHero;

public class Hero implements Character {

	public boolean isEnemy() {
		return false;
	}
	private String nombre;
	
	
	
	public Hero(String nombre) {
		this.nombre = nombre;
	}
	
	int contadorDeEnemigosMatados;
	public void attack(Enemy enemy) {
		
		System.out.println("¡He atacado a un enemigo!");
		enemy.kill();
		contadorDeEnemigosMatados = contadorDeEnemigosMatados + 1;
	}
	int contadorDeAmigosDefendidos;
	public void defend(Friend friend) {
		System.out.println("¡He defendido a un amigo");
		contadorDeAmigosDefendidos = contadorDeAmigosDefendidos + 1;
	}
	public void heal() {
		System.out.println("¡Te he curado!");
	}
	
}
