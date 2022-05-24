import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FifthTask {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();
        scanner.close();
        File file1 = new File(filePath);
        FifthTask.readFile(file1);

    }

    public static void readFile(File file) throws FileNotFoundException {

        ArrayList<String> allWord = new ArrayList<String>();
        Scanner reader = new Scanner(file);
        while (reader.hasNext()) {
            allWord.add(reader.next());
        }
        reader.close();

        Collections.sort(allWord);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : allWord) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                map.put(word, map.get(word) + 1);
            }
        }
        System.out.println("Статистика по количеству встречающихся слов: " + map);

        int maxValue = Collections.max(map.values());

        System.out.print("Слово (слова) с максимальным количеством повторений: ");
        for (Map.Entry word : map.entrySet()) {
            Object key = word.getKey();
            Object value = word.getValue();
            if ((Integer) value == maxValue) {
                System.out.print(key + " = " + value + "   ");
            }
        }
    }
}
