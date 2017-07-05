import java.util.*;

/**
 * Created by elatha on 5/7/17.
 */
public class textSplit_v2 {


    public static void main(String[] args) {

        String text = "The ability to write good code differentiates good developers from the rest patata";
        int lineas = 3;


        List<String> textoDivididoByWords = textSplitWords(text,lineas);

        System.out.println("------------- Words -------------");
        for(int i=0;i<textoDivididoByWords.size();i++){
            System.out.println(textoDivididoByWords.get(i));
        }




    }

    public static List<String> textSplitWords(String text, int lineas) {

        List<String> frases = new ArrayList<>();

        String[] palabras = text.split(" ");
        int numeroPalabras = palabras.length;
        int palabrasExtra = numeroPalabras % lineas;
        int palabrasLinea = (numeroPalabras - palabrasExtra) / lineas;
        int palabrasLineaActual = palabrasLinea;

        System.out.println("Hay " + numeroPalabras + " palabras, cada linea tendra " + palabrasLinea + " y quedan " + palabrasExtra + " palabras extras para repartir entre las lineas");


        int paraulaActualNumero = 0;
        for (int i = 1; i < lineas+1; i++) {

            String stringParcial = "";


            if (palabrasExtra > 0) {
                System.out.println("Extra!");
                palabrasLineaActual = palabrasLinea + 1;
                palabrasExtra--;
            } else {
                palabrasLineaActual = palabrasLinea;
            }

            for (int j = 0; j < palabrasLineaActual; j++) {
                System.out.println(i +"# Aquesta linea te "+palabrasLineaActual+" paraules. La palabra numero " + j + " es: " + palabras[j]);
                stringParcial += palabras[paraulaActualNumero] + " ";
                paraulaActualNumero++;
            }

            stringParcial = stringParcial.substring(0, stringParcial.length() - 1);

            System.out.println(i+ "# A la linea " + i + " -->'"+stringParcial + "' en total son " + stringParcial.split(" ").length + " palabras");

            frases.add(stringParcial);

        }

        return frases;

    }








}








