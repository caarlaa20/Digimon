package Digimon;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del domador: ");
        String nombreDomador = scanner.nextLine();

        Domador domador = new Domador(nombreDomador);
        BatallaDigital batallaDigital = new BatallaDigital();

        int opcion;
        do {
        	System.out.println("""



					-------------------------------------------------

					|  -1. Iniciar Batalla              		    |

					|  -2. Salir               					    |

					| 	Elija una opcion:       	                |

					-------------------------------------------------

					    """);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Digimon enemigo = batallaDigital.getEnemigo();
                    System.out.println("Ha aparecido un enemigo");
                    System.out.println("El enemigo es: " + enemigo.getNombre());
                    System.out.println();

                    // El jugador elige que Digimon utilizar
                    System.out.println("Selecciona un Digimon para enfrentar al enemigo:");
                    Digimon[] equipo = domador.getEquipo();
                    for (int i = 0; i < equipo.length; i++) {
                        System.out.println((i + 1) + ". " + equipo[i].getNombre());
                    }
                    System.out.println("Elija un numero: ");
                    int digimonIndex = scanner.nextInt() - 1;
                    Digimon digimonElegido = equipo[digimonIndex];
                    System.out.println("Has elegido a: " + digimonElegido.getNombre());
                    System.out.println();

                    // Comienza la batalla
                    boolean seguirBatalla = true;
                    while (seguirBatalla) {
                        System.out.println("¿Que accion deseas realizar?");
                        System.out.println("1. Atacar");
                        System.out.println("2. Usar habilidad especial");
                        System.out.println("3. Intentar capturar al enemigo");
                        System.out.println("4. Cambiar de Digimon");
                        System.out.println("5. Salir de la batalla");
                        System.out.print("Elija una opcion: ");
                        int accion = scanner.nextInt();

                        switch (accion) {
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
                                System.out.print("Elija un numero: ");
                                digimonIndex = scanner.nextInt() - 1;
                                digimonElegido = equipo[digimonIndex];
                                System.out.println("Has cambiado a: " + digimonElegido.getNombre());
                                break;
                            case 5:
                                seguirBatalla = false;
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                                break;
                        }

                        if (enemigo.getSalud() <= 0) {
                            System.out.println("Has derrotado al enemigo");
                            seguirBatalla = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 2);

        scanner.close();
    }
}
