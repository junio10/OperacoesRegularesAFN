
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
public class UniaoAut {
    public Automato uniao(Automato a1, Automato a2){
        int auxv;
        
        
        List<Estado> state = new ArrayList<>();
        List<Transicao> transicao1 = new ArrayList<>();
        MudarAutomato mudar = new MudarAutomato();
        
        int maior = 0;
        for(int i = 0; i < a1.estados.size(); i++){
            if(a1.estados.get(i).getIdEstado() > maior){
                maior = a1.estados.get(i).getIdEstado();
            }
        }
        //mudando o id dos estados de a2
        a2 = mudar.mudarAutomato(a2, maior+1);
        //pegando os estados e transicoes para formar um automato só
        for(int i = 0; i < a1.estados.size(); i++){
            state.add(a1.getEstados().get(i));
        }
        for(int j = 0;j < a2.estados.size();j++){
            state.add(a2.getEstados().get(j));
        }
        for(int a = 0;a < a1.transicoesAutomato.size();a++){
            transicao1.add(a1.getTransicoesAutomato().get(a));
        }
        for(int i = 0; i < a2.transicoesAutomato.size(); i++){
            transicao1.add(a2.getTransicoesAutomato().get(i));
        }
        
        Automato uniao = new Automato(state, transicao1);
        
        maior = 0;
        for(int i = 0; i < uniao.estados.size(); i++){
            if(uniao.estados.get(i).getIdEstado() > maior){
                maior = uniao.estados.get(i).getIdEstado();
            }
        }
        
        //criando o novo estado inicial
        int x = maior+1;
        Estado e = new Estado();
        e.setIdEstado(x);
        e.setNomeEstado("initial");
        e.setEinicial(true);
        e.setEfinal(false);
        auxv = e.getIdEstado();
        uniao.addEstado(e);
        
        for(int j = 0; j < uniao.estados.size()- 1; j++){
            int aux = 0;
            if(uniao.estados.get(j).Einicial == true){
                uniao.estados.get(j).Einicial = false;
                //pega o id e botar o estado q vou criar para o id desse estado
                //antigo estado inicial
                Transicao t = new Transicao();
                t.setFrom(auxv);
                t.setTo(uniao.estados.get(j).getIdEstado());
                t.setRead("");
                
                uniao.addTransicao(t);
                
            }
            
        }
        
        return uniao;
    }
}
