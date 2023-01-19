package asciimirror;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileUtils {

    public static boolean isPathValid(String input) {
        String regex = "^(?:[a-zA-Z]\\:|\\\\\\\\[\\w\\.]+\\\\[\\w.$]+)\\\\(?:[\\w]+\\\\)*\\w([\\w.])+$";
        if (input != null) {
            if (Pattern.matches(regex, input)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void printFile(String path)  {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }

    }

    public static List<String> readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder sb;
            List<String> animal = new ArrayList<String>();
            int count = 0;
            while ((line = br.readLine()) != null) {
                sb = new StringBuilder();
                sb.append(line);
                animal.add(count, sb.toString());
                count++;
            }
            modifyLength(animal);
            return animal;
        } catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }
    }

    public static void modifyLength(List<String> list) {
        int lineWidth = maxLengthInList(list);
        int size = list.size();
        StringBuilder sb;
        int count = 0;
        for (int i = 0; i < size; i++) {
            sb = new StringBuilder();
            sb.append(list.get(i));
            while (sb.length() < lineWidth) {
                sb.append(" ");
            }
            list.set(i, sb.toString());
        }
    }

    static int maxLengthInList(List<String> list) {
        int max = list.get(0).length();
        int size = list.size();
        for (int i = 1; i < size; i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
            }
        }
        return max;
    }

    public static void printList(List<String> animals) {
        List<String> mirrorList = mirrorCopyList(animals);
        modifyingMirrorList(mirrorList);
        String line1;
        String line2;
        String separator = "|";
        int count = 0;
        while (count < animals.size()) {
            line1 = animals.get(count);
            line2 = mirrorList.get(count);
            System.out.printf("%s | %s\n", line1, line2);
            count++;
        }
    }

    static List<String> mirrorCopyList(List<String> list) {
        List<String> mirrorList = new ArrayList<>();
        int count = 0;
        StringBuilder sb;
        for (String s : list) {
            mirrorList.add(count, new StringBuilder(s).reverse().toString());
            count++;
        }
        return mirrorList;
    }

    static void modifyingMirrorList(List<String> list) {
        List<String> mirrorList = List.copyOf(list);
        int count = 0;
        StringBuilder sb;
        // / = \, \ = /, < = >, > = <, [ = ], ] = [. { = }. } = {, ( = ), ) = (,
        // "([\\)\\]\\}]).*?([\\(\\[\\{])","([\\(\\[\\{]).*?([\\)\\]\\}])")
        for (String s : mirrorList) {
            sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    sb.append("(");
                } else if (s.charAt(i) == '(') {
                    sb.append(")");
                } else if (s.charAt(i) == ']') {
                    sb.append("[");
                } else if (s.charAt(i) == '[') {
                    sb.append("]");
                } else if (s.charAt(i) == '/') {
                    sb.append("\\");
                } else if (s.charAt(i) == '\\') {
                    sb.append("/");
                } else if (s.charAt(i) == '}') {
                    sb.append("{");
                } else if (s.charAt(i) == '{') {
                    sb.append("}");
                } else if (s.charAt(i) == '<') {
                    sb.append(">");
                } else if (s.charAt(i) == '>') {
                    sb.append("<");
                } else {
                    sb.append(s.charAt(i));
                }
            }
            list.set(count, sb.toString());
            count++;
        }
    }
}
