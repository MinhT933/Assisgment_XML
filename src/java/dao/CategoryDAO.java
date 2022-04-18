/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CategoryDTO;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class CategoryDAO {
    public static final String xmlFilePath = "plant.xml";
    public static Document getDocument(String path_to_file){
        Document doc = null;
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            doc = db.parse(path_to_file);
            File inputFile = new File(path_to_file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            doc = null;
        }return  doc;
    }

    public static List<CategoryDTO> getCategories() {
        List<CategoryDTO> listCate = new ArrayList<>();
        CategoryDTO cate = null;

        try {
//            D:\\CN7_Block3w\\Assisgment_XML\\web\\xml\\plant.xml
            File inputFile = new File("D:\\CN7_Block3w\\Assisgment_XML\\web\\xml\\plant.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
//            Document doc = CategoryDAO.getDocument(xmlFilePath);

            System.out.println("Check PT gốc: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("category");

            for (int i = 0; i < nodeList.getLength(); i++) {
                cate = new CategoryDTO();

                Node nNode = nodeList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nNode;
                    cate.setID(element.getAttribute("cateId"));
                    cate.setName(element.getElementsByTagName("name").item(0).getTextContent());
                }
                listCate.add(cate);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return listCate;
    }


    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        List<CategoryDTO> list = dao.getCategories();
        for (CategoryDTO cate :
                list) {
            System.out.println(cate.toString());
        }
    }
}
