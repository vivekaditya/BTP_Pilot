import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
// sort Mesh.txt | uniq > meshterms.txt

public class Mesh {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/aditya/Downloads/d2014.bin"));
		PrintWriter pw = new PrintWriter("Mesh.txt");
		String line = br.readLine();
		String [] stopwords = {"a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just","least","let","like","likely","may","me","might","most","must","my","neither","no","nor","not","of","off","often","on","only","or","other","our","own","rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too","twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"};
		Arrays.sort(stopwords);
		int i,j ;
		while (line!=null) 
		{
			if(line.contains("MH ="))
			{
				line = line.replaceAll("MH","").replaceAll("=","").trim().replaceAll(","," ").replaceAll(" +", " ") ;
				String[] terms = line.split(" "); 
				i =0;
				while (i < terms.length) 
				{
					if(Arrays.binarySearch(stopwords,terms[i])<0) 
					{
						pw.println(terms[i]);
					}
					i++;
				}					
			}
			if(line.contains("ENTRY ="))
			{
				if (line.contains("|")) 
				{
					line = line.split("=")[1].split("\\|")[0].trim() ;
					String[] terms = line.split(","); 
					i =0;
					while (i < terms.length) 
					{
						
						String[] term = terms[i].trim().split(" "); 
						j =0;
						while (j < term.length) 
						{
							if(Arrays.binarySearch(stopwords,term[j])<0) 
							{ 
								pw.println(term[j].trim());								
							}
							j++;
						}
						i++;
					}
				}
				else 
				{
					line = line.split("=")[1] ;
					String[] terms = line.split(","); 
					i =0;
					while (i < terms.length) 
					{
						
						String[] term = terms[i].trim().split(" "); 
						j =0;
						while (j < term.length) 
						{
							if(Arrays.binarySearch(stopwords,term[j])<0) 
							{ 
								pw.println(term[j].trim());								
							}
							j++;
						}
						i++;
					}
				}
			}					
			line = br.readLine();
		}
		br.close();
		pw.close();
	}

}
