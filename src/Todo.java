import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Todo {



    public static void choices(){
        System.out.println("Type the number for each action");
        System.out.println("1. to add item");
        System.out.println("2. to remove item");
        System.out.println("3. to check item");
        System.out.println("-1. to end the application");
    }

    public void check(boolean x){
        //
    }
    public static void main(String[] args) throws Exception {
        
        choices();

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        ArrayList<HashMap<String , Integer>> list = new ArrayList<>();

        while(input != -1){
            if(input == 1){
                System.out.println("Name added item");
                String addedItem = in.next();
                HashMap<String, Integer> item = new HashMap<>();
                item.put(addedItem, -1);
                System.out.println("added " + list.add(item));
            } else if (input == 2){
                System.out.println("Name removed item");
                String removedItem = in.next();
                System.out.println("removed " + list.remove(removedItem));
            } else if (input == 3){
                for(HashMap<String, Integer>item : list){
                    
                    for(String k : item.keySet()){
                        System.out.println(k + " | " + item.get(k));
                    }
                    //System.out.println(key + " | " + item.get(key));
                }
            }
            choices();
            input = in.nextInt();

        }
            System.out.println("Shopping List: ");
                for(HashMap<String, Integer>item : list){
                    
                    for(String k : item.keySet()){
                        System.out.println(k + " | " + item.get(k));
                    }
                    //System.out.println(key + " | " + item.get(key));
                }
    }
}
