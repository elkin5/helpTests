package main;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import controller.XpathManager;
import model.Definition;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// La expresion xpath de busqueda
		// String xPathExpression = "//satelite[@nombre='Luna']";
//		String xPathExpression = "/html/body/div[@id='page']/div[@id='content']/div[@id='more']/pre";
//		Node nodeRoot = xpathmgr.search(xPathExpression).item(0);

		// Preparación de xpath
		// XpathManager xpathmgr = new XpathManager("/static/testXml.xml");
		XpathManager xpathmgr = new XpathManager("/static/pkimpactmgr.html");

		Document doc = xpathmgr.getDocument();
		doc.getDocumentElement().normalize();
		Node nodeRoot = doc.getElementsByTagName("pre").item(0);

		NodeList nodesTagPre = nodeRoot.getChildNodes();

		List<Definition> definitionsList = new ArrayList<Definition>();
		Definition def = new Definition();

		for (int i = 0; i < nodesTagPre.getLength(); i++) {
			
			if (nodesTagPre.item(i).getNodeName().equals("a")) {
				NodeList nodesTagA = nodesTagPre.item(i).getChildNodes();
				
				def.setLineNumber(Integer.parseInt(nodesTagA.item(1).getTextContent()));

				def.setName(nodesTagA.item(3).getTextContent());
				
				def.setXpath(((Element)nodesTagPre.item(i)).getAttribute("href"));			
			}
			
			if (nodesTagPre.item(i).getNodeName().equals("i")) {
				
				def.setType(nodesTagPre.item(i).getTextContent());
				
				definitionsList.add(def);
				def = new Definition();
			}
			
		}

		for (int j = 0; j < definitionsList.size(); j++) {
			System.out.println(definitionsList.get(j).toString());
		}
	}

}
