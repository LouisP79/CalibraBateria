package com.servicios.sigma.calibrabateria.Modelo;

/**
 * Created by louis on 16/07/15.
 */
public class Calibrador {

    private final static String CMD = "su -c rm -r /data/system/batterystats.bin";

    public Calibrador() {
        super();
    }

    public boolean Calibrar() {
        try {
            Process p = Runtime.getRuntime().exec(CMD);
            p.waitFor();
            if(p.exitValue()==255){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
