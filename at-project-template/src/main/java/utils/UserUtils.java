package utils;

import com.github.javafaker.Faker;
import model.User;

import java.util.Random;

public class UserUtils {

    public static User getRandomAccount() {
        Faker faker = new Faker();
        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        return user;
    }

    public static User getReceptionistAccount() {
        ReadExcelFile excelFile = new ReadExcelFile("src/test/resources/users.xlsx");
        User user = new User();
        user.setEmail(excelFile.getCell(1, 0));
        user.setPassword(excelFile.getCell(1, 1));
        return user;
    }

    public static User getCustomerAccount() {
        ReadExcelFile excelFile = new ReadExcelFile("src/test/resources/users.xlsx");
        User user = new User();
        user.setEmail(excelFile.getCell(2, 0));
        user.setPassword(excelFile.getCell(2, 1));
        return user;
    }

    public static User getAdminAccount() {
        ReadExcelFile excelFile = new ReadExcelFile("src/test/resources/users.xlsx");
        User user = new User();
        user.setEmail(excelFile.getCell(3, 0));
        user.setPassword(excelFile.getCell(3, 1));
        return user;
    }

    public static int getRandomAmount() {
        Random random = new Random();
        int min = 100;
        int max = 1000000;
        int amount = random.nextInt(max - min + 1) + min;
        return amount;
    }
}
