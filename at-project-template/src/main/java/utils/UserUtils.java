package utils;

import com.github.javafaker.Faker;
import model.User;

public class UserUtils {

    public static User getRandomUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        return user;
    }

    public static User getUser() {
        ReadExcelFile excelFile = new ReadExcelFile("src/test/resources/users.xlsx");
        User user = new User();
        user.setEmail(excelFile.getCell(1, 0));
        user.setPassword(excelFile.getCell(1, 1));
        return user;
    }
}
