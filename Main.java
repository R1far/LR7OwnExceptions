import java.util.Scanner;

// Собственное исключение для проверки имени
class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }
}

// Валидатор имени пользователя
class UserNameValidator {
    private static final char REQUIRED_FIRST_LETTER = 'А';

    public static void checkUserName(String name) throws InvalidNameException {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("Имя не может быть пустым");
        }

        char firstLetter = name.charAt(0);
        if (firstLetter != REQUIRED_FIRST_LETTER && firstLetter != 'а') {
            throw new InvalidNameException("Имя должно начинаться на букву 'А'");
        }
    }
}

// Главный класс программы
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String userName = scanner.nextLine();

        try {
            UserNameValidator.checkUserName(userName);
            System.out.println("Имя принято! Добро пожаловать, " + userName + "!");
        } catch (InvalidNameException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}