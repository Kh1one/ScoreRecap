/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Raynaldy
 */
public class userLogin {
    String user;
    String fullName;
    String email;
    String pass;
    
    private static final String username = "root";
    private static final String password = ""; //ganti pake pass mu dewe
    private static final String dataconn = "jdbc:mysql://localhost:3306/univdb";
    
    Connection SQLcon = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    int q, i;
    
    public userLogin(String usernameInput, String fullNameInput, String emailInput, String passwordInput){
        user = usernameInput;
        fullName = fullNameInput;
        email = emailInput;
        pass = passwordInput;
    }
    
    public boolean signUp(String userType, String userID, String userName, String userEmail, String userPass) throws NoSuchAlgorithmException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            SQLcon = DriverManager.getConnection(dataconn, username, password);
            Encryptor encryptor = new Encryptor();
            String passwordHash = encryptor.encryptString(userPass);
            
            if(userType.equals("Lecturer")){
                pst = SQLcon.prepareStatement("insert into lecturer (LecturerID, LecturerName, LecturerEmail, LecturerPassword)" + "values (?, ?, ?, ?)");
                pst.setString(1, userID);
                pst.setString(2, userName);
                pst.setString(3, userEmail);
                pst.setString(4, passwordHash);
                pst.executeUpdate();
                pst.close();
            }
            
            else{
                pst = SQLcon.prepareStatement("insert into student (StudentID, StudentName, StudentEmail, StudentPassword)" + "values (?, ?, ?, ?)");
                pst.setString(1, userID);
                pst.setString(2, userName);
                pst.setString(3, userEmail);
                pst.setString(4, passwordHash);
                pst.executeUpdate();
                pst.close();
            }
        }catch(ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(Rekap_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        return false;
    }
    
}

class userStudent extends userLogin{
    
    private static final String username = "root";
    private static final String password = ""; //ganti pake pass mu dewe
    private static final String dataconn = "jdbc:mysql://localhost:3306/univdb";
    
    Connection SQLcon = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    int q, i;
    
    public userStudent(String usernameInput, String fullNameInput, String emailInput, String passwordInput) {
        super(usernameInput, fullNameInput, emailInput, passwordInput);
    }
    
    public boolean login() throws NoSuchAlgorithmException {
        //connect sql -> check user sama password
        String inputUsername = this.email;
        
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                SQLcon = DriverManager.getConnection(dataconn, username, password);
                Encryptor encryptor = new Encryptor();
                String inputPasswordHash = encryptor.encryptString(this.pass);
                
                pst = SQLcon.prepareStatement("Select * from Student where StudentEmail = ? and StudentPassword = ?");
                pst.setString(1, this.email);
                pst.setString(2, inputPasswordHash);
            
                rs = pst.executeQuery();
                ResultSetMetaData stData = rs.getMetaData();
                q = stData.getColumnCount();
                
                if (rs.next()) {
                    String emailStudent = rs.getString("StudentEmail");
                    String passwordStudent = rs.getString("StudentPassword");
                    String fullNameStudent = rs.getString("StudentName");
                    String idStudent = rs.getString("StudentID");
                    userInfo userInfo = new userInfo();
                    userInfo.setUserInfo(idStudent, fullNameStudent, emailStudent);
                    if(emailStudent.equalsIgnoreCase(inputUsername) && passwordStudent.equalsIgnoreCase(inputPasswordHash)){
                        return true;
                    }
                }
            }catch(ClassNotFoundException | SQLException ex){
                java.util.logging.Logger.getLogger(Rekap_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
            }
            return false;
    }
}

class userLecturer extends userLogin{
    
    private static final String username = "root";
    private static final String password = ""; //ganti pake pass mu dewe
    private static final String dataconn = "jdbc:mysql://localhost:3306/univdb";
    
    Connection SQLcon = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    int q, i;
    
    public userLecturer(String usernameInput, String fullNameInput, String emailInput, String passwordInput) {
        super(usernameInput, fullNameInput, emailInput, passwordInput);
    }
    
    public boolean login() throws NoSuchAlgorithmException {
        //connect sql -> check user sama password
        String inputUsername = this.email;
        
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                SQLcon = DriverManager.getConnection(dataconn, username, password);
                Encryptor encryptor = new Encryptor();
                String inputPasswordHash = encryptor.encryptString(this.pass);
                
                pst = SQLcon.prepareStatement("Select * from Lecturer where LecturerEmail = ? and LecturerPassword = ?");
                pst.setString(1, this.email);
                pst.setString(2, inputPasswordHash);
            
                rs = pst.executeQuery();
                ResultSetMetaData stData = rs.getMetaData();
                q = stData.getColumnCount();
                
                if (rs.next()) {
                    String emailLecturer = rs.getString("LecturerEmail");
                    String passwordLecturer = rs.getString("LecturerPassword");
                    
                    
                    String fullNameLecturer = rs.getString("LecturerName");
                    String idLecturer = rs.getString("LecturerID");
                    userInfo userInfo = new userInfo();
                    userInfo.setUserInfo(idLecturer, fullNameLecturer, emailLecturer);
                    if(emailLecturer.equalsIgnoreCase(inputUsername) && passwordLecturer.equalsIgnoreCase(inputPasswordHash)){
                        return true;
                    }
                }
            }catch(ClassNotFoundException | SQLException ex){
                java.util.logging.Logger.getLogger(Rekap_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
            }
            return false;
    }
}
