package com.carpooling.CarPooling;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
//
//        EmpleadoModel empleado = new EmpleadoModel();
//        empleado.setName("Emanuel");
//        EmpleadoModel empleado2 = new EmpleadoModel();
//        empleado2.setName("Darío");
//
//        ArrayList<String> lista_amigos = new ArrayList<>();
//
//        lista_amigos.add(empleado.getName());
//        lista_amigos.add(empleado2.getName());
//        chofer.setAmigos(lista_amigos);
//
//        choferco.guardarChofer(chofer);
//        empleadoco.guardarEmpleado(empleado);
//        empleadoco.guardarEmpleado(empleado2);
//
//        XML.addAmigoChofer("usuarios", "Brayan", "Felipe");
//        XML.addAmigoEmpleado("usuarios", "Darío", "Felipe");
//        XML.addAmigoEmpleado("usuarios", "Emanuel", "Felipe");
//    }

    public static boolean ingresar(String nombre, String contraseña) {
        try {
            File archivo = new File("usuarios.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();

            NodeList listaUsuarios = null;
            listaUsuarios = document.getElementsByTagName("Chofer");
            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Node nodo = listaUsuarios.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    if(nombre.equals(element.getElementsByTagName("Nombre").item(0).getTextContent())
                            && contraseña.equals(element.getElementsByTagName("Contraseña").item(0).getTextContent())){
                        return true;
                    }
                }
            }
            listaUsuarios = document.getElementsByTagName("Empleado");
            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Node nodo = listaUsuarios.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    if(nombre.equals(element.getElementsByTagName("Nombre").item(0).getTextContent())
                            && contraseña.equals(element.getElementsByTagName("Contraseña").item(0).getTextContent())){
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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

            Element contraseñaNode = document.createElement("Contraseña");
            Text nodeContraseñaValue = document.createTextNode(String.valueOf(chofer.getContraseña()));
            contraseñaNode.appendChild(nodeContraseñaValue);

            // Agregar nodos al nodo Chofer
            itemNode.appendChild(nombreNode);
            itemNode.appendChild(idNode);
            itemNode.appendChild(califNode);
            itemNode.appendChild(amigosNode);
            itemNode.appendChild(contraseñaNode);

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

            Element contraseñaNode = document.createElement("Contraseña");
            Text nodeContraseñaValue = document.createTextNode(String.valueOf(empleado.getContraseña()));
            contraseñaNode.appendChild(nodeContraseñaValue);

            // Agregar nodos al nodo Chofer
            itemNode.appendChild(nombreNode);
            itemNode.appendChild(idNode);
            itemNode.appendChild(califNode);
            itemNode.appendChild(amigosNode);
            itemNode.appendChild(contraseñaNode);

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

    public static void addAmigoChofer(String nomArchivo, String nameChofer, String newAmigo) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Verificar si el archivo XML ya existe
            File archivoXML = new File(nomArchivo + ".xml");
            Document document = null;
            Element raiz = null;

            if (archivoXML.exists()) {
                // Si el archivo ya existe, cargar el documento existente
                document = builder.parse(archivoXML);
                raiz = document.getDocumentElement();

                // Buscar el nodo Chofer con el nombre especificado
                NodeList choferes = raiz.getElementsByTagName("Chofer");
                for (int i = 0; i < choferes.getLength(); i++) {
                    Element chofer = (Element) choferes.item(i);
                    Element nombreNode = (Element) chofer.getElementsByTagName("Nombre").item(0);
                    String nombre = nombreNode.getTextContent();

                    if (nombre.equals(nameChofer)) {
                        // Encontrar el nodo Chofer deseado y agregar el nuevo amigo
                        Element amigosNode = (Element) chofer.getElementsByTagName("Amigos").item(0);

                        // Obtener la cadena actual de amigos y convertirla a una lista
                        String amigos = amigosNode.getTextContent();
                        ArrayList<String> listaAmigos = new ArrayList<>(Arrays.asList(amigos.substring(1, amigos.length() - 1).split(",\\s*")));

                        // Verificar si el nuevo amigo ya está presente en la lista
                        if (!listaAmigos.contains(newAmigo)) {
                            // Agregar el nuevo amigo solo si no está presente
                            listaAmigos.add(newAmigo);

                            // Actualizar el contenido del nodo "Amigos" con la nueva lista
                            amigosNode.setTextContent(listaAmigos.toString());

                            // Actualizar el XML
                            Source source = new DOMSource(document);
                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                            Transformer transformer = transformerFactory.newTransformer();
                            transformer.setOutputProperty(OutputKeys.INDENT, "no");
                            Result result = new StreamResult(archivoXML);
                            transformer.transform(source, result);
                        } else {
                            System.out.println("El nuevo amigo ya está en la lista.");
                        }

                        break; // Salir del bucle una vez que se haya actualizado el chofer
                    }
                }
            } else {
                // Si el archivo no existe, puedes manejar este caso según tus necesidades
                System.out.println("El archivo no existe");
            }

        } catch (ParserConfigurationException | TransformerConfigurationException | SAXException e) {
            e.printStackTrace(); // Maneja las excepciones según tu necesidad
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void addAmigoEmpleado(String nomArchivo, String nameEmpleado, String newAmigo) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Verificar si el archivo XML ya existe
            File archivoXML = new File(nomArchivo + ".xml");
            Document document = null;
            Element raiz = null;

            if (archivoXML.exists()) {
                // Si el archivo ya existe, cargar el documento existente
                document = builder.parse(archivoXML);
                raiz = document.getDocumentElement();

                // Buscar el nodo Chofer con el nombre especificado
                NodeList empleados = raiz.getElementsByTagName("Empleado");
                for (int i = 0; i < empleados.getLength(); i++) {
                    Element empleado = (Element) empleados.item(i);
                    Element nombreNode = (Element) empleado.getElementsByTagName("Nombre").item(0);
                    String nombre = nombreNode.getTextContent();

                    if (nombre.equals(nameEmpleado)) {
                        // Encontrar el nodo Chofer deseado y agregar el nuevo amigo
                        Element amigosNode = (Element) empleado.getElementsByTagName("Amigos").item(0);

                        // Obtener la cadena actual de amigos y convertirla a una lista
                        String amigos = amigosNode.getTextContent();
                        ArrayList<String> listaAmigos = new ArrayList<>(Arrays.asList(amigos.substring(1, amigos.length() - 1).split(",\\s*")));

                        // Verificar si el nuevo amigo ya está presente en la lista
                        if (!listaAmigos.contains(newAmigo)) {
                            // Agregar el nuevo amigo solo si no está presente
                            listaAmigos.add(newAmigo);

                            // Actualizar el contenido del nodo "Amigos" con la nueva lista
                            amigosNode.setTextContent(listaAmigos.toString());

                            // Actualizar el XML
                            Source source = new DOMSource(document);
                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                            Transformer transformer = transformerFactory.newTransformer();
                            transformer.setOutputProperty(OutputKeys.INDENT, "no");
                            Result result = new StreamResult(archivoXML);
                            transformer.transform(source, result);
                        } else {
                            System.out.println("El nuevo amigo ya está en la lista.");
                        }

                        break; // Salir del bucle una vez que se haya actualizado el chofer
                    }
                }
            } else {
                // Si el archivo no existe, puedes manejar este caso según tus necesidades
                System.out.println("El archivo no existe");
            }

        } catch (ParserConfigurationException | TransformerConfigurationException | SAXException e) {
            e.printStackTrace(); // Maneja las excepciones según tu necesidad
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}