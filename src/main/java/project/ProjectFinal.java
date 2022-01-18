package project.pkgfinal;

import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ProjectFinal {

    
    static Boolean User;
    static Boolean Admin;
   
    public static void main(String[] args) {
        menu();
        optionSelect();
        
    }
    
    static void optionSelect(){
        System.out.println("Please enter an option off the menu");
            
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        if (input.equals("1")){
            logon();
        }
        else if (input.equals("2")){
           addData();
        }
        else if (input.equals("3")){
           readData();
        }
        else if (input.equals("4")){
            calcTotal();
        }
    }
    
    static void menu(){
        System.out.println("----------------------------------");
        System.out.println("\n");
        System.out.println("1) Logon / switch user");
        System.out.println("2) Add data");
        System.out.println("3) Read data (admin only)");
        System.out.println("4) Calculate cost");
        System.out.println("\n");
        System.out.println("----------------------------------");
    }
    
    static void logon(){
        System.out.println("Please enter your username");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        Scanner sc2 = new Scanner(System.in);
        String password = sc2.nextLine();
        
        if (username.equals("user") && password.equals("password")){
        User = true;
        System.out.println("user logged in");
        menu();
        optionSelect();
    }
        else if (username.equals("admin") && password.equals("password")){
            Admin = true;
            System.out.println("admin logged in");
            menu();
            optionSelect();
        }
        else{
            System.out.println("logon failed, please try again");
            menu();
            optionSelect();
        }
        
        
    }
    
    public static void addData(){
        
        System.out.println("Please enter your full name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Please enter your contact number");
        String number = sc.nextLine();
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Please enter your full address");
        String address = sc.nextLine();
        
        try {
            try (FileWriter myWriter = new FileWriter("C:\\git\\pkgfinal\\project.txt")) {
                myWriter.write(name + "\t" + number + "\t" + address);
                myWriter.write("\n");
                myWriter.flush();
                myWriter.close();
                menu();
                optionSelect();
            }
        } catch (IOException ex) {
            System.out.println("Error occured, please try again" + ex.getStackTrace());
            menu();
            optionSelect();
        }
    }
    
    public static void readData(){
        if(Admin == true){
                    try{
            File myObj = new File("C:\\git\\pkgfinalproject.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println("\n");
                System.out.println(data);
                menu();
                optionSelect();
            }
        } catch (FileNotFoundException e){
            System.out.println("error");
            menu();
            optionSelect();
        }   
        }
        else{
            System.out.println("Access denied.");
            menu();
            optionSelect();
        }
        }
    
    public static void calcTotal(){
        double cardFee = 0;
        double discount = 0;
        double dayCost = 0;
        double VAT = 0;
        double total = 0;
        String chosenVilla;
        int daysStay;
        
        System.out.println("Please enter the number of days that you are staying at the site for");
        Scanner sc = new Scanner(System.in);
        daysStay = sc.nextInt();

        System.out.println("----------------------------------");
        System.out.println("1) Paradise Villa");
        System.out.println("2) Sunshine Hut");
        System.out.println("3) Standard Cabin");
        System.out.println("4) Treehouse");
        System.out.println("5) Classig Tipi");
        System.out.println("----------------------------------");
        System.out.println("\n");
        
        System.out.println("Please enter the value of the villa that you will be staying at");
        Scanner sc2 = new Scanner(System.in);
        String villa = sc2.nextLine();
        
        if (villa.equals("1")){
            cardFee = 4.00;
            discount = 0.9;
            dayCost = 370;
            VAT = 1.15;
        }
        else if (villa.equals("2")){
            cardFee = 3.50;
            discount = 0.9;
            dayCost = 280;
            VAT = 1.15;
        }
        else if ((villa.equals("3"))){
            cardFee = 3.00;
            discount = 0.95;
            dayCost = 200;
            VAT = 1.15;
        }
        else if (villa.equals("4")){
            cardFee = 2.50;
            discount = 0.95;
            dayCost = 160;
            VAT = 1.15;
        }
        else if (villa.equals("5")){
            cardFee = 2.00;
            discount = 0.95;
            dayCost = 120;
            VAT = 1.15;
        }
        
        total = (dayCost * daysStay);
        if (daysStay > 13){
        total = (total * discount);
    }
        total = (total * 1.15);
        
        System.out.println(total);
        String totalOutput = Double.toString(total);
        
        try {
            try (FileWriter myWriter = new FileWriter("C:\\program\\project.txt")) {
                myWriter.write(totalOutput);
                myWriter.flush();
                myWriter.close();
                menu();
                optionSelect();
            }
        } catch (IOException ex) {
            System.out.println("Error occured, please try again");
            menu();
            optionSelect();
        }
    }
    
    public static void menuReturn(){
        System.out.println("Would you like to return to the menu?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.toLowerCase();
        
        if (input.equals("y")){
            menu();
            optionSelect();
        }
    }
    
}
    
