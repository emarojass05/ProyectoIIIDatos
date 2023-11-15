package com.carpooling.CarPooling;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import com.carpooling.CarPooling.models.ChoferModel;
import com.carpooling.CarPooling.models.EmpleadoModel;
import com.carpooling.CarPooling.services.ChoferService;
import com.carpooling.CarPooling.services.EmpleadoService;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
/**
 *
 * @author Darga19
 */
public class XML {

//    public static void main(String[] args) {
//        ChoferService choferco = new ChoferService();
//        EmpleadoService empleadoco = new EmpleadoService();
//
//        ChoferModel chofer = new ChoferModel();
//        chofer.setName("Brayan");
//        EmpleadoModel empleado = new EmpleadoModel();
//        empleado.setName("Emanuel");
//
//        choferco.guardarChofer(chofer);
//        empleadoco.guardarEmpleado(empleado);
//    }

    public static void leerXML(String type) {
        try {
            File archivo = new File("usuarios.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            document.getDocumentElement().normalize();

            NodeList listaUsuarios = null;
            if (type.equals("chofer")) {
                listaUsuarios = document.getElementsByTagName("Chofer");
            } else if (type.equals("empleado")) {
                listaUsuarios = document.getElementsByTagName("Empleado");
            }

            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Node nodo = listaUsuarios.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("Tipo de usuario: " + nodo.getNodeName());
                    System.out.println("Nombre: " + element.getElementsByTagName("Nombre").item(0).getTextContent());
                    System.out.println("ID: " + element.getElementsByTagName("ID").item(0).getTextContent());
                    System.out.println("Calificación: " + element.getElementsByTagName("Calificación").item(0).getTextContent());
                    System.out.println("Amigos: " + element.getElementsByTagName("Amigos").item(0).getTextContent());

                    System.out.println("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void crearXMLchofer(String nomArchivo, ChoferModel chofer) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Verificar si el archivo XML ya existe
            File archivoXML = new File(nomArchivo + ".xml");
            Document document;
            Element raiz;

            if (archivoXML.exists()) {
                // Si el archivo ya existe, cargar el documento existente
                document = builder.parse(archivoXML);
                raiz = document.getDocumentElement();
            } else {
                // Si el archivo no existe, crear un nuevo documento
                DOMImplementation implementation = builder.getDOMImplementation();
                document = implementation.createDocument(null, nomArchivo, null);
                document.setXmlVersion("1.0");

                // Crear el nodo raíz
                raiz = document.getDocumentElement();
            }

            // Crear el nodo Chofer
            Element itemNode = document.createElement("Chofer");

            // Crear nodos para las propiedades del chofer
            Element nombreNode = document.createElement("Nombre");
            Text nodeNombreValue = document.createTextNode(chofer.getName());
            nombreNode.appendChild(nodeNombreValue);

            Element idNode = document.createElement("ID");
            Text nodeIdValue = document.createTextNode("" + chofer.getID());
            idNode.appendChild(nodeIdValue);

            Element califNode = document.createElement("Calificación");
            Text nodeCalifValue = document.createTextNode("" + chofer.getCalificacion());
            califNode.appendChild(nodeCalifValue);

            Element amigosNode = document.createElement("Amigos");
            Text nodeAmigosValue = document.createTextNode(String.valueOf(chofer.getAmigos()));
            amigosNode.appendChild(nodeAmigosValue);

            // Agregar nodos al nodo Chofer
            itemNode.appendChild(nombreNode);
            itemNode.appendChild(idNode);
            itemNode.appendChild(califNode);
            itemNode.appendChild(amigosNode);

            // Agregar el nodo Chofer al nodo raíz
            raiz.appendChild(itemNode);

            // Generar el XML
            Source source = new DOMSource(document);

            // Configurar el transformer para el formato con sangría
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "no");

            // Especificar la ubicación del archivo XML
            Result result = new StreamResult(archivoXML);

            // Guardar el documento en el archivo XML
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerConfigurationException | SAXException e) {
            e.printStackTrace(); // Maneja las excepciones según tu necesidad
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
    public static void crearXMLempleado(String nomArchivo, EmpleadoModel empleado) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Verificar si el archivo XML ya existe
            File archivoXML = new File(nomArchivo + ".xml");
            Document document;
            Element raiz;

            if (archivoXML.exists()) {
                // Si el archivo ya existe, cargar el documento existente
                document = builder.parse(archivoXML);
                raiz = document.getDocumentElement();
            } else {
                // Si el archivo no existe, crear un nuevo documento
                DOMImplementation implementation = builder.getDOMImplementation();
                document = implementation.createDocument(null, nomArchivo, null);
                document.setXmlVersion("1.0");

                // Crear el nodo raíz
                raiz = document.getDocumentElement();
            }

            // Crear el nodo Chofer
            Element itemNode = document.createElement("Empleado");

            // Crear nodos para las propiedades del chofer
            Element nombreNode = document.createElement("Nombre");
            Text nodeNombreValue = document.createTextNode(empleado.getName());
            nombreNode.appendChild(nodeNombreValue);

            Element idNode = document.createElement("ID");
            Text nodeIdValue = document.createTextNode("" + empleado.getID());
            idNode.appendChild(nodeIdValue);

            Element califNode = document.createElement("Calificación");
            Text nodeCalifValue = document.createTextNode("" + empleado.getCalificacion());
            califNode.appendChild(nodeCalifValue);

            Element amigosNode = document.createElement("Amigos");
            Text nodeAmigosValue = document.createTextNode(String.valueOf(empleado.getAmigos()));
            amigosNode.appendChild(nodeAmigosValue);

            // Agregar nodos al nodo Chofer
            itemNode.appendChild(nombreNode);
            itemNode.appendChild(idNode);
            itemNode.appendChild(califNode);
            itemNode.appendChild(amigosNode);

            // Agregar el nodo Chofer al nodo raíz
            raiz.appendChild(itemNode);

            // Generar el XML
            Source source = new DOMSource(document);

            // Configurar el transformer para el formato con sangría
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "no");

            // Especificar la ubicación del archivo XML
            Result result = new StreamResult(archivoXML);

            // Guardar el documento en el archivo XML
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerConfigurationException | SAXException e) {
            e.printStackTrace(); // Maneja las excepciones según tu necesidad
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}