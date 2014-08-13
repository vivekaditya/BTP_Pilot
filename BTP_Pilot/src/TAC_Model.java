import interfaces.IRougeSummaryModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;  
import java.util.Map;
import java.util.Set;

import common.RougeSummaryModel;
import common.ScoreType;
import rouge.RougeN;
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
		BufferedReader br = new BufferedReader(new FileReader("TAC_2014_BiomedSumm_Training_Data/data/D1401_TRAIN/Annotation/D1401_TRAIN.A.ann.txt"));
		String[] Annotator_line ;
		String line = br.readLine();
  
		 
		while(line!=null)
		{
			Annotator_line = line.split("\\|");
	 		int i;
	 		System.out.println();
//	 		System.out.println(Annotator_line[7].split(":")[1]);
//	 		System.out.println(Annotator_line[9].split(":")[1]);

	 		for (i=0;i<Annotator_line.length;i++)
	 			{
	 				System.out.println((Annotator_line[i].split(":")[0])+"\t"+ Annotator_line[i].split(":")[1]);			
	 			} 
	 		String empty = br.readLine();
	 		line = br.readLine();
		}
		System.out.println("End");
		br.close();
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
