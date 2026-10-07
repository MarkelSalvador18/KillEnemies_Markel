package org.cuatrovientos.KillEnemiesHero;


public class Friend implements Character {

	@Override
	public boolean isEnemy() {
		return false;
	}
	
	private int vida = 100;
	
	public Friend(int vida) {
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
}
