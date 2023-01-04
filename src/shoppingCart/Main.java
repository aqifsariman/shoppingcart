package shoppingCart;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Console cons = System.console();
        List<String> fruits = new LinkedList<String>();
        String emptyString = "empty";
        boolean ended = false;
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to your shopping cart!");
        while(!ended){
            // String command = cons.readLine("> ");
            System.out.print("> ");
            String command = scan.next();

            if (command.equalsIgnoreCase("list".trim())) {
                for(int i = 0; i < fruits.size(); i++){
                    if(fruits.get(i) != null){
                    System.out.printf("%d. %s\n", i + 1, fruits.get(i));
                    emptyString = "filled";
                }
            } 
            if(emptyString.equalsIgnoreCase("empty")){
                System.out.println("Your cart is empty.");
                }
            
            }
            if(command.equalsIgnoreCase("add")){
                String item = scan.nextLine();
                String[] items = item.trim().split(" ",5);
                for(int i = 0; i< items.length; i++){
                    if(!fruits.contains(items[i])){
                        fruits.add(items[i].trim());
                        System.out.printf("Added %s to the cart.\n", items[i]);
                    } else{
                        System.out.printf("%s already in the cart.\n", 
                        items[i].substring(0,1).toUpperCase()
                        + items[i].substring(1));
                    }
                }
            }
            if(command.equalsIgnoreCase("delete")){
                String indexInput = scan.nextLine();
                String indexString = indexInput.trim();
                int indexInt = Integer.parseInt(indexString);
                if(indexInt > fruits.size()){
                    System.out.println("Incorrect item index.");
                }else{
                    System.out.printf("%s has been removed from the cart.\n", fruits.get(indexInt - 1));
                    fruits.remove(indexInt - 1 );
                }
            }
            if(command.equalsIgnoreCase("end")){
                System.out.println("Thank you for using Shopping Cart On-The-Go!");
                break;
            }
        }
    }
}
