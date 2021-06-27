
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        Scanner entrada = new Scanner(System.in);
        //Onde o documento está, Passar para a classe ler xml, que vai retornar o automato
        String documento = "C:\\Users\\junio\\automatom1.jff";
        String documento2 ="C:\\Users\\junio\\automatom2.jff";
        int esc = 0;
        
        //aqui criei um novo estado e uma nova transicao para testar
        
        
        //Aqui criei um classe lerxml e instanciei para pegar o automato
        lerXml ler = new lerXml();
        //MudarAutomato mudar = new MudarAutomato();
        //criei dois objetos automato para passar as informacoes
        Automato a2 = ler.lerXml(documento2);
        Automato a1 = ler.lerXml(documento);
        
        
        System.out.println("Escolha qual operacao fazer:");
        System.out.println("1- concantenacao");
        System.out.println("2- Uniao");
        esc = entrada.nextInt();
        
                
        
        if(esc == 1){
        Concatenacao c = new Concatenacao();
        a1 = c.concatenar(a1, a2);
        }else{
        UniaoAut uniao = new UniaoAut();
        a1 = uniao.uniao(a1, a2);
        }
        
        System.out.println(a1.toString());
        
        
       
          EscreverXml arq = new EscreverXml();
          arq.escreverXml(a1);
               
        
    }
   
}
