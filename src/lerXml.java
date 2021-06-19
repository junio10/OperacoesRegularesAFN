
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junio
 */
public class lerXml {
   public Automato lerXml(String file){
        Estado e;
        List<Estado> ListaEstado = new ArrayList<>();
        List<Transicao> ListaTransicao = new ArrayList<>();
       try {
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder builder = factory.newDocumentBuilder();
           
           Document doc = builder.parse(file);
           
            //pega todos os state que tá no arquivo
            NodeList autom = doc.getElementsByTagName("state");
            
            int tam = autom.getLength();
            
            for(int i = 0; i < tam; i++){
               e = new Estado();
               Node state = autom.item(i);
               //tem q verificar se o node é um elemento
               if(state.getNodeType() == Node.ELEMENT_NODE){
                   Element elementState = (Element)state;
                   e.setIdEstado(Integer.parseInt(elementState.getAttribute("id")));
                   e.setNomeEstado(elementState.getAttribute("name"));
                  
                   
                   //esse for pegar o que tem dentro do estado, ou seja, é o filho
                    NodeList stateE = elementState.getChildNodes();//vai pegar o que tem dentro do estado
                    int tamanhoStateE = stateE.getLength();
                    for(int j = 0; j < tamanhoStateE; j++){
                        Node noFilho = stateE.item(j);
                        
                        if(noFilho.getNodeType() == Node.ELEMENT_NODE){
                        Element elementFilho = (Element)noFilho;
                        //switch é feito para verificar se estamos buscando aquele item mesmo
                        switch(elementFilho.getTagName()){
                            case "initial":
                                e.setEinicial(true);
                                break;
                            case "final":
                                e.setEfinal(true);
                                break;
                        }
                        
                        }
                          
                    }
               }
               ListaEstado.add(e);
               
            }
            
            //Parte que esta lendo a transicao
            NodeList transicao = doc.getElementsByTagName("transition");
            int tamNO = transicao.getLength();
            Transicao t;
            
            for(int cont = 0; cont < tamNO; cont++){
                
                t = new Transicao();
                Node transit = transicao.item(cont);
                
                if(transit.getNodeType() == Node.ELEMENT_NODE){
                    Element elementTransit = (Element)transit;
                    NodeList transition = elementTransit.getChildNodes();
                    int tamFilho = transition.getLength();
                    for(int a = 0; a < tamFilho; a++){
                        Node filhoNo = transition.item(a);
                        if(filhoNo.getNodeType() == Node.ELEMENT_NODE){
                            Element elementTransition = (Element)filhoNo;
                            switch(elementTransition.getTagName()){
                                case"from":
                                    t.setFrom(Integer.parseInt(elementTransition.getTextContent()));
                                case"to":
                                    t.setTo(Integer.parseInt(elementTransition.getTextContent()));
                                case"read":
                                    t.setRead(elementTransition.getTextContent());
                                                           
                            }
                            
                        }
                        
                    }
                            
                }
                
                ListaTransicao.add(t);
            }
           
           
           
       } catch (ParserConfigurationException ex) {
           Logger.getLogger(lerXml.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SAXException ex) {
           Logger.getLogger(lerXml.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(lerXml.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       //criar um objeto automato que vai retornar
       Automato a = new Automato(ListaEstado,ListaTransicao);
       
       return a;
       
       
       
       
     
   }
     
}
