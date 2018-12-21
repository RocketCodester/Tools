
public class StringMethods {

    //Concatenates any number of Strings [0,infinity)
    String concat(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }
}
