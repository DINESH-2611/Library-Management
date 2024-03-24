import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zsgs.librarymanagement.model.User;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ISBN="ISBN "+generate1(999)+"-"+generate1(9)+"-"+generate1(999)+"-"+generate1(99999)+"-"+generate1(9);
        System.out.println(ISBN);
//        List<User> res = loadUsers();
//        for (User user1 : res) {
//            System.out.println(user1.getUserName() + "-->" + user1.getPhoneNo());
//        }
//        System.out.println("---------------------------------");
//        List<User> userList=new ArrayList<>();
//        User user=new User();
//        user.setUserName("Balaji");
//        user.setPhoneNo(987654321);
//        res.add(user);
//        new Main().saveCandidates(res);
//        for (User user1 : res) {
//            System.out.println(user1.getUserName() + "-->" + user1.getPhoneNo());
//        }

    }

    public void saveCandidates(List<User> userList) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(userList);

        try (FileWriter writer = new FileWriter("D:\\Java\\User.json")) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<User> loadUsers() {
        Gson gson = new Gson();
        List<User> loadedList = new ArrayList<>();
//        File file=new File("D:\\Java\\User.json");
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        try (

                FileReader reader = new FileReader("D:\\Java\\User.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<User>>() {}.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private static int generate1(int n){
        return (int)(Math.random()*n);
    }
}