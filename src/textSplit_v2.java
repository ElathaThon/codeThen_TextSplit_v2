
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


        System.out.println("\nHaciendo los tests para ver si funciona corractamente.....\n++++++++");

        //Tests con texto normalillo
        check(splitTextWithLinesOfTheSameSizeOfCharacters("The ability to write good code differentiates good developers from the rest", 3), Arrays.asList("The ability to write good", "code " +
                "differentiates good", "developers from the rest"));

        check(splitTextWithLinesOfTheSameSizeOfCharacters("aa bb cc dd", 2), Arrays.asList("aa bb", "cc dd"));

        check(splitTextWithLinesOfTheSameSizeOfCharacters("aa bb cc dd", 4), Arrays.asList("aa", "bb", "cc", "dd"));

        check(splitTextWithLinesOfTheSameSizeOfCharacters("aaa bb ccc dddddddddddddddddd", 2), Arrays.asList("aaa bb ccc", "dddddddddddddddddd"));

        //Ahora los raros
        check(splitTextWithLinesOfTheSameSizeOfCharacters("aaa bb ccc dddddddddddddddddd", 3), Arrays.asList("aaa bb", "ccc", "dddddddddddddddddd"));

        check(splitTextWithLinesOfTheSameSizeOfCharacters("aa bb", 4), Arrays.asList("aa", "bb", "", ""));

    }

    public static List<String> splitTextWithLinesOfTheSameSizeOfCharacters(String text, int lineas) {

        List<String> frases = new ArrayList<>();

        //Get each general info
        String[] palabras = text.split(" ");
        int numeroPalabras = palabras.length;
        int palabrasExtra = numeroPalabras % lineas;
        int palabrasLinea = (numeroPalabras - palabrasExtra) / lineas;

        int palabraActual = 0;

//        System.out.println("Hay " + numeroPalabras + " palabras, cada linea tendra " + palabrasLinea + " y quedan " + palabrasExtra + " palabras extras para repartir entre las lineas");

        int totalLetras = text.length();
        int letrasRestantes = totalLetras % lineas;
        int letrasLinea = (totalLetras - letrasRestantes) / lineas;

//        System.out.println("Hay " + totalLetras + " letras, cada linea tendra " + letrasLinea + " y quedan " + letrasRestantes + " letras extras para repartir entre las lineas");



        //FIX: Si son mes lineas que paraules
        if (lineas > numeroPalabras) {

            System.out.println("Se han pedido mas lineas que palabras!");

            for (int i = 0; i < lineas; i++) {

//                System.out.println("Num palabras:"+numeroPalabras+"/ i:"+i+" /lineas:"+lineas);
                if (numeroPalabras > i){
//                    System.out.println("Added to frases --> Palabra num."+i+" / " + palabras[i]);
                    frases.add(palabras[i]);
                } else {
//                    System.out.println("Added nothing to frases");
                    frases.add("");
                }

            }

            return frases;


        }





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

                System.out.println("Linea "+numeroLineaActual+" (" + stringParcial.substring(0,stringParcial.length()-1) + ") --> chars:" + stringParcial.substring(0,stringParcial.length()-1).length() );

                frases.add(stringParcial.substring(0,stringParcial.length()-1));

                stringParcial = palabra + " ";
                numeroLineaActual++;
            } else {
                stringParcial += palabra + " ";
            }



            palabraActual++;

        }

        //La ultima linea de totes
        frases.add(stringParcial.substring(0,stringParcial.length()-1));
        System.out.println("Linea "+numeroLineaActual+" (" + stringParcial.substring(0,stringParcial.length()-1) + ") --> chars:" + stringParcial.length() );



        return frases;

    }



    static void check(Object actual, Object expected) {


        if (!actual.equals(expected)) {
            throw new RuntimeException("Actual: " + actual + " is not equals to expected: " + expected);
        }else {
            System.out.println("Ok!\n++++++++");
        }
    }



}








