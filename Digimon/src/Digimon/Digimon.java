package Digimon;
import java.util.Random;

class Digimon {
    private String nombre;
    private int nivel;
    private int puntosAtaque;
    private int salud;
    private int dp1;
    private int dp2;

    Digimon(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.nivel = rand.nextInt(5) + 1;
        this.puntosAtaque = this.nivel * 5;
        this.salud = this.nivel * 10;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    void ataque1() {
        System.out.println(this.nombre + " ha usado Ataque1 y ha causado " + this.puntosAtaque + " de daño.");
        this.dp1--;
    }

    void ataque2() {
        System.out.println(this.nombre + " ha usado Ataque2 y ha causado " + (this.puntosAtaque * 2) + " de daño.");
        this.dp2 -= 2;
    }

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