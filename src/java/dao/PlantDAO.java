/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.io.IOException;
import java.io.StringWriter;
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
    
}
