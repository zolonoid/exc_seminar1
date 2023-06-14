/**
 * Семинар 1
 */
public class Program {
    static int[] array1 = { 6, 12, 20, 30, 42 };
    static int[] array2 = { 2, 3, 4, 5, 6 };
    static Op operation = Op.division;

    public static void main(String[] args) {
        try {
            System.out.printf("Заданы массивы:\n 1: %s\n 2: %s\n", arrayToString(array1), arrayToString(array2));
            String opName = operation == Op.division ? "частного" : "разницы";
            System.out.printf("Результат выполнения метода получения %s элементов массивов:\n", opName);
            int[] result = operation == Op.division ? division(array1, array2) : subtraction(array1, array2);
            System.out.printf(" %s", arrayToString(result));
        } catch (RuntimeException e) {
            System.out.printf(" Ошибка. %s", e.getMessage());
        }
    }

    // Метод, принимающий в качестве аргументов два целочисленных массива, и
    // возвращающий новый массив, каждый элемент которого равен разности элементов
    // двух входящих массивов в той же ячейке.
    private static int[] subtraction(int[] arr1, int[] arr2) {
        int[] result;
        try {
            result = new int[Math.max(arr1.length, arr2.length)];
            for (int i = 0; i < result.length; i++) {
                result[i] = arr1[i] - arr2[i];
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Массив arr1 или arr2 имеет значение null.");
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Длины массивов не равны.");
        } catch (Exception e) {
            throw new RuntimeException("Что-то пошло не так.");
        }
        return result;
    }

    // Метод, принимающий в качестве аргументов два целочисленных массива, и
    // возвращающий новый массив, каждый элемент которого равен частному элементов
    // двух входящих массивов в той же ячейке.
    private static int[] division(int[] arr1, int[] arr2) {
        int[] result;
        try {
            result = new int[Math.max(arr1.length, arr2.length)];
            for (int i = 0; i < result.length; i++) {
                result[i] = arr1[i] / arr2[i];
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Массив arr1 или arr2 имеет значение null.");
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Длины массивов не равны.");
        } catch (ArithmeticException e) {
            throw new RuntimeException("Один из элементов массива arr2 имеет значение 0.");
        } catch (Exception e) {
            throw new RuntimeException("Что-то пошло не так.");
        }
        return result;
    }

    private static String arrayToString(int[] arr) {
        if (arr == null)
            return "null";
        var builder = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++)
            builder.append(String.format("%d%s", arr[i], i < arr.length - 1 ? "," : ""));
        builder.append("]");
        return builder.toString();
    }

    enum Op {
        subtraction,
        division
    }
}
