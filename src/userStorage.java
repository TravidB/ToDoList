import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class userStorage {
    public static final String FILE_PATH = "UserInfo.ser";

    public static List<User> loadUser(){
        File file = new File(FILE_PATH);
        if(!file.exists()){ return new ArrayList<>();}

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream (FILE_PATH))){
            return (List<User>) in.readObject();
        } catch (IOException | RuntimeException | ClassNotFoundException e){
            return new ArrayList<>();
        }
    }

    public static void saveUser(List<User> user){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(user);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void addUser(User user){
        List<User> userList = loadUser();
        userList.add(user);
        saveUser(userList);
    }
}
