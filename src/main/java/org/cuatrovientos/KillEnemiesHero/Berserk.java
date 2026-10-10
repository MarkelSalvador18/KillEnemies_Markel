package org.cuatrovientos.KillEnemiesHero;

import java.io.Serializable;

public  class Berserk implements Character, Serializable {

	@Override
    public boolean isEnemy() {
        return true;
    }


    public void ataqueMatadragones(String nombreHeroe) {
    	System.out.println("¡CLANG! Guts blande la Matadragones gritando: ¡" + nombreHeroe.toUpperCase() + "!");
        System.out.println("¡El poder del Berserker arrasa con el campo de batalla!");
    }
	
}
