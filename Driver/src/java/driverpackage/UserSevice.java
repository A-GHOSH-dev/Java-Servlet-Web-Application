package driverpackage;

import java.util.ArrayList;

public class UserSevice {
    
    public static ArrayList<User> getAllUsers(){
    ArrayList<User> userList = new ArrayList<>();
        
        User user1 = new User("Abishek",21,2);
        User user2 = new User("Annu",23,1);
        User user3 = new User("Saima",12,0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        
        return userList;
        
    }
}