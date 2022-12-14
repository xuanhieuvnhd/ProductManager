package controller;

import menu.MenuAdmin;
import menu.MenuCutomer;
import model.Account;
import views.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountController {
    ArrayList<Account> accounts = new ArrayList<>();
    File file = new File("account.txt");
    public void writeData(ArrayList<Account> accounts) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
            o.writeObject(accounts);
            o.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void readData() {
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
            accounts = (ArrayList<Account>) o.readObject();
            o.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public boolean checkRegisteredName(String name) {
        String adm = "adm";
        String none1 = "";
        String none2 = " ";
        if (name.equals(adm)) {
            System.err.print("Tai khoan da ton tai ! vui long nhap ten khac :");
            return true;
        }
        if (name.equals(none1) || name.startsWith(none2)) {
            System.err.print("Khong de trong ten tai khoan ! vui long nhap lai: ");
            return true;
        }

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(name)) {
                System.err.print("Tai khoan da ton tai, vui long nhap ten khac: ");
                return true;
            }
        }
        return false;
    }
    public boolean checkRegistrationPassword(String password) {
        String none1 = "";
        String none2 = " ";
        if (password.equals(none1) || password.startsWith(none2)) {
            System.err.print("Khong de trong mat khau ! vui long nhap lai: ");
            return true;
        }
        return false;
    }
    public boolean checkAdmin(Account account) {
        return account.getName().equals("adm") && account.getPassword().equals("adm");
    }
    public void checkLogin(Account account) {
        boolean check = false;
        for (Account a : accounts) {
            if (account.getName().equals(a.getName()) && account.getPassword().equals(a.getPassword())) {
                check = true;
                System.out.println("Dang nhap thanh cong !");
                MenuCutomer.MenuCutomer();
            }
        }
        if (!check) {
            System.err.println("Sai ten dang nhap hoac mat khau , vui long nhap lai");
        }
    }
    public Account createAccount(Scanner scanner) {
        System.out.print("Ten tai khoan: ");
        Pattern p = Pattern.compile("[a-zA-Z0-9]{3,18}$");
        String name = scanner.nextLine();
        while (!p.matcher(name).find()) {
            if (!p.matcher(name).find()) {
                System.err.println("Sai quy tac tao tai khoan ! vui long nhap lai: ");
                name = scanner.nextLine();
            }
        }
        while (checkRegisteredName(name)) {
            name = scanner.nextLine();
        }
        System.out.print("Nhap mat khau: ");
        String password = scanner.nextLine();
        while (checkRegistrationPassword(password)) {
            password = scanner.nextLine();
        }
        return new Account(name, password);
    }
    public void addAucount(Scanner scanner) {
        Account account = createAccount(scanner);
        accounts.add(account);
        System.out.println("Dang ky thanh cong , vui long chon dang nhap");
        writeData(accounts);
        Main.MenuMain();
    }
    public void login(Scanner scanner){
        System.out.print("Ten dang nhap: ");
        String name = scanner.nextLine();
        System.out.print("Mat khau dang nhap: ");
        String password = scanner.nextLine();
        Account account = new Account(name, password);
        if (checkAdmin(account)) {
            System.out.println("Dang nhap thanh cong , xin chao Admin!");
            MenuAdmin.MenuAdmin();
        } else {
            checkLogin(account);
        }
    }
    public void displayAccount() {
        boolean check = false;
        for (Account account : accounts) {
            System.out.println(account);
            check = true;
        }
        if (!check) {
            System.err.println("Chua co tai khoan nao trong he thong, vui long nhan 0 de tro ve Trang Chu va chon dang ky");
        }
    }
    public void deleteAccount(Scanner scanner) {
        boolean check = false;
        System.out.print("Nhap ten tai khoan muon xoa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(name)) {
                accounts.remove(i);
                check = true;
                System.out.println("Xoa tai khoan thanh cong");
                writeData(accounts);
            }
        }
        if (!check) {
            System.err.println("Tai khoan khong ton tai !");
        }
    }
    public void changePassword(Scanner scanner) {
        System.out.print("Nhap mat khau hien tai: ");
        String password = scanner.nextLine();
        for (int i = 0 ; i < accounts.size() ; i++){
            if (accounts.get(i).getPassword().equals(password)){
                System.out.print("Nhap mat khau moi: ");
                String password1 = scanner.nextLine();
                accounts.get(i).setPassword(password1);
                System.out.println("Thay doi mat khau thanh cong !");
               writeData(accounts);
            }
        }
    }
    public void changeLoginName(Scanner scanner) {
        System.out.print("Nhap ten hien tai: ");
        String name = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                System.out.print("Nhap ten moi: ");
                String name1 = scanner.nextLine();
                account.setName(name1);
                System.out.println("Doi ten tai khoan thanh cong !");
                writeData(accounts);
            }
        }
    }
    public void findAccountByName(Scanner scanner) {
        boolean check = false;
        System.out.print("Nhap ten tai khoan can tim: ");
        String name = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getName().equalsIgnoreCase(name)) {
                System.out.println(account);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay tai khoan co ten la: " + name);
        }
    }
    public void sortAccountByName() {
        readData();
        Collections.sort(accounts);
        System.out.println("Danh sach tai khoan da sap xep theo ten:");
        displayAccount();
    }
}
