package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junio
 */
public class Transicao {
    public int from;
    public int to;
    public String read;
    
  

    @Override
    public String toString() {
        return "Transicao{" + "from=" + from + ", to=" + to + ", read=" + read + '}';
    }
    
    
    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
    
       
}
