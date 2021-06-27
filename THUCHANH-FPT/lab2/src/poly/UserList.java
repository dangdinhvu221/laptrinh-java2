/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly;

import java.util.ArrayList;

public class UserList {
    ArrayList<User> list = new ArrayList<>();
    
    public void them(User us){
        list.add(us);
    }
}
