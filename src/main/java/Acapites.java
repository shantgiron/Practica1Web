import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Acapites {
    //Instancia documento para extraer el archivo html
    private Document document = null;
    //esta variable contiene el archivo digitado
    private String url = "";

    public Acapites() {
        URLinput();
        System.out.println("=====================================");
        puntoA();
        System.out.println("=====================================");
        puntoB();
        System.out.println("=====================================");
        puntoC();
        System.out.println("=====================================");
        puntoD();
        System.out.println("=====================================");
        puntoE();
        System.out.println("=====================================");
        puntoF();
        System.out.println("=====================================");
    }

    public void URLinput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca URL valida");
        this.url = scanner.nextLine(); //variable para guardar info de URL
        // this.url = "https://www.pucmm.edu.do";
        try {
            this.document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //a) Indicar la cantidad de lineas del recurso retornado.
    private void puntoA() {
        System.out.println("Cantidad de lineas: " + document.html().split("\n").length);
    }

    //b) Indicar la cantidad de párrafos (p) que contiene el documento HTML.
    private void puntoB() {
        System.out.println("Total de parrafos: " + document.getElementsByTag("p").size());
    }

    // c) Indicar la cantidad de imágenes (img) dentro de los párrafos que contiene el archivo HTML.
    private void puntoC() {
        int count = 0;

        for (Element element : document.getElementsByTag("p")) {
            for (Element element2 : element.getElementsByTag("img")) {
                count++;
            }
        }

        System.out.println("Total de imagenes dentro de los parrafos: " + count);
    }

    //d) indicar la cantidad de formularios (form) que contiene el HTML por categorizando por el método implementado POST o GET.
    private void puntoD() {
        int cantPost = 0;
        int cantGet = 0;

        for (Element element : document.getElementsByTag("form")) {
            for (Element element2 : element.getElementsByAttributeValue("method", "get")) {
                cantGet++;
            }
        }

            for (Element element1 : document.getElementsByTag("form")) {
                for (Element element3 : element1.getElementsByAttributeValue("method", "post")) {
                    cantPost++;

                }
            }

            System.out.println("Total de formularios 'POST': " + cantPost);
            System.out.println("Total de formularios 'GET': " + cantGet);
        }

        //e) Para cada formulario mostrar los campos del tipo input y su
        //respectivo tipo que contiene en el documento HTML.

        private void puntoE() {
            for (Element element : document.getElementsByTag("form")) {
                System.out.println(element);
            }
        }


        //Para cada formulario parseado, identificar que el metodo de envío
        //del formulario sea por utilizando el método POST y enviar una
        //petición al servidor, con el parámetro llamado asignatura y valor
        //practica1 y mostrar la respuesta por la salida estandar.
        private void puntoF() {
            Connection.Response response = null;
            Document doc = null;
            Map<String, String> parametros = new HashMap<>();

            try {
                for (Element element : document.getElementsByTag("form")) {
                    String absURL = element.absUrl("action");

                    if (element.attr("method").equals("post")) {
                        parametros.put("asignatura", "practica1");

                        doc = Jsoup.connect(absURL)
                                .header("matricula", "20130940")
                                .method(Connection.Method.POST)
                                .data(parametros)
                                .post();

                        System.out.println(doc.outerHtml());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Metodo para visualizar el contenido del documento en html
        private void viewHtml() {
            System.out.println(document.html().toString());
        }
    }
