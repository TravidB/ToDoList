import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Todo {



    public static void choices(){
        System.out.println("Type the number for each action");
        System.out.println("1. to add item");
        System.out.println("2. to remove item");
        System.out.println("3. to check item");
        System.out.println("-1. to end the application");
    }

    public static ArrayList<HashMap<String, Integer>> removeHash(ArrayList<HashMap<String, Integer>> list2, String remove){
        Iterator<HashMap<String, Integer>> it = list2.iterator();
        int index = 0;

        while(it.hasNext()){
            HashMap<String, Integer> item = it.next();
            for(String k : item.keySet()){
                if(k.equals(remove)){
                    list2.remove(index);
                } else {
                    index++;
                    continue;
                }
            }
        }

        return list2;
    }

    public static String check(int c){
        if(c == 1){
            return "checked";
        } else if (c == -1){
            return "unchecked";
        } else {
            return "invalid";
        }
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
                
                System.out.println("Input name of checked item: ");
                String checker = in.next();
                list = removeHash(list, checker);
                HashMap<String, Integer> item = new HashMap<>();
                item.put(checker, 1);
                list.add(item);
                
            }
            choices();
            input = in.nextInt();

        }
            System.out.println("Shopping List: ");
                for(HashMap<String, Integer>item : list){
                    
                    for(String k : item.keySet()){
                        System.out.println(k + " | " + check(item.get(k)));
                    }
                    //System.out.println(key + " | " + item.get(key));
                }
    }
}
