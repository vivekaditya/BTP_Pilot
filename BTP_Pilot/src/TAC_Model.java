import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List; 


public class TAC_Model {

	/**
	 * @param args
	 * @throws IOException 
	 * http://www.berouge.com/Pages/DownloadROUGE.aspx
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("Start");
		BufferedReader br = new BufferedReader(new FileReader("TAC_2014_BiomedSumm_Training_Data/data/D1401_TRAIN/Annotation/D1401_TRAIN.A.ann.txt"));
		String[] Annotator_line ;
		String line = br.readLine();
		while(line!=null)
		{
			Annotator_line = line.split("\\|");
//			System.out.println(Annotator_line.length);
	 		int i;
	 		System.out.println();
	 		System.out.println(Annotator_line[7].split(":")[1]);
//	 		for (i=0;i<Annotator_line.length;i++)
//	 			{
//	 				System.out.println((Annotator_line[i].split(":")[0])+"\t"+ Annotator_line[i].split(":")[1]);			
//	 			} 
	 		String empty = br.readLine();
	 		line = br.readLine();
		}
		System.out.println("End");
//		String serializedClassifier = "classifiers/ner-eng-ie.crf-3-all2008.ser.gz";
//		AbstractSequenceClassifier classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
//	    String s1 = "Good afternoon Rajat Raina, how are you today?";
//	    String s2 = "I go to school at Stanford University, which is located in California.";
//	    System.out.println(classifier.classifyToString(s1));
//	    System.out.println(classifier.classifyWithInlineXML(s2));
//	    System.out.println(classifier.classifyToString(s2, "xml", true));
	} 
}  
