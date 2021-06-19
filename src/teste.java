
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
public class teste {
    
    public static void main(String[] args) {
        //Onde o documento está, Passar para a classe ler xml, que vai retornar o automato
        String documento = "C:\\Users\\junio\\automatom1.jff";
        String documento2 ="C:\\Users\\junio\\automatom2.jff";
       
        
        //aqui criei um novo estado e uma nova transicao para testar
        
        
        //Aqui criei um classe lerxml e instanciei para pegar o automato
        lerXml ler = new lerXml();
        //MudarAutomato mudar = new MudarAutomato();
        //criei dois objetos automato para passar as informacoes
        Automato a2 = ler.lerXml(documento2);
        Automato a1 = ler.lerXml(documento);
      
        List<Estado> state = new ArrayList<>();
        List<Transicao> transicao1 = new ArrayList<>();
        
        int maior = 0;
        for(int i = 0; i < a1.estados.size(); i++){
            if(a1.estados.get(i).getIdEstado() > maior){
                maior = a1.estados.get(i).getIdEstado();
            }
        }
        
        
        Concatenacao c = new Concatenacao();
        a1 = c.concatenar(a1, a2);
        
        System.out.println(a1.toString());
        //aqui estou mudando o id do estado do automato 2
        //a2 = mudar.mudarAutomato(a2, (maior+1));
        
        //aqui esta pegando os estados e transicoes do automatos a1 e a2 e colocando dentro da lista
        //state e transicao1
        /*
        for(int i = 0; i < a1.estados.size(); i++){
            state.add(a1.getEstados().get(i));
        }
        for(int j = 0;j < a2.estados.size();j++){
            state.add(a2.getEstados().get(j));
        }
        for(int a = 0;a < a1.trae4nsicoesAutomato.size();a++){
            transicao1.add(a1.getTransicoesAutomato().get(a));
        }
        for(int i = 0; i < a2.transicoesAutomato.size(); i++){
            transicao1.add(a2.getTransicoesAutomato().get(i));
        }
        
        
        //aqui to criando um novo automato com os estados e transicoes q foram lidos
        //no arquivo
        Automato a3 = new Automato(state,transicao1);
        */
        
        
        //UniaoAut uniao = new UniaoAut();
       // Automato a4 = uniao.uniao(a3); 
        //System.out.println(a4.toString());
        
        
       
          EscreverXml arq = new EscreverXml();
          arq.escreverXml(a1);
               
        
    }
   
}
