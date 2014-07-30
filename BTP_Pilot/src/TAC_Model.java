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
		RougeN rouge = null;
		RougeSummaryModel testSummary1 = null;
		RougeSummaryModel refSummary_1_1 = null;
		RougeSummaryModel refSummary_1_2 = null;
		RougeSummaryModel testSummary2 = null;
		RougeSummaryModel refSummary_2_1 = null;
		RougeSummaryModel refSummary_2_2 = null;
		HashSet<IRougeSummaryModel> refSummaries2 = null;
		HashSet<IRougeSummaryModel> refSummaries1 = null;
		// init document 
		testSummary1 = new RougeSummaryModel(new File("peer"));
		testSummary1.setTitle("Weighing 8 pounds and standing 13 inches tall, Oscar was created by Metro-Goldwyn-Mayer studios art director Cedric Gibbons, who went on to win 11 of the trophies.")
				.addSentence("Oscar, manufactured by the R.S. Owens Co., Chicago, is made of Britannia metal, copper plate, nickel plate and gold plate.")
				.addSentence("According to the Academy of Motion Pictures Arts and Sciences, the only engraving mistake was in 1938 when the best actor trophy given to Spencer Tracy for \"Boy\"s Town\" read: \"Best Actor: Dick Tracy.\"")
				.addSentence("\"Ben-Hur\" in 1959 was the most-awarded film with 11, and Walt Disney was the most-awarded person with 32.");

		// init gs 
		refSummary_1_1 = new RougeSummaryModel(new File("model.1"));
		refSummary_1_1.setTitle("The Oscar, created 60 years ago by MGM art director Cedric Gibbons, weighs 8 pounds and stands 13 inches tall.")
				  .addSentence("It is made of Britannia metal and plated with copper, nickel, and gold. From 1942-44 it was made of plaster. ")
				  .addSentence("It is manufactured by Chicago's R.S. Owens Co. 1,816 have been produced so far.")
				  .addSentence("The only engraving mistake was \"Dick Tracy\" instead of \"Spencer Tracy\" in 1938.")
				  .addSentence("The Academy of Motion Picture Arts and Sciences reserves the first right to buy an Oscar from anyone.")
				  .addSentence("\"All About Eve\" is the most-nominated film (14), Ben Hur the most awarded (11), and Walt Disney the most- awarded person (32).");

		refSummary_1_2 = new RougeSummaryModel(new File("model.2"));
		refSummary_1_2.setTitle("MGM studios art director Cedric Gibbons created Oscar, the Academy of Motion Pictures Arts and Sciences famous award, 60 years ago.")
				  .addSentence("Manufactured by the R.S. Owens Co., the gold plated metal statue weighs 8 pounds and stands 13 inches tall.")
				  .addSentence("According to Academy spokesman Bob Werden, the Academy holds all rights on the statue and reserves the right to buy back an Oscar before it is pawned.")
				  .addSentence("\"All About Eve\" (1950) is the  most-nominated film (14).")
				  .addSentence("\"Ben-Hur\" (1959) is the most-awarded film (11).")
				  .addSentence("Walt Disney was the most-awarded person (32).");

		refSummaries1 = new HashSet<IRougeSummaryModel>();
		refSummaries1.add(refSummary_1_1);
		refSummaries1.add(refSummary_1_2);

		testSummary2 = new RougeSummaryModel(new File("peer"));
		testSummary2.setTitle("I was really skating well this week.")
				.addSentence("But I tried.")
				.addSentence("Combined with a fourth in the compulsory figures and a third-place finish in the short program earlier in the week, the performance put Manley in second place.")
				.addSentence("By contrast, Manley had the sellout crowd at the Olympic Saddledome enraptured.")
				.addSentence("\"Thomas\" bronze was the third figure skating medal here for the United States.")
				.addSentence("In addition to the three figure skating medals, the U.S. team had three speed-skating medals: one each gold, silver and bronze.")
				.addSentence("She won the gold in the 500 and the bronze in the 1,000 meters.");

		// init gs 
		refSummary_2_1 = new RougeSummaryModel(new File("model.1"));
		refSummary_2_1.setTitle("The United States' Debi Thomas' dream of Olympic gold crumbled Saturday as East Germany's Katarina Witt won her second straight Olympic championship and Canadian Elizabeth Manley took home the silver.")
				  .addSentence("Thomas won the bronze despite three faulty landings.")
				  .addSentence("Thomas, of San Jose, Calif., the first black to win a U.S. figure skating crown and the 1986 world champion, skated poorly Saturday after doing well earlier in the games.")
				  .addSentence("Brian Boitano of the U.S. won the men's figure skating crown.")
				  .addSentence("In the pairs competition, a bronze went to a U.S. team.")
				  .addSentence("The U.S. also captured three speed-skating medals, a gold, silver and bronze.");

		refSummary_2_2 = new RougeSummaryModel(new File("model.2"));
		refSummary_2_2.setTitle("Debi Thomas, the US hope for a figure skating gold medal in the 1988 Winter Olympics, was disappointed when the Gold went to Germany's Katarina Witt and the Silver to Canadian Elizabeth Manley.")
				  .addSentence("Manley was loudly cheered by fellow Canadians throughout her performance.")
				  .addSentence("Thomas, who was a US and 1986 world champion, was awarded the Bronze medal.")
				  .addSentence("Other US figure skating medal winners Brian Boitano with the Gold and Jill Watson and Peter Oppegard with the Bronze in pairs.")
				  .addSentence("US speed skaters won gold, silver, and bronze with Bonnie Blair taking both a gold and a Bronze.");
		refSummaries2 = new HashSet<IRougeSummaryModel>();
		refSummaries2.add(refSummary_2_1);
		refSummaries2.add(refSummary_2_2);
//		while(line!=null)
//		{
			Annotator_line = line.split("\\|");
//			System.out.println(Annotator_line.length);
	 		int i;
	 		System.out.println();
//	 		System.out.println(Annotator_line[7].split(":")[1]);
//	 		System.out.println(Annotator_line[9].split(":")[1]);
	 		String tagged = tagger.tagString(Annotator_line[7].split(":")[1]);	 
	        System.out.println(tagged);
	        Set<IRougeSummaryModel> s = new HashSet<IRougeSummaryModel>();
	        s.add(testSummary1);
	        rouge = new RougeN(testSummary1, s, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 'A', 0.5);
	        Map<ScoreType, Double> results = rouge.computeNGramScore();
	        
	        System.out.println(results.get(ScoreType.R)+" "+ results.get(ScoreType.P)+" "+ results.get(ScoreType.F));
//	 		for (i=0;i<Annotator_line.length;i++)
//	 			{
//	 				System.out.println((Annotator_line[i].split(":")[0])+"\t"+ Annotator_line[i].split(":")[1]);			
//	 			} 
	 		String empty = br.readLine();
	 		line = br.readLine();
//		}
		System.out.println("End"); 
	} 
}  
