import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;  

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class TAC_Model {

	/**
	 * @param args
	 * @throws IOException  
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		System.out.println("Start");
		BufferedReader br = new BufferedReader(new FileReader("TAC_2014_BiomedSumm_Training_Data/data/D1401_TRAIN/Annotation/D1401_TRAIN.A.ann.txt"));
		String[] Annotator_line ;
		String line = br.readLine();
		MaxentTagger tagger = new MaxentTagger("models/left3words-wsj-0-18.tagger");
//	 
//	        // The sample string
//	        String sample = "This is a sample text";
//	 
//	        // The tagged string
//	        String tagged = tagger.tagString(sample);
//	 
//	        // Output the result
//	        System.out.println(tagged);
		while(line!=null)
		{
			Annotator_line = line.split("\\|");
//			System.out.println(Annotator_line.length);
	 		int i;
	 		System.out.println();
//	 		System.out.println(Annotator_line[7].split(":")[1]);
//	 		System.out.println(Annotator_line[9].split(":")[1]);
	 		String tagged = tagger.tagString(Annotator_line[7].split(":")[1]);	 
	        System.out.println(tagged);
//	 		for (i=0;i<Annotator_line.length;i++)
//	 			{
//	 				System.out.println((Annotator_line[i].split(":")[0])+"\t"+ Annotator_line[i].split(":")[1]);			
//	 			} 
	 		String empty = br.readLine();
	 		line = br.readLine();
		}
		System.out.println("End"); 
	} 
}  
