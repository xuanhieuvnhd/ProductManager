package menu;

import controller.AccountController;
import controller.ProductController;
import views.Main;

import java.util.Scanner;

public class MenuAdmin {
    public static void MenuAdmin() {
            Scanner scanner = new Scanner(System.in);
            AccountController accountController = new AccountController();
            accountController.readData();
            ProductController productController = new ProductController();
            productController.readData();
            int choose = -1;
            do {
                System.out.println(" >>>>>>>>   Menu Admin <<<<<<<");
                System.out.println("|       1. Them san pham moi     ");
                System.out.println("|       2. Sua thong tin san pham theo ma san pham        ");
                System.out.println("|       3. Xoa san pham theo ma so san pham          ");
                System.out.println("|       4. Hien thi danh sach tat ca san pham         ");
                System.out.println("|       5. Tim kiem san pham theo ten       ");
                System.out.println("|       6. Sap xep cac san pham theo gia");
                System.out.println("|       7. Tim san pham co gia cao nhat ");
                System.out.println("|       8. Hien thi danh sach cac tai khoan ");
                System.out.println("|       9. Xoa tai khoan theo ten ");
                System.out.println("|       10. Sap xep tai khoan theo ten ");
                System.out.println("|       0. Dang xuat                             ");
                System.out.println(" ----------------------------------------------");
                System.out.print("   ------> Vui long chon chuc nang: ");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.err.println("Chuc nang khong ton tai ! vui long chon lai: ");
                }
                switch (choose) {
                    case 1 -> productController.addProduct(scanner);
                    case 2 -> productController.updateProductById(scanner);
                    case 3 -> productController.deleteProductById(scanner);
                    case 4 -> productController.displayAllProduct();
                    case 5 -> productController.searchProductByName(scanner);
                    case 6 -> productController.sortProductByPrice(scanner);
                    case 7 -> productController.searchProductHighestPrice();
                    case 8 -> accountController.displayAccount();
                    case 9 -> accountController.deleteAccount(scanner);
                    case 10 -> accountController.sortAccountByName();
                    case 0 -> Main.MenuMain();
                }
            }
            while (true);
    }
}
