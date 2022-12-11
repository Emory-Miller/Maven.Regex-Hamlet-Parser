import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    private String hamText = "hamlet";

    public HamletParser(){
        this.hamletData = loadFile(hamText);
    }

    public String loadFile(String loadFile){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(loadFile + ".txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public int findHamlet(String text){
        Pattern p1 = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(text);
        int count = 0;
        while(m1.find()){
            count++;
        }
        return count;
    }

    public String replaceHamlet (String replace, String text){
        Pattern p1 = Pattern.compile("Hamlet");
        Matcher m1 = p1.matcher(text);
        String str1 = m1.replaceAll(replace);
        Pattern p2 = Pattern.compile("HAMLET");
        Matcher m2 = p2.matcher(str1);
        String str2 = m2.replaceAll(replace.toUpperCase());
        return str2;
    }

    public int findHoratio(String text){
        Pattern p1 = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(text);
        int count = 0;
        while(m1.find()){
            count++;
        }
        return count;
    }

    public String replaceHoratio (String replace, String text){
        Pattern p1 = Pattern.compile("Horatio");
        Matcher m1 = p1.matcher(text);
        String str1 = m1.replaceAll(replace);
        Pattern p2 = Pattern.compile("HORATIO");
        Matcher m2 = p2.matcher(str1);
        String str2 = m2.replaceAll(replace.toUpperCase());
        return str2;
    }



}
