package com.slearning.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
    private static void optionsSelection() {
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        Scanner sc = new Scanner(System.in);
        while (true) { // Loop to keep showing options until user exits
            String[] arr = {
                "1. Review my expenditure",
                "2. Add expenditure",
                "3. Delete expenditure",
                "4. Sort expenditures",
                "5. Search for expenditure",
                "6. Close application"
            };
            int slen = arr.length;
            for(int i=0; i<slen;i++){
                // display the all the Strings mentioned in the String array
                System.out.println(arr[i]); 
            }
            System.out.println("\nEnter your choice:\t");
            int options = sc.nextInt();

            if (options > 0 && options <= arr.length) {
                switch (options) {
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses + "\n");
                        
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        System.out.println(expenses + "\n");
                        //optionsSelection();
                        break;
                    case 3:
                        System.out.println("You are about to delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int confirmChoice = sc.nextInt();
                        if (confirmChoice == options) {
                            expenses.clear();
                            System.out.println(expenses + "\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        break;
                    case 4:
                        sortExpenses(expenses);
                        break;
                    case 5:
                        searchExpenses(expenses);
                        break;
                    case 6:
                        closeApp();
                        return; // Exit the program
                }
            } else {
                System.out.println("You have made an invalid choice!");
                System.out.println("Please make a correct choice\n");
                optionsSelection();
                break;
            }
        }
    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        if (arrayList.isEmpty()) {
            System.out.println("No expenses available to search.");
            return;
        }
        //int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        //Complete the method
        Scanner sc1 = new Scanner(System.in);
        int expenseToSearch = sc1.nextInt();
        boolean found = false;
        for (Integer expense : arrayList) {
            if (expense == expenseToSearch) {
                System.out.println("Expense found: " + expenseToSearch);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Expense not found: " + expenseToSearch);
        }
    }
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        //int arrlength =  arrayList.size();
        if (arrayList.isEmpty()) {
            System.out.println("No expenses available to sort.");
            return;
        }
        Collections.sort(arrayList);
        System.out.println("Expenses sorted in ascending order: " + arrayList);
       //Complete the method. The expenses should be sorted in ascending order.
    }
}

