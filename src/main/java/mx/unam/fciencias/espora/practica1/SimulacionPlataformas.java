package mx.unam.fciencias.espora.practica1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimulacionPlataformas {

    public static void main(String[] args) {

        try (PrintWriter salida = new PrintWriter(new FileWriter("simulacion.txt"))) {

            salida.println("----- Inicio de la simulación -----");

            Spootify spootify = new Spootify();
            Thisney thisney = new Thisney();
            Memeflix memeflix = new Memeflix();
            Momazon momazon = new Momazon();
            Hvo hvo = new Hvo();

            TarifaEstrategia memeflix1 = new TarifaMemeflixUno();
            TarifaEstrategia memeflix2 = new TarifaMemeflixDos();
            TarifaEstrategia memeflix4 = new TarifaMemeflixCuatro();
            TarifaEstrategia momazonNormal = new TarifaMomazonNormal();
            TarifaEstrategia momazonPremium = new TarifaMomazonPremium();
            TarifaEstrategia spootifyNormal = new TarifaSpootifyNormal();
            TarifaEstrategia spootifyPremium = new TarifaSpootifyPremium();
            TarifaEstrategia thisneyTarifa = new TarifaThisney();
            TarifaEstrategia hvoTarifa = new TarifaHvo();

            List<Sujeto> servicios = new LinkedList<>();
            servicios.add(memeflix);
            servicios.add(momazon);
            servicios.add(spootify);
            servicios.add(thisney);
            servicios.add(hvo);

            Cliente alicia = new Cliente("Alicia", 15000);
            Cliente bob = new Cliente("Bob", 2400);
            Cliente cesar = new Cliente("Cesar", 5000);
            Cliente diego = new Cliente("Diego", 9000);
            Cliente erika = new Cliente("Erika", 10000);
            Cliente fausto = new Cliente("Fausto", 5000);

            salida.println("\n--- Suscripciones iniciales ---");
            alicia.suscribirServicio(memeflix, memeflix4, salida);
            alicia.suscribirServicio(momazon, momazonPremium, salida);
            alicia.suscribirServicio(spootify, spootifyPremium, salida);
            alicia.suscribirServicio(thisney, thisneyTarifa, salida);
            alicia.suscribirServicio(hvo, hvoTarifa, salida);

            bob.suscribirServicio(memeflix, memeflix4, salida);
            bob.suscribirServicio(momazon, momazonPremium, salida);
            bob.suscribirServicio(spootify, spootifyPremium, salida);
            bob.suscribirServicio(thisney, thisneyTarifa, salida);
            bob.suscribirServicio(hvo, hvoTarifa, salida);

            cesar.suscribirServicio(thisney, thisneyTarifa, salida);
            cesar.suscribirServicio(hvo, hvoTarifa, salida);

            diego.suscribirServicio(hvo, hvoTarifa, salida);
            diego.suscribirServicio(momazon, momazonPremium, salida);
            diego.suscribirServicio(spootify, spootifyNormal, salida);

            erika.suscribirServicio(memeflix, memeflix4, salida);
            erika.suscribirServicio(spootify, spootifyNormal, salida);
            erika.suscribirServicio(hvo, hvoTarifa, salida);

            fausto.suscribirServicio(thisney, thisneyTarifa, salida);
            fausto.suscribirServicio(hvo, hvoTarifa, salida);

            for (int mes = 0; mes < 12; mes++) {
                salida.println("\n--- Mes " + (mes + 1) + " ---");
                switch (mes) {
                    case 3:
                        // bob
                        bob.cancelarServicio(thisney, salida);
                        bob.cancelarServicio(hvo, salida);

                        // erika
                        erika.cancelarServicio(hvo, salida);
                        erika.suscribirServicio(thisney, thisneyTarifa, salida);

                        // fausto
                        fausto.cancelarServicio(thisney, salida);
                        fausto.cancelarServicio(hvo, salida);
                        fausto.suscribirServicio(memeflix, memeflix1, salida);
                        break;
                    case 4:
                        bob.cancelarServicio(memeflix, salida);
                        bob.cancelarServicio(momazon, salida);
                        break;
                    case 5:
                        // fausto
                        fausto.suscribirServicio(thisney, thisneyTarifa, salida);
                        fausto.suscribirServicio(hvo, hvoTarifa, salida);
                    case 6:
                        // diego
                        diego.suscribirServicio(thisney, thisneyTarifa, salida);

                        // erika
                        erika.cancelarServicio(memeflix, salida);
                        erika.cancelarServicio(spootify, salida);

                        // fausto
                        fausto.cancelarServicio(memeflix, salida);
                        fausto.cancelarServicio(thisney, salida);
                        fausto.cancelarServicio(hvo, salida);
                        break;
                    case 7:
                        // cesar
                        cesar.suscribirServicio(spootify, spootifyPremium, salida);

                        // diego
                        diego.suscribirServicio(memeflix, memeflix1, salida);
                        diego.suscribirServicio(spootify, spootifyPremium, salida);
                        diego.cancelarServicio(momazon, salida);
                        break;
                    case 10:
                        // erika
                        erika.suscribirServicio(momazon, momazonPremium, salida);
                        erika.suscribirServicio(hvo, hvoTarifa, salida);
                        erika.suscribirServicio(thisney, thisneyTarifa, salida);
                        break;
                    default:
                        break;
                }

                salida.println("\n--- Cobros del mes " + (mes + 1) + " ---");
                for (Sujeto sujeto : servicios) {
                    sujeto.notificar(salida);
                }
            }
            salida.println("\n----- Fin de la simulación -----");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo de salida: ");
        }

    }
}
