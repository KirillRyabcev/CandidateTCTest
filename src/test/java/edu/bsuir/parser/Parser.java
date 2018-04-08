package edu.bsuir.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Acer on 05.04.2018.
 */
public class Parser {
    public ArrayList<String> getData(String role) throws Exception{
        ArrayList<String> al = new ArrayList<String>();
        File inputFile = new File("data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("root");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println();
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                if(eElement.getElementsByTagName("role").item(0).getTextContent().equals(role)){
                    String s1 = eElement.getElementsByTagName("login").item(0).getTextContent();
                    String s2 = eElement.getElementsByTagName("password").item(0).getTextContent();
                    al.add(s1);
                    al.add(s2);
                }

            }

        }
        return al;
    }
}
