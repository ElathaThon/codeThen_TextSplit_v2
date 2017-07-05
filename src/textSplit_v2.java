
import java.util.*;

/**
 * Created by elatha on 5/7/17.
 */
public class textSplit_v2 {


    public static void main(String[] args) {

        String text = "The ability to write good code differentiates good developers from the rest patata";
        int lineas = 3;


        List<String> textoDivididoByWords = splitTextWithLinesOfTheSameSizeOfCharacters(text,lineas);

        System.out.println("------------- Words -------------");
        for(int i=0;i<textoDivididoByWords.size();i++){
            System.out.println(textoDivididoByWords.get(i));
        }




    }

    public static List<String> splitTextWithLinesOfTheSameSizeOfCharacters(String text, int lineas) {

        List<String> frases = new ArrayList<>();

        //Get each general info
        String[] palabras = text.split(" ");
        int numeroPalabras = palabras.length;
        int palabrasExtra = numeroPalabras % lineas;
        int palabrasLinea = (numeroPalabras - palabrasExtra) / lineas;

        System.out.println("Hay " + numeroPalabras + " palabras, cada linea tendra " + palabrasLinea + " y quedan " + palabrasExtra + " palabras extras para repartir entre las lineas");

        int totalLetras = text.length();
        int letrasRestantes = totalLetras % lineas;
        int letrasLinea = (totalLetras - letrasRestantes) / lineas;

        System.out.println("Hay " + totalLetras + " letras, cada linea tendra " + letrasLinea + " y quedan " + letrasRestantes + " letras extras para repartir entre las lineas");

//        Hay 13 palabras, cada linea tendra 4 y quedan 1 palabras extras para repartir entre las lineas
//        Hay 82 letras, cada linea tendra 27 y quedan 1 letras extras para repartir entre las lineas

        String stringParcial = "";
        int lineaActual = 0;

        for (String palabra : palabras) {

            stringParcial += palabra;

            if (stringParcial.length() > letrasLinea){
                System.out.println("Linea nueva");
                lineaActual++;
            }else {
                stringParcial += " ";
            }


        }

        System.out.println(stringParcial);







        return frases;

    }






}








