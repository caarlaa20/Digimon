package Digimon;

import java.util.Random;

class Domador {
    private String nombre;
    private Digimon[] equipo = new Digimon[3];

    Domador(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.equipo[0] = new Digimon("Agumon");
        this.equipo[1] = new Digimon("Gabumon");
        this.equipo[2] = new Digimon("Patamon");
    }

    void captura(Digimon digimon) {
        if (digimon.getSalud() <= 20) {
            System.out.println(digimon.getNombre() + " se ha unido a su equipo.");
            // Implementar lógica para añadir el Digimon al equipo
        } else {
            System.out.println("No se puede unir.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Digimon[] getEquipo() {
        return equipo;
    }
}
