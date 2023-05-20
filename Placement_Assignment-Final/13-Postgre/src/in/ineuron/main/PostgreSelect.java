package in.ineuron.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgreSelect {
	

	private static String url = "jdbc:postgresql:///ineuronDB";
	private static String user = "root";
	private static String password = "root@123";
	
	public static void main(String[] args) {
		
		 String inputFile = "student.txt"; // Path to input file
	        String sql = "INSERT INTO student (sname, saddress,sage) VALUES (?, ?, ?)";

	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	            String line;
	            int count = 0;

	            while ((line = reader.readLine()) != null) {
	                String[] data = line.split(",");
	                stmt.setString(1, data[0]);
	                stmt.setString(2, data[1]);
	                stmt.setInt(3, Integer.parseInt(data[2]));
	                stmt.addBatch();
	                count++;
	                if (count % 1000 == 0) {
	                    // Execute batch every 1000 records
	                    stmt.executeBatch();
	                    stmt.clearBatch();
	                }
	            }

	            // Execute any remaining records in the batch
	            stmt.executeBatch();
	            System.out.println("Batch update completed successfully.");
	        } catch (SQLException | NumberFormatException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
