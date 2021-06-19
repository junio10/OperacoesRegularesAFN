
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junio
 */
public class EscreverXml {
    public void escreverXml(Automato a){
        int eixox = 309, eixoy = 221;
        String auxEixox, auxEixoy; 
        
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            
            Document documentXML = documentBuilder.newDocument();
            
            Element structure = documentXML.createElement("structure");
            documentXML.appendChild(structure);
            
            Element type = documentXML.createElement("type");
            type.appendChild(documentXML.createTextNode("fa"));
            
            structure.appendChild(type);
            Element automaton = documentXML.createElement("automaton");
            structure.appendChild(automaton);
            String idEstado = "";
            
            for(int i = 0; i < a.estados.size(); i++){
                String aux = "";
                Element state = documentXML.createElement("state");
                
                Attr id = documentXML.createAttribute("id");
                Attr name = documentXML.createAttribute("nome");
                idEstado = Integer.toString(a.estados.get(i).getIdEstado());
                id.setValue(idEstado);
                name.setValue(a.estados.get(i).getNomeEstado());
                
                state.setAttributeNode(id);
                state.setAttributeNode(name);
                
                eixox = eixox + 10;
                auxEixox = String.valueOf(eixox);
                
                
                Element eixoX = documentXML.createElement("x");
                eixoX.appendChild(documentXML.createTextNode(auxEixox));
                state.appendChild(eixoX);
                
                eixoy = eixoy + 10;
                auxEixoy = String.valueOf(eixoy);
                      
                Element eixoY = documentXML.createElement("y");
                eixoY.appendChild(documentXML.createTextNode(auxEixoy));
                state.appendChild(eixoY);
                
                Element label = documentXML.createElement("label");
                // pedaco do antigo codigo:
                //String auxb = a.estados.get(i).getNomeEstado().replaceAll("q", "");
                String strx = String.valueOf(i);
                String auxb = strx;
                label.appendChild(documentXML.createTextNode(auxb));
                state.appendChild(label);
                
                if(a.estados.get(i).isEinicial()){
                    Element inicial = documentXML.createElement("initial");
                    state.appendChild(inicial);
                }
                if(a.estados.get(i).isEfinal()){
                    Element finalEstado = documentXML.createElement("final");
                    state.appendChild(finalEstado);
                }
                automaton.appendChild(state);
                
                }
            for(int j = 0; j < a.transicoesAutomato.size();j++){
                   Element transition = documentXML.createElement("transition");
                   
                   Element from = documentXML.createElement("from");
                   from.appendChild(documentXML.createTextNode(Integer.toString(a.transicoesAutomato.get(j).getFrom())));
                   transition.appendChild(from);
                   
                   Element to = documentXML.createElement("to");
                   to.appendChild(documentXML.createTextNode(Integer.toString(a.transicoesAutomato.get(j).getTo())));
                   transition.appendChild(to);
                   
                   Element read = documentXML.createElement("read");
                   read.appendChild(documentXML.createTextNode(a.transicoesAutomato.get(j).getRead()));
                   transition.appendChild(read);
                   
                   automaton.appendChild(transition);
                        
            }
                
                      
                
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            DOMSource documentoFonte = new DOMSource(documentXML);
            
            StreamResult documentoFinal = new StreamResult(new File("C:\\Users\\junio\\automatoNovo.xml"));
            transformer.transform(documentoFonte, documentoFinal);
            
         
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(EscreverXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(EscreverXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(EscreverXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
