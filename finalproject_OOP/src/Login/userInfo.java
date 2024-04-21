/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Raynaldy
 */
public class userInfo {
    private static String userID;
    private static String userFullName;
    private static String userEmail;
    
    public void setUserInfo(String inputID, String inputFullName, String inputEmail){
        userID = inputID;
        userFullName = inputFullName;
        userEmail = inputEmail;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public String getUserFullName(){
        return userFullName;
    }
    
    public String getUserEmail(){
        return userEmail;
    }
}
