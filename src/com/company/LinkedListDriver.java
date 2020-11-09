package com.company;


import java.util.Scanner;

/**
 * LinkedListDriver class prints out a menu of choices for the client
 * and uses the methods from the IntList class.
 *
 * Assumption: input is based on the following case items.
 * 1. Insert at Beginning value
 * 2. Insert at Last value
 * 3. Delete
 * 4. Get First
 * 5. Get Last
 *
 * Alternate Option: uncomment menu choices to run with menu option
 */
public class LinkedListDriver {

    private static Scanner scan;
    private static IntList list = new IntList();

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        boolean run = true;

        while(run) {
            String userInput = scan.nextLine();
            String[] action = userInput.split("\\s"); // split user input on empty space
            try {
                switch (action.length) {
                    case 2:
                        if (action[0].equals("Delete")) {
                            if (list.delete(Integer.valueOf(action[1])))
                                list.print();
                        } else if (action[0].equals("Get") && action[1].equals("First")) {
                            System.out.println(list.getFirst());
                        } else if (action[0].equals("Get") && action[1].equals("Last")) {
                            System.out.println(list.getLast());
                        }
                    case 4:
                        if (action[2].equals("Beginning")) {
                            list.addFirst(Integer.valueOf(action[3]));
                            list.print();
                        } else if (action[2].equals("Last")) {
                            list.addLast(Integer.valueOf(action[3]));
                            list.print();
                        }
                    default:
                        break;

                }
            } catch (Exception e) {
                // do nothing
            }
        }

//        // Alternate Option: menu selection
//        printMenu();
//        int choice = scan.nextInt();
//        while (choice != 0) {
//            dispatch(choice);
//            printMenu();
//            choice = scan.nextInt();
//        }
//        //signature
//        System.out.println("\nCoded by Jose Pinott");
    }

    // execute menu item action
    private static void dispatch(int choice) {
        int newVal, number, total;
        switch(choice) {
            case 0:     //end
                System.out.println("Bye!");
                break;

            case 1:    //add to front
                System.out.println("Insert at Beginning");
                newVal = scan.nextInt();
                list.addFirst(newVal);
                list.print();
                break;

            case 2:   //add to end
                System.out.println("Insert at Last");
                newVal = scan.nextInt();
                list.addLast(newVal);
                list.print();
                break;

            case 3:	//delete method
                System.out.println("Delete from list");
                number = scan.nextInt();
                if(list.delete(number))
                    list.print();
                break;

            case 4:  //get first element
                System.out.println(list.getFirst());
                break;

            case 5:  //get last element
                System.out.println(list.getLast());
                break;

            case 6:  //remove first element
                list.removeFirst();
                break;

            case 7:  //print
                list.print();
                break;

            case 8:  //get list size
                System.out.println(list.length());
                break;

            case 9:  //print list value
                System.out.println(list);
                break;

            case 10:  //removes the last element of the list
                list.removeLast();
                break;

            case 11:   //Replaces all occurrences of val in the list with newVal
                System.out.println("Enter integer to find");
                int oldVal = scan.nextInt();
                System.out.println("Enter integer that will replace oldVal");
                int nVal = scan.nextInt();
                list.replace(oldVal, nVal);
                break;

            case 12:  //printRec
                list.printRecursive();
                break;

            case 13:  //printRecBKW
                list.printRecursiveBackwards();
                break;

            case 14:	//delete method
                System.out.println("\nEnter total number of integers to delete: ");
                total = scan.nextInt();
                for(int i=0; i<total; i++)
                {
                    System.out.println("Enter integer to delete from list");
                    number = scan.nextInt();
                    if(! (list.delete(number)))
                        System.out.println(number + " could not be deleted!");
                    else
                        System.out.println(number + " was successfully deleted!");
                }
                break;

            default:
                System.out.println("Sorry, invalid choice");
        }
    }

    //----------------------------------------
    //  Prints the user's choices
    //----------------------------------------
    private static void printMenu() {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Add an integer to the beginning of the list");
        System.out.println("2: Add an integer to the end of the list");
        System.out.println("3: Remove an integer from the front of the list");
        System.out.println("4: Get first item in the list");
        System.out.println("5: Get last item in the list");
        System.out.println("6: Remove first item from the list");
        System.out.println("7: Print the list");
        System.out.println("8: Get the total number of elements in the list");
        System.out.println("9: Print the list value");
        System.out.println("10: Remove the last element of the list");
        System.out.println("11: Replaces all occurrences of oldVal's in the list with newVal.");
        System.out.println("12: Prints the list from first to last using recursion");
        System.out.println("13: Prints the list from last to first using recursion");
        System.out.println("14: Remove several integers from the list by target");

        System.out.print("\nEnter your choice: ");
    }
}
