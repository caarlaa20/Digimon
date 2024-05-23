import java.util.Random;

/**
 * La clase BatallaDigital representa una batalla entre un Digimon y un enemigo.
 * El enemigo se elige aleatoriamente entre una lista predefinida de nombres de Digimon.
 */
class BatallaDigital {

    /** El Digimon enemigo con el que se está llevando a cabo la batalla. */
    private Digimon enemigo;

    /**
     * Constructor de BatallaDigital que inicializa una nueva batalla con un Digimon enemigo aleatorio.
     */
    BatallaDigital() {
        Random rand = new Random();
        String[] nombresEnemigos = {"Greymon", "Garurumon", "Angemon"};
        this.enemigo = new Digimon(nombresEnemigos[rand.nextInt(nombresEnemigos.length)]);
    }

    /**
     * Obtiene el Digimon enemigo de la batalla.
     * @return El Digimon enemigo de la batalla.
     */
    public Digimon getEnemigo() {
        return enemigo;
    }
}
