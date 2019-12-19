/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pastelero extends Thread {

    private int idPastelero;
    private int producidas;
    private static Integer producidasTotal;
    Queue<Tarta> cinta;
    List<Tarta> tartas;

    public Pastelero(int idPastelero, Integer producidasTotal, Queue<Tarta> cinta, List<Tarta> tartas) {
        this.idPastelero = idPastelero;
        this.producidasTotal = 0;
        producidas = 0;
        this.cinta = cinta;
        this.tartas = tartas;
    }

    public void run() {
        int p = 0;
        while (producidasTotal < Pasteleria.PROD_MAX) {
            boolean trabajar = false;
            synchronized (producidasTotal) {
                p = producidasTotal;
                producidasTotal++;
                trabajar = true;
                producidas++;

            }
            if (trabajar) {
                Random r = new Random();
                int peso = r.nextInt(Pasteleria.PESO_MAX - Pasteleria.PESO_MIN + 1) + Pasteleria.PESO_MIN;
                Tarta t = new Tarta(p, peso);
                System.out.println("El pastelero " + this.getName() + " ha empezado la tarta " + t.getTartaID());
                try {
                    sleep(peso);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Pastelero.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                cinta.offer(t);
                tartas.add(t);

                System.out.println("El pastelero " + this.getName() + " ha terminado la tarta " + t.getTartaID());
            }else{
                try {
                    sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pastelero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
