/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Comilon;
import modelos.Pasteleria;
import modelos.Pastelero;
import modelos.Tarta;

/**
 *
 * @author Castelao
 */
public class Principal {

    public static void main(String[] args) {
        Pasteleria p = new Pasteleria();
        ArrayList<Thread> pas = new ArrayList<>();        
       

        for (int i=0; i < Pasteleria.PASTELEROS_MAX; i++) {
           pas.add(new Pastelero(i, p.getProducidasTotal(), p.getCinta(),p.getTartas()));
        }
        for(int i=0;i<Pasteleria.COMILONES_MAX;i++){
            pas.add(new Comilon(i, p.getComidasTotal(), p.getCinta()));
        }
        for(Thread t:pas){
            t.start();
        }
        for(Thread t:pas){
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int i = 0;
        for(Tarta t:p.getTartas()){
            System.out.println(i++ +" "+t.getTartaID()+" "+t.getPeso());
        }
    }

}
