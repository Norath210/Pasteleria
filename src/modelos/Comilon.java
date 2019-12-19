/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import static java.lang.Thread.sleep;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Castelao
 */
public class Comilon extends Thread {

    int idComilon;

    int comidas;
    static Integer comidasTotal;
    Queue<Tarta> cinta;

    public Comilon(int idComilon, Integer comidasTotal, Queue<Tarta> cinta) {
        this.idComilon = idComilon;
        this.comidasTotal = comidasTotal;
        this.cinta = cinta;
    }

    public void run() {
        while (comidasTotal < Pasteleria.PROD_MAX) {
            int p;
            boolean comer = false;
            Tarta t = null;
            synchronized (comidasTotal) {
                p = comidasTotal;
                if (cinta.peek() != null) {
                    comer = true;
                    comidasTotal++;
                    comidas++;
                    t = cinta.poll();
                }
            }
            if (comer) {
                System.out.println("El comilon " + this.getIdComilon() + " ha empezado la tarta " + t.getTartaID());
                try {
                    sleep(t.peso);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pastelero.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("El comilon " + this.getIdComilon() + " ha acabado la tarta " + t.getTartaID());
            }else{
                try {
                    sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Comilon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public int getIdComilon() {
        return idComilon;
    }
}
