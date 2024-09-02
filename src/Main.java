import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                List<Integer> numbers = inputNumbersList();
                System.out.println(String.format("average of even numbers: %s",
                        averageOfEvenNumbers(numbers)));
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> inputNumbersList() {
        System.out.print("Введите цэлые числа через пробел: ");
        String input = scanner.nextLine();

        return Arrays.stream(input.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static double averageOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }


}