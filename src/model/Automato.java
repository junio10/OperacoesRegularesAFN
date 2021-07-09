package model;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junio
 */
public class Automato {
    //criar uma lista estado para adicionar os estados
    public List<Estado> estados = new ArrayList<>();
    public List<Transicao> transicoesAutomato = new ArrayList<>();

    public Automato(List<Estado> estados, List<Transicao> transicoesAutomato) {
        this.estados = estados;
        this.transicoesAutomato = transicoesAutomato;
    }
    
    public Automato(){
        
    }
   

    
    public void addEstado(Estado e){
        
        this.estados.add(e);
    }
    public void addTransicao(Transicao t){
        this.transicoesAutomato.add(t);
    }
    
    
    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Transicao> getTransicoesAutomato() {
        return transicoesAutomato;
    }

    public void setTransicoesAutomato(List<Transicao> transicoesAutomato) {
        this.transicoesAutomato = transicoesAutomato;
    }

    @Override
    public String toString() {
        return "Automato{" + "estados=" + estados + ", transicoesAutomato=" + transicoesAutomato + '}';
    }
    
    
}
