package jr.eecs1022.piglatin;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator
{
    private String english;
    private String pig;

    public PigLatinTranslator()
    {
        this.setEnglish("");
    }

    public PigLatinTranslator(String text)
    {
        this.setEnglish(text);
    }

    public String getEnglish()
    {
        return this.english;
    }

    public void setEnglish(String text)
    {
        this.english = text.toLowerCase();
        this.translate();
    }

    public String getPig()
    {
        return this.pig;
    }

    // Translate the state to PigLatin
    public void translate()
    {
        StringTokenizer st = new StringTokenizer(this.english);
        String result = "";
        while (st.hasMoreTokens())
        {
            String word = st.nextToken();
            String pig = this.translateWord(word);
            if (result.length() == 0)
            {
                result = pig;
            }
            else
            {
                result = result + " " + pig;
            }
        }
        this.pig = result;
    }

    // Translate the given word to PigLatin
    // and return the translation
    private static String translateWord(String word)
    {
        word = word.toLowerCase();

        // Rule 1
        Pattern rule1 = Pattern.compile("[aeiou]");
        Matcher regexMatcher1 = rule1.matcher(word);


        // Rule 2
        String substr = word.substring(0,1);
        Pattern rule2 = Pattern.compile("[aeiou]");
        Matcher regexMatcher2 = rule2.matcher(substr);

        // Rule 3
        Pattern rule3 = Pattern.compile("^[^aeiou].*");
        Matcher regexMatcher3 = rule3.matcher(word);

        if (word.length() == 0)
        {
            word = "error | enter word";
        }
        else if(!regexMatcher1.find())
        {
            word = word + "ay";
        }
        else if (regexMatcher2.find())
        {
            word = word + "way";
        }
        else if (regexMatcher3.find()){
            int occurrence = 0;
            boolean check = true;
            for(int i = 0; check; i++)
            {
                String sub = Character.toString(word.charAt(i));
                if(sub.matches("[aeiou]"))
                {
                    occurrence = i;
                    check = false;
                }
            }
            String substr2 = word.substring(0, occurrence);
            word = word.substring(occurrence, word.length());
            word = word+ substr2 + "ay";
        }

        // replace with correct code
        String result = word;
        return result;
    }

    public static void main(String[] args) {

        PigLatinTranslator p = new PigLatinTranslator("kk");
        p.setEnglish("kk");
        System.out.println("English: kk");
        System.out.println("Pig Latin: " + p.getPig());
        System.out.println();

        PigLatinTranslator o = new PigLatinTranslator("egg. star");
        o.setEnglish("egg. star");
        System.out.println("English: egg. star");
        System.out.println("Pig Latin: " + o.getPig());
        System.out.println();

        PigLatinTranslator l = new PigLatinTranslator("truck");
        l.setEnglish("truck");
        System.out.println("English: truck");
        System.out.println("Pig Latin: " + l.getPig());
        System.out.println();

        PigLatinTranslator m = new PigLatinTranslator("single space");
        m.setEnglish("single space");
        System.out.println("English: single space");
        System.out.println("Pig Latin: " + m.getPig());
        System.out.println();

        PigLatinTranslator n = new PigLatinTranslator("    double  space");
        n.setEnglish("double  space");
        System.out.println("English: double  space");
        System.out.println("Pig Latin: " + n.getPig());

    }
}
