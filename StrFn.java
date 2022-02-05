package grammar_classes;

import java.util.Arrays;

/**
 * @author      Geovani Lopes Dias <geovani.phy.dias @ gmail.com>
 * @version     1.0
 * @since       1.0
 * @role Both public and static methods for dealing with strings in general.
 * <p>
 * 
 */
public class StrFn {
    
    /**
    * Execute bynary search for a string into a 1D String array.
    * <p>
    * Edited from a Stackoverflow answer from Thusitha Indunil (on 5/9/2017,
    * edited by Kohei Tamura on 8/3/2017) on how to implementing binary
    * search on an array of Strings. It was modified to get a boolean return,
    * though.
    * 
    * @param array: The String array to search in.
    * @param item: the String object to search for.
    * @return true if item is present in array.
    */
    public static boolean boolStrBinSearch(String[] array, String item){
        Arrays.sort(array);
        int low = 0, high = array.length-1, mid;
        while (low <= high) {
            mid = (low+high)/2;
            if (array[mid].compareTo(item) < 0) {low = mid+1;}
            else if (array[mid].compareTo(item) > 0) {high = mid-1;}
            else {return true;}}
        return false;
    }
    
    /**
    * 2D String array with the main irregular verbs in Portuguese for the 
    * third person.
    * <p>
    * Selection with the main irregular verbs conjugated for the third person
    * in the present and in the perfect pass.
    */
    public static final String[][] COMMOM_IRREGULAR_VERBS = {
        {"é", "são"}, {"foi", "foram"}, {"está", "estão"}, {"estava", "estavam"},
        {"vai", "vão"}, {"vem", "vêm"}, {"veio", "vieram"},
        {"faz", "fazem"}, {"fez", "fizeram"}, {"tem", "têm"}, {"teve", "tiveram"},
        {"cai", "caem"}, {"caiu", "caíram"}, {"sobe", "sobem"}, {"subiu", "subiram"},
        {"traz", "trazeram"}, {"trouxe", "trouxeram"},
        {"emerge", "emergem"}, {"emergiu", "emergiram"},
        {"repele", "repelem"}, {"repeliu", "repeliram"}
    };
    
    /**
    * Capitalizes a given String object.
    * <p>
    * From a Stackoverflow answer of Rekin (on 10/11/2010,
    * edited by Jens Piegsa on 7/7/2015) on how to cap a String.
    * 
    * @param toCap: String to cap.
    * @return the String object capitalized.
    */
    public static String cap(String toCap){
        String capitalized = toCap.substring(0, 1).toUpperCase()+toCap.substring(1);
        return capitalized;
    }
    
    
    /**
    * Indentifies if a word is accented.
    * <p>
    * In Portuguese, Stressed syllable very often are accented. To identify an
    * accented letter in it may be helpfull in grammatic methods.
    * 
    * @param word: the word to search for accents.
    * @return true if there is a tone accent.
    */
    public static boolean haveAccent(String word){
        char[] tones = {'á', 'â', 'é', 'ê', 'ó', 'ô', 'í', 'ú'};
        Main:
        for (char letter: word.toCharArray()){
            for (char tone: tones)
                {if (letter == tone) {return true;}}}
        return false;
    }
    
    
    /**
    * Transforms a singular substantive into its respective plural.
    * <p>
    * Method for exercise generator, to be used in every substantive of every
    * sentece, to guarantee agreement in number.
    * It didn't work with some compound words (as "batata-doce") and
    * exceptions to the plural rules (as "pão" or "irmão").
    * 
    * @param plural: a boolean atribute of Subject classes.
    * @param sing: the substantive in its singular form.
    * @return the String object properly.
    */
    public static String sToPlural(boolean plural, String sing){
        sing = sing.toLowerCase();
        if (!plural) {return sing;}
        
        else {
            String[] excSubst = {"lápis", "ônibus", "vírus"};
            for (String exc: excSubst){if (sing.equals(exc)){return sing;}}

            boolean haveAccent = haveAccent(sing);
            String pluralForm = "";
            if (sing.substring(sing.length()-1).equals("r") ||
                    sing.substring(sing.length()-1).equals("s") ||
                    sing.substring(sing.length()-1).equals("z"))
                {pluralForm = sing+"es";}
            else if (sing.substring(sing.length()-1).equals("m"))
                {pluralForm = sing.substring(0, sing.length()-1)+"ns";}
            else if (sing.substring(sing.length()-2).equals("ão"))
                {pluralForm = sing.substring(0, sing.length()-2)+"ões";} // Como lidar com exceções?
            else if (sing.substring(sing.length()-2).equals("al"))
                {pluralForm = sing.substring(0, sing.length()-2)+"ais";}
            else if (sing.substring(sing.length()-2).equals("el"))
                {pluralForm = sing.substring(0, sing.length()-2)+"éis";}
            else if (sing.substring(sing.length()-2).equals("ol"))
                {pluralForm = sing.substring(0, sing.length()-2)+"óis";}
            else if (sing.substring(sing.length()-2).equals("ul"))
                {pluralForm = sing.substring(0, sing.length()-2)+"uis";}
            else if (!haveAccent && sing.substring(sing.length()-2).equals("il"))
                {pluralForm = sing.substring(0, sing.length()-2)+"is";}
            else if (haveAccent && sing.substring(sing.length()-2).equals("il"))
                {pluralForm = sing.substring(0, sing.length()-2)+"eis";}
            else {pluralForm = sing+"s";}
            
        return pluralForm;
        }
    }
            
            
    /**
    * Transforms singular verbs into its respective plural for the third person.
    * <p>
    * Method for exercise generator, to be used in every verb of every sentece,
    * to guarantee agreement in number. Works well only for present and perfect
    * pass.
    * 
    * @param plural: a boolean atribute of Subject classes.
    * @param sing: the verb in its singular form (past or present).
    * @return the String object properly.
    */
    public static String vToPlural(boolean plural, String sing){
        if (!plural) {return sing;}
        
        else {
            // Main irregular verbs:
            String pluralForm = "";
            for (int i = 0; i < COMMOM_IRREGULAR_VERBS.length; i++)
                {if(sing.equals(COMMOM_IRREGULAR_VERBS[i][0]))
                    {pluralForm = COMMOM_IRREGULAR_VERBS[i][1];
                        return pluralForm;}}
            
            // Regular verbs:
            if (sing.substring(sing.length()-2).equals("ou"))
                {pluralForm = sing.substring(0, sing.length()-2)+"aram";}
            else if (sing.substring(sing.length()-2).equals("eu"))
                {pluralForm = sing.substring(0, sing.length()-2)+"eram";}
            else if (sing.substring(sing.length()-1).equals("a") ||
                    sing.substring(sing.length()-1).equals("e"))
                {pluralForm = sing+"m";}
            
        return pluralForm;
        }
    }
    
    
}
