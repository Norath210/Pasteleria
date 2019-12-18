/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Castelao
 */
public class Pasteleria {

    public static final int PROD_MAX = 20;
    public static final int PASTELEROS_MAX = 3;
    public static final int COMILONES_MAX = 2;
    public static final int PESO_MIN = 500;
    public static final int PESO_MAX = 1000;
    Queue<Tarta> cinta;
    List<Tarta> tartas;

    public Pasteleria() {
        cinta = new LinkedList<>();
        tartas = new ArrayList();
    }

    public Queue<Tarta> getCinta() {
        return cinta;
    }

    public List<Tarta> getTartas() {
        return tartas;
    }
    
    
    
}
