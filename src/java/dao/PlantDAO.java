/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.plantDTO;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author pc
 */
public class PlantDAO {
    public  static  Document getDocument(String path_to_file){
     Document d = null;
     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     try {
         DocumentBuilder db = dbf.newDocumentBuilder();
         d= db.parse(path_to_file);
     } catch (ParserConfigurationException | SAXException | IOException e) {
         d= null;
     }return  d;
 }
  public  static  String getXMLContent(Document d ){
     String result = "";
      try {
          TransformerFactory tran = TransformerFactory.newInstance();
          Transformer tf = null;
          tf = tran.newTransformer();
          tf.setOutputProperty(OutputKeys.INDENT,"yes");
          StringWriter sw = new StringWriter();
          StreamResult sr = new StreamResult();
          DOMSource dsr  = new DOMSource();
          tf.transform(dsr,sr);
          result = sw.toString();

      } catch (TransformerConfigurationException e) {
          e.printStackTrace();
      } catch (TransformerException e) {
          e.printStackTrace();
      }


      return result;
 }
   public static void saveXMLContent(Document d , String path_to_file) throws TransformerException {
      TransformerFactory tff = TransformerFactory.newInstance();
      Transformer tf = tff.newTransformer();
      tf.setOutputProperty(OutputKeys.INDENT,"yes");
      DOMSource dsr = new DOMSource(d);
      StreamResult rs = new StreamResult(path_to_file);
      tf.transform(dsr,rs);
   }
   
    public List<plantDTO> getAllPlant(String fileName, String category, String filter)
            throws ParserConfigurationException,
            SAXException,
            IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File(fileName));

        doc.getDocumentElement().normalize();

   
        NodeList list = doc.getElementsByTagName("plant");

        List<plantDTO> plant = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String idCategory = element.getAttribute("cateId");
                if (category == null) {
                    String name = element.getElementsByTagName("name").item(0).getTextContent();

                    int id =Integer.parseInt(element.getAttribute("id"));
                    Float price = Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent());
                    String dateCreate = element.getElementsByTagName("createDate").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent();
                    plant.add(new plantDTO(id,name,price,idCategory,dateCreate));

                } else if (idCategory.equals(category)) {
                    String name = element.getElementsByTagName("name").item(0).getTextContent();

                    if (name.indexOf(filter) > 0) {
                        int id =Integer.parseInt(element.getAttribute("id"));
                        Float price = Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent());
                        String dateCreate = element.getElementsByTagName("createDate").item(0).getTextContent();
                        String description = element.getElementsByTagName("description").item(0).getTextContent();
                         plant.add(new plantDTO(id,name,price,idCategory,dateCreate));
                    }
                    if (filter == "") {
                         int id =Integer.parseInt(element.getAttribute("id"));
                        Float price = Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent());
                        String dateCreate = element.getElementsByTagName("createDate").item(0).getTextContent();
                        String description = element.getElementsByTagName("description").item(0).getTextContent();
                        plant.add(new plantDTO(id,name,price,idCategory,dateCreate));
                    }
                }
            }
        }
        return plant;
    }
    
}
