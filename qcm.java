/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qcm;

import static com.google.common.cache.CacheBuilder.from;
import java.awt.List;
import static java.lang.ProcessBuilder.Redirect.from;
import static java.lang.management.MemoryNotificationInfo.from;

/**
 *
 * @author NEONET
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
public class qcm {
    
    
    public ArrayList<cellule> matiere() throws Exception{
        String dbURL = "jdbc:derby://localhost:1527/wassim;create=true;user=wassim;password=wassim";
        ArrayList<cellule> a=new ArrayList<>();
        try {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    try {
         String sql = "SELECT * from WASSIM.MATIERE";
    
    Connection conn = DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
    ResultSet r = stmt.executeQuery(sql);
    int[] age = null;
    int indice = 0;
    String dateNaissance = null;
    
    
    while(r.next())
    {
        cellule c=new cellule();
        c.id=r.getInt("IDMATIERE");
        c.mat=r.getString("MATIERE");
        c.fil=r.getString("FILIERE");
        c.niv=r.getString("NIVEAU");
        a.add(c);
    
       
        
    }
    
    }
    catch (SQLException se) {
System.out.println("SqlException: " + se.getMessage());
se.printStackTrace(System.out);
}
}
catch (ClassNotFoundException e) {
System.out.println("ClassNotFound: " + e.getMessage());
}
    return a;
   
}
    
    
    
    public void test(int x) throws Exception{
        String dbURL = "jdbc:derby://localhost:1527/wassim;create=true;user=wassim;password=wassim";
        try {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    try {
         String sql = "SELECT * from WASSIM.TEST where IDMATIERE="+x;
    
    Connection conn = DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
    ResultSet r = stmt.executeQuery(sql);
    cellule c=new cellule();
    while(r.next())
    {
        
        System.out.println(r.getInt("IDTEST") +"\t" + r.getString("AUTEUR")+"\t" + r.getString("DATE"));
       
        
    }
    }
    catch (SQLException se) {
System.out.println("SqlException: " + se.getMessage());
se.printStackTrace(System.out);
}
}
catch (ClassNotFoundException e) {
System.out.println("ClassNotFound: " + e.getMessage());
}
    
  }
    public void question(int x) throws Exception{
        String dbURL = "jdbc:derby://localhost:1527/wassim;create=true;user=wassim;password=wassim";
               try {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    try {
         
         String sql = "SELECT * from WASSIM.QUESTION where IDTEST="+x;
    
    Connection conn = DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
    ResultSet r = stmt.executeQuery(sql);
    cellule c=new cellule();
    while(r.next())
    {
        
        System.out.println(r.getInt("IDQUESTION") +"\t" + r.getString("QUESTION")+"\t" + r.getString("REP1")+"\t" + r.getString("REP2")+"\t" + r.getString("REP3")+"\t" + r.getString("REP4")+ r.getString("REP"));
           }
    }
    catch (SQLException se) {
System.out.println("SqlException: " + se.getMessage());
se.printStackTrace(System.out);
}
}
catch (ClassNotFoundException e) {
System.out.println("ClassNotFound: " + e.getMessage());
}
}


public static void main(String[] args) throws Exception{
qcm q=new qcm();
ArrayList<cellule> a=new ArrayList<>();

q.test(1);
q.question(1);
a=q.matiere();
for (cellule c : a)
{
	
	System.out.println(c.id+"\t"+c.mat+"\t"+c.fil);
        }
}
} //class