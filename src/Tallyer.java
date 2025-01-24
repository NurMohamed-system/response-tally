import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * The Tallyer class provides functionality for reading ID and topic pairs from user input,
 * and tallying the number of occurrences of each topic.
 */
public class Tallyer {

    /**
     * The main method serves as the entry point for the program. It reads pairs of IDs and topics
     * from standard input, stores them in lists, and then calculates the number of occurrences
     * of each topic. The IDs and topics are guaranteed to not include internal whitespace.
     *
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> ids = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        topics.add("maps");
        topics.add("lists");
        topics.add("loops");
        topics.add("arrays");
        topics.add("compound");
        topics.add("maps");
        topics.add("arrays");
        System.out.println(tallyTopics(topics));

        List<String> ids1 = new ArrayList<>();
        List<String> topics1 = new ArrayList<>();
        ids1.add("11");
        ids1.add("12");
        ids1.add("13");
        ids1.add("11");

        topics1.add("maps");
        topics1.add("loops");
        topics1.add("arrays");
        topics1.add("arrays");
        //System.out.println(tallyTopics(topics));
        System.out.println(tallyTopicsFiltered(ids1, topics1));

        
        // Reading input for IDs and topics
        // Assumes file is well formed into pairs
        while (input.hasNext()) {
            ids.add(input.next());
            topics.add(input.next());
        }
        input.close();
        
        // Wave 1
        Map<String, Integer> topicCounts = tallyTopics(topics);
        System.out.println("Here are how many times each topic appears (unfiltered):");
        System.out.println(topicCounts);

        // Wave 2
        Map<String, Integer> topicCountsFiltered = tallyTopicsFiltered(ids, topics);
        System.out.println("Here are how many times each topic appears (filtered):");
        System.out.println(topicCountsFiltered);
    }

    /**
     * Tally the occurrences of each topic from the provided list of topics.
     * This method takes a list of topics. It returns a Map where the keys are topics
     * and the values are how many times they appear in the input.
     *
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopics(List<String> topics) {
        // WAVE 
        // TODO: Implement this metho
            Map<String, Integer> topicMap = new TreeMap<>();
            for(int i =0; i <topics.size(); i++ ) {
                if(topicMap.containsKey(topics.get(i))) {
                    //get the value and add 1 to it
                    topicMap.put(topics.get(i), topicMap.get(topics.get(i)) + 1);
                }
                else {
                    topicMap.put(topics.get(i), 1);

                }
            }
        return topicMap;
    }

    /**
     * Tally the occurrences of valid votes for each topic from the provided lists of IDs and topics.
     * 
     * The lists are of equal length and are aligned: the id at index zero cast a vote for
     * the topic at endex 0, the id at index 1 cast a vote for the topic at index 1, etc.
     * It returns a map where each topic is associated with the number of times it appears in the input.
     * However, any user who did not enter exactly 2 topics should not have their votes counted.
     *
     * @param ids a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopicsFiltered(List<String> ids, List<String> topics) {
        // WAVE 2
       // TODO: Implement this method
          Map<String, Integer> tallyTopicsFiltered = new TreeMap<>();
            for(int i = 0; i <topics.size(); i++ ) {
                if(tallyTopicsFiltered.containsKey(topics.get(i))) {
                    //get the value and add 1 to it
                    tallyTopicsFiltered.put(topics.get(i), tallyTopicsFiltered.get(topics.get(i)) + 1);
                }
                else {
                    tallyTopicsFiltered.put(topics.get(i), 1);

                }
        }
    return tallyTopicsFiltered;

    }
}
