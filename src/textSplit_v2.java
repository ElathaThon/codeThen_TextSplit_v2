
import java.util.*;

/**
 * Created by elatha on 5/7/17.
 */
public class textSplit_v2 {


    public static void main(String[] args) {

        String text = "The ability to write good code differentiates good developers from the rest";
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
        int numeroLineaActual = 0; //per saber a quina estic, es pot borrar al final

        for (String palabra : palabras) {

            //comprovem si esta mes al final o al principi de la paraula...
            int charsDisponiblesEnLinea = palabrasLinea - stringParcial.length(); //encara es poden possar 3 chars

//            if ( palabra.length() / 2 <= charsDisponiblesEnLinea + letrasRestantes ) { //Significa que la mes de la mitat de la paraula entra amb els chars dispoibles que tenim
//                    if (letrasRestantes > 0) {
//                        System.out.println("Se han gastado las letras extras");
//                        letrasRestantes = 0; //Hem gastat les lletres extras que teniem... TDOD: Calcular les lletres restantes que s'han fet servir, potser no son totes.
//                    }
//
//                    stringParcial += " " + palabra;
//                    System.out.println("xxxx1: Linea "+numeroLineaActual+" (" + stringParcial + ") --> chars:" + stringParcial.length() );
//
//            } else

            if ((stringParcial + palabra).length() > letrasLinea){

                System.out.println("Linea "+numeroLineaActual+" (" + stringParcial + ") --> chars:" + stringParcial.length() );

                frases.add(stringParcial);

                stringParcial = palabra + " ";
                numeroLineaActual++;
            } else {
                stringParcial += palabra + " ";
            }

        }

        //La ultima linea de totes
        frases.add(stringParcial);
        System.out.println("Linea "+numeroLineaActual+" (" + stringParcial + ") --> chars:" + stringParcial.length() );



        return frases;

    }



    static void check(Object actual, Object expected) {

        if (!result.equals(expected)) {
            throw new RuntimeException("Actual: " + actual + " is not equals to expected: " + expected);
        }
    }



}








