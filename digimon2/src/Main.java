//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

/**
 * La clase Main es la clase principal que contiene el método main para ejecutar el juego Digimon.
 */
public class Main {

    /**
     * El método main es el punto de entrada del programa.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Se solicita al usuario que ingrese el nombre del domador
        System.out.print("Ingrese el nombre del domador: ");
        String nombreDomador = scanner.nextLine();

        // Se crea un nuevo domador y una batalla digital
        Domador domador = new Domador(nombreDomador);
        BatallaDigital batallaDigital = new BatallaDigital();

        int opcion;
        do {
            // Se muestra el menú de opciones al usuario
            System.out.println("""
                                -------------------------------------------------
                                |  -1. Iniciar Batalla                              |
                                |  -2. Salir                                         |
                                |    Elija una opcion:                               |
                                -------------------------------------------------
                                """);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Se obtiene el enemigo para la batalla
                    Digimon enemigo = batallaDigital.getEnemigo();
                    System.out.println("Ha aparecido un enemigo");
                    System.out.println("El enemigo es: " + enemigo.getNombre());
                    System.out.println();

                    // El jugador elige qué Digimon utilizar
                    System.out.println("Selecciona un Digimon para enfrentar al enemigo:");
                    Digimon[] equipo = domador.getEquipo();
                    for (int i = 0; i < equipo.length; i++) {
                        System.out.println((i + 1) + ". " + equipo[i].getNombre());
                    }
                    System.out.println("Elija un número: ");
                    int digimonIndex = scanner.nextInt() - 1;
                    Digimon digimonElegido = equipo[digimonIndex];
                    System.out.println("Has elegido a: " + digimonElegido.getNombre());
                    System.out.println();

                    // Comienza la batalla
                    boolean seguirBatalla = true;
                    while (seguirBatalla) {
                        // Se muestra el menú de acciones al usuario durante la batalla
                        System.out.println("¿Qué acción deseas realizar?");
                        System.out.println("1. Atacar");
                        System.out.println("2. Usar habilidad especial");
                        System.out.println("3. Intentar capturar al enemigo");
                        System.out.println("4. Cambiar de Digimon");
                        System.out.println("5. Salir de la batalla");
                        System.out.print("Elija una opción: ");
                        int accion = scanner.nextInt();

                        switch (accion) {
                            // Se realiza la acción seleccionada por el usuario
                            case 1:
                                System.out.println("Has realizado un ataque.");
                                digimonElegido.ataque1();
                                enemigo.setSalud(enemigo.getSalud() - digimonElegido.getPuntosAtaque());
                                System.out.println("La salud del enemigo ahora es: " + enemigo.getSalud());
                                break;
                            case 2:
                                System.out.println("Has usado una habilidad especial.");
                                digimonElegido.ataque2();
                                enemigo.setSalud(enemigo.getSalud() - (digimonElegido.getPuntosAtaque() * 2));
                                System.out.println("La salud del enemigo ahora es: " + enemigo.getSalud());
                                break;
                            case 3:
                                System.out.println("Intentas capturar al enemigo.");
                                domador.captura(enemigo);
                                break;
                            case 4:
                                // El jugador cambia de Digimon
                                System.out.println("Selecciona otro Digimon:");
                                for (int i = 0; i < equipo.length; i++) {
                                    System.out.println((i + 1) + ". " + equipo[i].getNombre());
                                }
                                System.out.print("Elija un número: ");
                                digimonIndex = scanner.nextInt() - 1;
                                digimonElegido = equipo[digimonIndex];
                                System.out.println("Has cambiado a: " + digimonElegido.getNombre());
                                break;
                            case 5:
                                // El usuario decide salir de la batalla
                                seguirBatalla = false;
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }

                        // Se comprueba si el enemigo ha sido derrotado
                        if (enemigo.getSalud() <= 0) {
                            System.out.println("Has derrotado al enemigo");
                            seguirBatalla = false;
                        }
                    }
                    break;
                case 2:
                    // El usuario decide salir del juego
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 2);

        scanner.close();
    }
}
