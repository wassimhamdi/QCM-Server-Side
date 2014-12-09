/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qcm;

import com.sun.rowset.WebRowSetImpl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author NEONET
 */
@WebService(serviceName = "myws")
public class myws {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     *
     * @param txt
     * @return 
     * @throws Exception
     */
    @WebMethod
    public String[] matiere() throws Exception{
        String dbURL = "jdbc:derby://localhost:1527/wassim;create=true;user=wassim;password=wassim";
        
        String[] h=new String[10];
        try {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    try {
         String sql = "SELECT * from WASSIM.MATIERE";
    
    Connection conn = DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
    ResultSet r = stmt.executeQuery(sql);
    String dateNaissance = null;
    
    int i=0;
    
    while(r.next())
    {
        
        
        h[i]=r.getInt("IDMATIERE")+"  "+r.getString("MATIERE")+r.getString("NIVEAU");
        i++;
     }
    h[i]="";
   }
    
    catch (SQLException se) {
System.out.println("SqlException: " + se.getMessage());
se.printStackTrace(System.out);
}
}
catch (ClassNotFoundException e) {
System.out.println("ClassNotFound: " + e.getMessage());
}
 
         return h;
   
}
        @WebMethod(operationName = "rep")
        public String[] rep(@WebParam(name = "nam") int x) throws Exception{
        String dbURL = "jdbc:derby://localhost:1527/wassim;create=true;user=wassim;password=wassim";
        String[] h= new String[10];
               try {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    try {
         
         String sql = "SELECT * from WASSIM.QUESTION where IDTEST="+x;
    
    Connection conn = DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
    ResultSet r = stmt.executeQuery(sql);
    int i=0;
    while(r.next())
    {        
                h[i]=r.getString("REP");
                i++;
           }
    h[i]="";
    }
    catch (SQLException se) {
System.out.println("SqlException: " + se.getMessage());
se.printStackTrace(System.out);
}
}
catch (ClassNotFoundException e) {
System.out.println("ClassNotFound: " + e.getMessage());
}
               return h;
}
        @WebMethod(operationName = "question")
        public String[] question(@WebParam(name = "nam") int x) throws Exception{
        String dbURL = "jdbc:derby://localhost:1527/wassim;create=true;user=wassim;password=wassim";
        String[] h= new String[10];
               try {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    try {
         
         String sql = "SELECT * from WASSIM.QUESTION where IDTEST="+x;
    
    Connection conn = DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
    ResultSet r = stmt.executeQuery(sql);
    int i=0;
    while(r.next())
    {        
                h[i]=r.getString("QUESTION")+"\n\n"+"A. "+r.getString("REP1")+"\n\nB. "+r.getString("REP2")+"\n\nC. "+r.getString("REP3")+"\n\nD. "+r.getString("REP4")+"\n\n\n";
                i++;
           }
    h[i]="";
    }
    catch (SQLException se) {
System.out.println("SqlException: " + se.getMessage());
se.printStackTrace(System.out);
}
}
catch (ClassNotFoundException e) {
System.out.println("ClassNotFound: " + e.getMessage());
}
               return h;
}
        
        @WebMethod(operationName = "test")
         public String[] test(@WebParam(name = "id") int x) throws Exception{
        String dbURL = "jdbc:derby://localhost:1527/wassim;create=true;user=wassim;password=wassim";
        String[] h=new String[10];
        try {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    try {
         String sql = "SELECT * from WASSIM.TEST where IDMATIERE="+x;
    
    Connection conn = DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
    ResultSet r = stmt.executeQuery(sql);
    int i=0;
    while(r.next())
    {
        
        System.out.println(r.getInt("IDTEST") +"\t" + r.getString("AUTEUR")+"\t" + r.getString("DATE"));
       h[i]=r.getInt("IDTEST")+" -"+r.getString("AUTEUR")+r.getString("DATE");
       i++;
        
    }
    h[i]="";
    }
    catch (SQLException se) {
System.out.println("SqlException: " + se.getMessage());
se.printStackTrace(System.out);
}
}
catch (ClassNotFoundException e) {
System.out.println("ClassNotFound: " + e.getMessage());
}
   return h; 
  }
    
}
