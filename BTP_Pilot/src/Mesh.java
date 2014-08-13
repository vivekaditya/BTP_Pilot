import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Mesh {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/aditya/Downloads/d2014.bin"));
		PrintWriter pw = new PrintWriter("Mesh.txt");
		String line = br.readLine();
		while (line!=null) 
		{
			if(line.contains("MH ="))
			{
				line = line.replaceAll("MH","").replaceAll("=","").trim().replaceAll(","," ").replaceAll(" +", " ") ;
				String[] terms = line.split(" "); 
				int i =0;
				while (i < terms.length) {
					pw.println(terms[i]);
					i++;
				}					
			}
			if(line.contains("MH ="))
			{
				
			}
			
			
			line = br.readLine();
		}
		
	}

}
