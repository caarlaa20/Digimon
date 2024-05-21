package Digimon;

import java.util.Random;

class BatallaDigital {
    private Digimon enemigo;

    BatallaDigital() {
        Random rand = new Random();
        String[] nombresEnemigos = {"Greymon", "Garurumon", "Angemon"};
        this.enemigo = new Digimon(nombresEnemigos[rand.nextInt(nombresEnemigos.length)]);
    }

    public Digimon getEnemigo() {
        return enemigo;
    }
}
