import java.io.IOException; 
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
 
public class TagText {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
 
        // Initialize the tagger
    	MaxentTagger tagger = new MaxentTagger("/home/aditya/Downloads/stanford-postagger-2011-04-20/models/left3words-wsj-0-18.tagger");
 
        // The sample string
        String sample = "This is a sample text";
 
        // The tagged string
        String tagged = tagger.tagString(sample);
 
        // Output the result
        System.out.println(tagged);
    }
}