import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.Inet4Address;
import java.net.Inet6Address;

public class Tarea23 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            InetAddress equipo = InetAddress.getLocalHost();

            System.out.println("Nombre del equipo: " + equipo.getHostName());
            System.out.println("Direccion IP: " + equipo.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("Error");;
        }

        String dominio;

        do {
            System.out.print("\nIntroduce un dominio o 'salir'' para terminar): ");
            dominio = scanner.nextLine();

            if (!dominio.equalsIgnoreCase("salir")) {

                try {
                InetAddress
                        [] direcciones = InetAddress.getAllByName(dominio);

                System.out.println("Direcciones IP de " + dominio + ":");

                for (InetAddress direccion : direcciones) {

                    if (direccion instanceof Inet4Address) {
                        System.out.println("IPv4: " + direccion.getHostAddress());

                    } else if (direccion instanceof Inet6Address) {
                        System.out.println("IPv6: " + direccion.getHostAddress());
                    }
                }

            } catch (UnknownHostException e) {
                System.out.println("Error");
            }
            }

        } while (!dominio.equalsIgnoreCase("salir"));

        System.out.println("Programa finalizado");

        scanner.close();
    }

            }



