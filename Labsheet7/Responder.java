/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Responder
{  
    private HashMap<String, String> plannedResponses = new HashMap<String, String>();
    private HashMap<String, Integer> issuesCounter = new HashMap<String, Integer>();
    private ArrayList<String> randomResponses = new ArrayList<String>();
    private int numResponses;
    private Random randomGenerator = new Random();

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        randomResponses.add("I appreciate your patience as we work through this issue together. Rest assured, I'm here to help you until it's resolved.");
        randomResponses.add("If the issue persists, I may need to escalate this to our advanced support team. They have the expertise to handle more complex issues.");
        randomResponses.add("I apologize for any inconvenience this issue may have caused. Let's work together to get it resolved.");
        numResponses = randomResponses.size();

        plannedResponses.put("slow", "This is usually related to hardware. Upgrading your processor should solve all performance problems. Do you have a problem with our software?");
        plannedResponses.put("fast", "Thank you so much for your positive feedback! We're thrilled to hear that you're enjoying our software. If you have any suggestions or if there's anything specific you love about it, we'd love to hear more!");
        plannedResponses.put("good", "We're delighted that you find our software valuable! Your positive feedback validates the hard work of our team. If there's anything specific you appreciate or any features you'd like to see in the future, let us know!");
        plannedResponses.put("improved", "We appreciate your constructive feedback. Rest assured, we are dedicated to continuous improvement. Your suggestions will be considered as we work on making our software even better. If you have any more details or specific ideas, we'd love to hear them.");
        
        for (String keyword: plannedResponses.keySet())
        {
            issuesCounter.put(keyword, 0);
        }
    
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String input)
    {  
        // Check if any keywords were mentioned in the input, returning a planned response if one has been found
        for (String keyword: this.plannedResponses.keySet())
            {
                if (input.contentEquals(keyword.toLowerCase()))
                    {      
                        issuesCounter.put(keyword, issuesCounter.get(keyword) + 1); // Update count for this issue
                        return plannedResponses.get(keyword);
                    }
            }
        
        // Generate random response
        int randomIndex = randomGenerator.nextInt(numResponses);
        return randomResponses.get(randomIndex);
    }
}
