package utils;

import model.User;

public class UserUtils {

    public static Object[][] getAllUsersFromExcelFile() {
        ReadExcelFile excelFile = new ReadExcelFile("src/test/resources/users.xlsx");
        Object[][] arr = new Object[2][1];
        // Đọc 2 users từ file receptionistAccount
        for (int i = 1; i <= 2; i++) {
            User user = new User();

            user.setEmail(excelFile.getCell(i, 0));
            user.setPassword(excelFile.getCell(i, 1));
            user.setName(excelFile.getCell(i, 2));

            arr[i - 1][0] = user;
        }
        return arr;
    }
}
