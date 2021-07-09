package model;


import model.Estado;
import model.MudarAutomato;
import model.Transicao;
import model.Automato;
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
public class Concatenacao {
    public Automato concatenar(Automato m1, Automato m2){
        
        MudarAutomato mnovo = new MudarAutomato();
        Transicao tnovo;
        List<Transicao> listaTransicao = new ArrayList<>();
        List<Estado> listaEstado = new ArrayList<>();
        
        //variavel onde guarda a posicao do estado inicial m2
        int inicialM2 = 0;
        
        int maior = 0;
        for(int i = 0; i < m1.estados.size(); i++){
            if(m1.estados.get(i).getIdEstado() > maior){
                maior = m1.estados.get(i).getIdEstado();
            }
        }
        
        //pegando o estado inicial de m2
        m2 = mnovo.mudarAutomato(m2, (maior+1));
        for(int i = 0; i < m2.estados.size(); i++){
            if(m2.estados.get(i).Einicial == true){
              m2.estados.get(i).Einicial = false;
              inicialM2 = m2.estados.get(i).getIdEstado();
            }
        }
        
       
        //transformando os estados finais da maquina 1 em estados comum
        boolean teste = true;
        for(int i = 0; i  < m1.estados.size(); i++){
            if(m1.estados.get(i).Efinal == true){
            tnovo = new Transicao();
            m1.estados.get(i).Efinal = false;
            tnovo.setFrom(m1.estados.get(i).getIdEstado());
            tnovo.setRead("");
            tnovo.setTo(inicialM2);
            listaTransicao.add(tnovo);
        }
       
        }
        //agora e so pegar os estados e transicoes e criar um novo automato e retornar
        for(int j = 0; j < m1.estados.size(); j++){
            listaEstado.add(m1.getEstados().get(j));
        } 
        for(int j = 0; j < m2.estados.size(); j++){
            listaEstado.add(m2.getEstados().get(j));
        }
        for(int i = 0; i < m1.transicoesAutomato.size(); i++){
            listaTransicao.add(m1.getTransicoesAutomato().get(i));
        }
        for(int i = 0; i < m2.transicoesAutomato.size(); i++){
            listaTransicao.add(m2.getTransicoesAutomato().get(i));
        }
        
        Automato novoAUT = new Automato(listaEstado, listaTransicao);
        
        
        return novoAUT;
    }
   
    
}
