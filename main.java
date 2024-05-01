
import java.util. * ;



public class PhoneBook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> phoneBook = new HashMap<>();

        

        // Чтение данных из входного потока

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            if (line.isEmpty()) continue; // Пропускаем пустые строки

            

            String[] parts = line.split(" ");

            String name = parts[0];

            String phone = parts[1];

            

            // Добавляем номер телефона к списку номеров для данного имени

            phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);

        }

        

        // Подсчет количества телефонов для каждого имени

        Map<String, Integer> counts = new TreeMap<>();

        for (List<String> phones : phoneBook.values()) {

            int count = phones.size();

            counts.put(phones.get(0), count + (counts.containsKey(phones.get(0)) ? counts.get(phones.get(0)) : 0));

        }

        

        // Сортировка по убыванию числа телефонов

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(counts.entrySet());

        Collections.sort(sortedEntries, (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        

        // Выводим результат

        for (Map.Entry<String, Integer> entry : sortedEntries) {

            System.out.println(entry.getKey() + " " + entry.getValue());

        }

    }

}

