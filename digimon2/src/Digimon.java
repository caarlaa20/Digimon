
import java.util.Random;

/**
 * La clase Digimon representa a una criatura digital con atributos como nombre, nivel, puntos de ataque y salud.
 * También tiene dos puntos de defensa que pueden disminuir con el tiempo.
 */
class Digimon {

    /** El nombre del Digimon. */
    private String nombre;

    /** El nivel del Digimon. */
    private int nivel;

    /** Los puntos de ataque del Digimon. */
    private int puntosAtaque;

    /** La salud del Digimon. */
    private int salud;

    /** El primer punto de defensa del Digimon. */
    private int dp1;

    /** El segundo punto de defensa del Digimon. */
    private int dp2;

    /**
     * Constructor de Digimon que inicializa un nuevo Digimon con un nombre dado.
     * Los demás atributos se inicializan de manera aleatoria basándose en el nivel.
     * @param nombre El nombre del Digimon.
     */
    Digimon(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.nivel = rand.nextInt(5) + 1;
        this.puntosAtaque = this.nivel * 5;
        this.salud = this.nivel * 10;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     * Realiza el primer ataque del Digimon, reduciendo el primer punto de defensa.
     */
    void ataque1() {
        System.out.println(this.nombre + " ha usado Ataque1 y ha causado " + this.puntosAtaque + " de daño.");
        this.dp1--;
    }

    /**
     * Realiza el segundo ataque del Digimon, reduciendo el segundo punto de defensa.
     */
    void ataque2() {
        System.out.println(this.nombre + " ha usado Ataque2 y ha causado " + (this.puntosAtaque * 2) + " de daño.");
        this.dp2 -= 2;
    }

    // Getters y setters para los atributos

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getDp1() {
        return dp1;
    }

    public int getDp2() {
        return dp2;
    }
}
