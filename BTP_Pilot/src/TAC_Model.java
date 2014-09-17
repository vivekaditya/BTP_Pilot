import interfaces.IRougeSummaryModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;  
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import common.RougeSummaryModel;
import common.ScoreType;
import rouge.RougeN;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class TAC_Model {
	/**
	 * @param args
	 * @throws IOException  
	 * @throws ClassNotFoundException 
	 *   	ROUGE-N: N-gram based co occurrence statistics
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {	
		System.out.println("Start");
		int id_ = 1 ;
		String id = "0" + id_;
		while(id_<10)
		{
			BufferedReader br = new BufferedReader(new FileReader("TAC_2014_BiomedSumm_Training_Data_V1.1/data/D14"+id+"_TRAIN/Annotation/D14"+id+"_TRAIN.B.ann.txt"));
			BufferedReader br_mesh = new BufferedReader(new FileReader("meshterms.txt"));
	//		BufferedReader ref = new BufferedReader(new FileReader("TAC_2014_BiomedSumm_Training_Data_V1.1/data/D14"+id+"_TRAIN/Documents_Text/Voorhoeve.txt"));
			String[] Annotator_line ;
			String line = br.readLine();
			String mesh_terms = br_mesh.readLine();
			Set<String> mesh_set = new HashSet<String>();
			String [] stopwords = {"a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just","least","let","like","likely","may","me","might","most","must","my","neither","no","nor","not","of","off","often","on","only","or","other","our","own","rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too","twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"};
			Set<String> stopwordset = new HashSet<String>(Arrays.asList(stopwords));
			while (mesh_terms != null) 
			{
				mesh_set.add(mesh_terms.toLowerCase());
				mesh_terms = br_mesh.readLine();
			}		
	//		System.out.println(mesh_set.contains("miRNA"));
	//		while(line!=null)
	//		{
				Annotator_line = line.split("\\|");
		 		int i;
		 		System.out.println();	 		
				Path ref = Paths.get("TAC_2014_BiomedSumm_Training_Data_V1.1/data/D14"+id+"_TRAIN/Documents_Text",Annotator_line[2].split(":")[1].trim());
		 		System.out.println(Annotator_line[7].split(":")[1]);
		 		System.out.println(Annotator_line[9].split(":")[1]);	 		
		 		Set<String> mySet = new HashSet<String>(Arrays.asList(Annotator_line[7].split(":")[1].toLowerCase().split(" ")));
		 		Set<String> intersection = new HashSet<String>(mySet);
		 		intersection.removeAll(stopwordset);
		 		intersection.retainAll(mesh_set);	
		 		System.out.println(Annotator_line[7].split(":")[1].toLowerCase()); 		
	//	 		System.out.println(mySet.toString());
		 		System.out.println(intersection.size());
		 		System.out.println();
		 		Set<String> mySet2 = new HashSet<String>(Arrays.asList(Annotator_line[9].split(":")[1].toLowerCase().split(" ")));
		 		 Set<String> intersection2 = new HashSet<String>(mySet2);
		 		 intersection2.removeAll(stopwordset);		 		
		 		 intersection2.retainAll(intersection);	
		 		 if (intersection2.size()>0) 
		 		 {
			 		 System.out.println(); 		
//			 		 System.out.println(Annotator_line[9].split(":")[1].toLowerCase());
			 		 System.out.println(intersection2.size());
			 		 System.out.println();			 						
				}
		 		List<String> lines = Files.readAllLines(ref, StandardCharsets.UTF_8);
		 		int index=0;
	//	 		System.out.println(lines.get(0));
	//	 		System.out.println();
	//	 		DocumentPreprocessor dp = new DocumentPreprocessor("TAC_2014_BiomedSumm_Training_Data_V1.1/data/D1401_TRAIN/Documents_Text/Voorhoeve.txt");
	//			
	//	 		for (List sentence : dp) 
	//			 {
				 		System.out.println(id_); 		
		 				while (index<lines.size()) {
		 					line=lines.get(index);
			 				Set<String> mySet1 = new HashSet<String>(Arrays.asList( line.toLowerCase().split(" ")));
					 		 Set<String> intersection1 = new HashSet<String>(mySet1);
					 		 intersection1.removeAll(stopwordset);		 		
					 		 intersection1.retainAll(intersection);	
					 		 if (intersection1.size()>=3) 
					 		 {
						 		 System.out.println(); 		
						 		 System.out.println( line.toLowerCase());
						 		 System.out.println(intersection1.size());
							}
					 		 index++;
						}
						  index=0;
		 		
	//	 		for (i=0;i<Annotator_line.length;i++)
	//	 			{
	//	 				System.out.println((Annotator_line[i].split(":")[0])+"\t"+ Annotator_line[i].split(":")[1]);			
	//	 			} 
	//	 		String empty = br.readLine();
	//	 		line = br.readLine();
	//		}
			System.out.println("End");
			br.close();
			id_++;
			id = "0" + id_;
		}
	} 
}  

//RougeN rouge = null;
//RougeSummaryModel testSummary1 = null;
//RougeSummaryModel refSummary_1_1 = null; 
//HashSet<IRougeSummaryModel> refSummaries1 = null;
//// init document 
//testSummary1 = new RougeSummaryModel(new File("peer"));
//
//// init gs 
//refSummary_1_1 = new RougeSummaryModel(new File("model"));
//
//refSummaries1 = new HashSet<IRougeSummaryModel>();
//refSummaries1.add(refSummary_1_1);
//testSummary1.setTitle(" ")
//.addSentence(Annotator_line[7].split(":")[1]);	
//	refSummary_1_1.setTitle(" ")
//  .addSentence(Annotator_line[9].split(":")[1]);
//rouge = new RougeN(testSummary1,refSummaries1, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 'A', 0.5);
//Map<ScoreType, Double> results = rouge.computeNGramScore();
//
//System.out.println(results.get(ScoreType.R)+" "+ results.get(ScoreType.P)+" "+ results.get(ScoreType.F));

//	MaxentTagger tagger = new MaxentTagger("models/left3words-wsj-0-18.tagger");
//
//    // The sample string
//    String sample = "This is a sample text";
//
//    // The tagged string
//    String tagged = tagger.tagString(sample);
//
//    // Output the result
//    System.out.println(tagged);
//	String tagged = tagger.tagString(Annotator_line[7].split(":")[1]);	 
//	System.out.println(tagged); 
