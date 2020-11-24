package controller;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathManager {

  private String filename;
  private File file;
  private XPath xpath;

  public XpathManager(String filename) {
    super();
    this.filename = filename;
    this.file = new File(XpathManager.class.getResource(filename).getPath());
    this.xpath = XPathFactory.newInstance().newXPath();
  }

  public String getFilename() {
    return filename;
  }
				
  public void setFilename(String filename) {
    this.filename = filename;
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  /**
   * Search in document with expresion xpath and return nodes with result
   * 
   * @param xPathExpression :String
   * @return nodes :NodeList
   */
  public NodeList search(String xPathExpression) {
    NodeList nodes = null;
    try {
      nodes =
          (NodeList) xpath.evaluate(xPathExpression, this.getDocument(), XPathConstants.NODESET);
    } catch (XPathExpressionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return nodes;
  }

  /**
   * load document xml
   * 
   * @return
   */
  public Document getDocument() {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;
    Document document = null;
    try {
      builder = factory.newDocumentBuilder();
      document = builder.parse(this.file);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return document;
  }


}