package formato.middleton;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
         }catch(Exception ex){
            System.out.println("Error loading jdbc driver."); 
            System.out.println(ex);
         }
         
    }
}