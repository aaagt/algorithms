import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        String source = "CACABABABCCCAABAC";

        System.out.println(hasRepeats(source, 4)); // true, тк ABAB встречается два раза, хоть эти куски и пересекаются
        System.out.println(hasRepeats(source, 5)); // false
    }

    public static boolean hasRepeats(String source, int size) {
        Set<String> slices = new HashSet<>(); // множество всех подстрок длины size
        for (int i = 0; i <= source.length() - size; i++) { // перебор всех мест старта подстроки
            String slice = source.substring(i, i + size); // вырезание подстроки
            if (slices.contains(slice)) { // проверка на наличие повтора этой подстроки
                return true; // если уже встречали, значит повторы нет
            } else {
                slices.add(slice);  // иначе запоминаем подстроку и перебираем дальше
            }
        }
        return false; // если бы нашли, то вышли бы по return true, а значит повторов нет
    }

}