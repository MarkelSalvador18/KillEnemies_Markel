package org.cuatrovientos.KillEnemiesHero;

public class Enemy implements Character {

	@Override
	public boolean isEnemy() {
		return true;
	}
	
	public void kill() {
		System.out.println("Ahhhgg, me mataste, bastardo!");
	}
	
	private int vida = 100;
	public Enemy(int vida) {
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
}
