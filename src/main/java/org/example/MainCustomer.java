package org.example;
import org.example.entity.CustomerService;
import java.util.Scanner;
public class MainCustomer {

    public static void main(String args[]) {
        CustomerService customerservice = new CustomerService();
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("1.Registration\n2.Login\n3.Exit\nEnter Your Choice:");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    customerservice.customerRegistration();
                    break;
                case 2:
                    customerservice.loginCustomer();
                    break;

                case 3:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice Try Again!!");
            }
        } while (ch != 3);
    }
}