package ultil;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;


import javax.xml.validation.SchemaFactory;


public class Main {
    public static final String xmlFilePath = "plant.xml";

    public static void GenerateXmlFile(String arg) {


        try {

           DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("plantList");
            document.appendChild(root);

            Element plants = document.createElement("plants");
            root.appendChild(plants);
            Element categories = document.createElement("categories");
            root.appendChild(categories);

            Element category = document.createElement("category");
            categories.appendChild(category);

            Element category1 = document.createElement("category");
            categories.appendChild(category1);

            Element category2 = document.createElement("category");
            categories.appendChild(category2);

            Attr attr0 = document.createAttribute("cateId");
            attr0.setValue("AT01");
            category.setAttributeNode(attr0);

            Element cateName = document.createElement("name");
            cateName.appendChild(document.createTextNode("Cay an trai "));
            category.appendChild(cateName);

            Attr attr1 = document.createAttribute("cateId");
            attr1.setValue("CK01");
            category1.setAttributeNode(attr1);

            Element cateName1 = document.createElement("name");
            cateName1.appendChild(document.createTextNode("Cay kieng "));
            category1.appendChild(cateName1);

            Attr attr2 = document.createAttribute("cateId");
            attr2.setValue("RM01");
            category.setAttributeNode(attr2);

            Element cateName2 = document.createElement("name");
            cateName2.appendChild(document.createTextNode("Rau mau "));
            category2.appendChild(cateName2);


            for (int i = 0; i <=1000; i++) {
                // plant element
                Element plant = document.createElement("plant");
                plants.appendChild(plant);

                // set an attribute to plant element
                Attr attr = document.createAttribute("id");
                attr.setValue(String.valueOf(i));
                plant.setAttributeNode(attr);

                //you can also use staff.setAttribute("id", "1") for this

                // firstname element
                Element name = document.createElement("name");
                name.appendChild(document.createTextNode("Mit thai"));
                plant.appendChild(name);

                Element price = document.createElement("price");
                price.appendChild(document.createTextNode("20.5"));
                plant.appendChild(price);

                Element description = document.createElement("description");
                description.appendChild(document.createTextNode("Mit thai thom ngon"));
                plant.appendChild(description);

                Element createDate = document.createElement("createDate");
                createDate.appendChild(document.createTextNode("2022-06-11"));
                plant.appendChild(createDate);

                // lastname element
                Element CateID = document.createElement("cateId");
                CateID.appendChild(document.createTextNode("AT01"));
                plant.appendChild(CateID);

                // create the xml file
                //transform the DOM Object to an XML File
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File(xmlFilePath));

                // If you use
                // StreamResult result = new StreamResult(System.out);
                // the output will be pushed to the standard output ...
                // You can use that for debugging

                transformer.transform(domSource, streamResult);
              
            }
              System.out.println("Done creating XML File");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
/// validation file
//        boolean flag = true;
//        try {
//            validateXMLSchema("plant.xml","plant.xsd");
//        } catch (SAXException e) {
//            e.printStackTrace();
//            flag =false;
//        } catch (IOException e) {
//            e.printStackTrace();
//            flag= false;
//        }
//        System.out.println("xml file is valid"+ flag);
    }



    public static void validateXMLSchema(String xmlFile, String validationFile) throws SAXException, IOException {
        SchemaFactory sc = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        ((sc.newSchema(new File(validationFile))).newValidator()).validate(new StreamSource((new File(xmlFile))));

    }
}
