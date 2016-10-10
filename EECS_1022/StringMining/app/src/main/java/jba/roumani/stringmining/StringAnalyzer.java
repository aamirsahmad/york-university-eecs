package jba.roumani.stringmining;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2/14/16.
 */
public class StringAnalyzer
{
    private String data;

    public StringAnalyzer()
    {
        this.setData("");
    }

    public StringAnalyzer(String data)
    {
        this.setData(data);
    }

    public void setData(String data)
    {
        this.data = data;
    }

    /**
     * Compute the frequency of the passed character in the state.
     *
     * @param c the char to look for.
     * @return the #of times c appears in the state.
     */
    public int charCount(char c)
    {
        // your code here ...
        return 0;

    }

    /**
     * Compute the frequency of the first character in the
     * passed string in the state.
     *
     * @param s the string whose first characcter is analyzed.
     * @return the #of times s appears in the state.
     */
    public int charCount(String s)
    {
        return this.charCount(s.charAt(0));
    }

    /**
     * Compute the frequency of the passed substring the state.
     *
     * @param sub the substring to look for.
     * @return the #of times sub appears in the state.
     */
    public int substringCount(String sub)
    {
        // your code here ...
        return 0;

    }

    /**
     * Determine if a postal code is embedded in the state.
     * The Canadian postal code embedded in the string, if any. The postal code
     * consists of an upper case letter, followed by a digit, followed by an
     * upper case letter, followed (optionally) by a space, followed by a digit,
     * followed by an upper case letter, followed by a digit.
     *
     * @return the first embedded postal code or null if none is found.
     */
    public String extractPostal()
    {
        // your code here ...
        return null;

    }

    /**
     * Determine the longest word in the state.
     * The longest word in the entered string. In case of a tie (several words
     * with the same maximal length), output the word that occurs first in the string.
     * A word is a character sequence that has at least one space before it (unless it
     * is the very first in the string) and one space after it (unless it is the very
     * last in the string). Punctuation characters touching a word are considered part
     * of that word.
     *
     * @return the longest word.
     */
    public String longestWord()
    {
        // your code here ...
        return null;

    }
}
