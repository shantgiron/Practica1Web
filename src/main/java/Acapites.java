import java.io.*;
import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Scanner;

import org.jsoup.select.Elements;



public class Acapites {

    //Instancia documento para extraer el archivo html
    private Document document;
    //esta variable contiene el archivo digitado
    private String url;




    public Acapites() {
        URLinput();
        puntoA();



    }


    public void URLinput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca URL valida");
        String url= scanner.nextLine();

    }

    //a) Indicar la cantidad de lineas del recurso retornado.

    private void puntoA() {
        System.out.println("Cantidad de lineas: " + document.html().split("\n").length);
    }

    //b) Indicar la cantidad de párrafos (p) que contiene el documento HTML.

    private void puntoB() {

            System.out.println("Total de parrafos: " + document.getElementsByTag("p").size());
        }



  /* // c) Indicar la cantidad de imágenes (img) dentro de los párrafos que contiene el archivo HTML.

    private void puntoC() {
        try {
            int[] count = {0};

            document.getElementsByTag("p").forEach(element -> {
                element.getElementsByTag("img").forEach(element1 -> {
                    count[0]++;
                });
            });

            System.out.println("Total de imagenes dentro de los parrafos: " + count[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
/*    //d) indicar la cantidad de formularios (form) que contiene el HTML por categorizando por el método implementado POST o GET.
    private void puntoD() {
        try {
            int[] cantPost = {0};
            int[] cantGet = {0};

            document.getElementsByTag("form").forEach(element -> {
                element.getElementsByAttributeValue("method", "post").forEach(element1 -> {
                    cantPost[0]++;
                });
            });

            document.getElementsByTag("form").forEach(element -> {
                element.getElementsByAttributeValue("method", "get").forEach(element1 -> {
                    cantGet[0]++;
                });
            });

            System.out.println("Total de formularios 'POST': " + cantPost[0]);
            System.out.println("Total de formularios 'GET': " + cantGet[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    //e) Para cada formulario mostrar los campos del tipo input y su
    //respectivo tipo que contiene en el documento HTML.

    private void puntoE() throws IOException {
        for (Element element : document.getElementsByTag("form")) {
            System.out.println(element);
        }
    }


    //Para cada formulario parseado, identificar que el metodo de envío
    //del formulario sea por utilizando el método POST y enviar una
    //petición al servidor, con el parámetro llamado asignatura y valor
    //practica1 y mostrar la respuesta por la salida estandar.

    /*private void puntoF() {
        Connection.Response response = null;
        Document doc = null;
        Map<String, String> parametros = new HashMap<>();

        try {
            for (Element element : document.getElementsByTag("form")) {
                String absURL = element.absUrl("action");

                if (element.attr("method").equals("post")) {
                    parametros.put("asignatura", "practica1");

                    doc = Jsoup.connect(absURL)
                            .method(Connection.Method.POST)
                            .data(parametros)
                            .post();

                    System.out.println(doc.outerHtml());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    //Metodo para visualizar el contenido del documento en html

    private void viewHtml() {
        System.out.println(document.html().toString());
    }





}


