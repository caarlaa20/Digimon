import java.util.Random;

/**
 * La clase Domador representa a un domador de Digimon, que puede capturar Digimon y formar un equipo con ellos.
 */
class Domador {

    /** El nombre del domador. */
    private String nombre;

    /** El equipo de Digimon del domador. */
    private Digimon[] equipo = new Digimon[3];

    /**
     * Constructor de Domador que inicializa un nuevo domador con un nombre dado y un equipo predeterminado de Digimon.
     * @param nombre El nombre del domador.
     */
    Domador(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.equipo[0] = new Digimon("Agumon");
        this.equipo[1] = new Digimon("Gabumon");
        this.equipo[2] = new Digimon("Patamon");
    }

    /**
     * Captura un Digimon y lo añade al equipo del domador si su salud es menor o igual a 20.
     * @param digimon El Digimon que se intenta capturar.
     */
    void captura(Digimon digimon) {
        if (digimon.getSalud() <= 20) {
            System.out.println(digimon.getNombre() + " se ha unido a su equipo.");
            // Implementar lógica para añadir el Digimon al equipo
        } else {
            System.out.println("No se puede unir.");
        }
    }

    // Getters para los atributos

    /**
     * Obtiene el nombre del domador.
     * @return El nombre del domador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el equipo de Digimon del domador.
     * @return El equipo de Digimon del domador.
     */
    public Digimon[] getEquipo() {
        return equipo;
    }
}
