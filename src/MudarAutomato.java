/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junio
 */
public class MudarAutomato {
    public Automato mudarAutomato(Automato a, int maior){
        
    
        //esta nmudando o id dos estados
        for(int i = 0; i < a.estados.size(); i++){
        a.estados.get(i).setIdEstado(a.estados.get(i).getIdEstado()+maior);
        }
        //colocando o novos id nas transicoes
        for(int j = 0; j < a.transicoesAutomato.size();j++){
        a.transicoesAutomato.get(j).setFrom(a.transicoesAutomato.get(j).getFrom()+maior);
        a.transicoesAutomato.get(j).setTo(a.transicoesAutomato.get(j).getTo()+maior);
        }
        
        
        
      
        
        return a;
    }
    
}
