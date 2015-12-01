
import com.sportsclub.duminda.dao.UserDAOImpl;
import com.sportsclub.duminda.model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ESOFT
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        User u = new User();
        u.setUsername("niro");
        u.setPassword("7676");
        u.setUserType("Club");
        u.setUserStatus(false);
        
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());
        System.out.println(u.getUserType());
        System.out.println(u.isUserStatus());
        
        UserDAOImpl userDAOImpl = new UserDAOImpl() ;
    //    userDAOImpl.login(u);
      
        System.out.println("add : " + userDAOImpl.registerUser(u));
    }
    
}
