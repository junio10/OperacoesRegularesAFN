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
    public Automato uniao(Automato c){
        int auxv;
 
        int maior = 0;
        for(int i = 0; i < c.estados.size(); i++){
            if(c.estados.get(i).getIdEstado() > maior){
                maior = c.estados.get(i).getIdEstado();
            }
        }
        
        
        int x = maior+1;
        Estado e = new Estado();
        e.setIdEstado(x);
        e.setNomeEstado("initial");
        e.setEinicial(true);
        e.setEfinal(false);
        auxv = e.getIdEstado();
        c.addEstado(e);
        
        for(int j = 0; j < c.estados.size()- 1; j++){
            int aux = 0;
            if(c.estados.get(j).Einicial == true){
                c.estados.get(j).Einicial = false;
                //pega o id e botar o estado q vou criar para o id desse estado
                //antigo estado inicial
                Transicao t = new Transicao();
                t.setFrom(auxv);
                t.setTo(c.estados.get(j).getIdEstado());
                t.setRead("");
                
                c.addTransicao(t);
                
            }
            
        }
        
        return c;
    }
}
