package views;

import controller.AccountController;
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) {
        Main.MenuMain();
    }
    public static void MenuMain() {
        Scanner scanner = new Scanner(System.in);
        AccountController accountController = new AccountController();
        accountController.readData();
        int chon = -1;
        System.out.println("*****************************");
        System.out.println("------------->Trang Chu<-------------");
        System.out.println("**          1. Dang nhap              **");
        System.out.println("**          2. Dang ky                  **");
        System.out.println("------------------------------------------");
        System.out.println("**          0. Thoat he thong        **");
        System.out.println("*****************************");
        do {

            System.out.print("  --> Vui long chon chuc nang:");
            try {
                chon = Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.err.println("Chuc nang khong ton tai ! vui long chon lai: ");
            }
            switch (chon) {
                case 1 -> accountController.login(scanner);
                case 2 -> accountController.addAucount(scanner);
                case 0 -> System.exit(0);
            }
        }
        while (true);
    }
}
