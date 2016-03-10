package com.xichen;


/**
 * modified by diann on 3/9/2016.
 */
import java.util.*;

public class NDCG {

    private NDCG() {}

    /**
     * Compute the normalized discounted cumulative gain (NDCG) of a list of ranked items.
     * @param ranked_items a list of ranked item IDs, the highest-ranking item first
     * @param correct_items a collection of positive/correct item IDs
     * @return the NDCG for the given data
     */
    public static double compute(HashMap<String, Double> ranked_items ,HashMap<String, Double> correct_items) {

            HashMap<String, Double> our_items = new HashMap<>();
            HashMap<String, Double> google_items = new HashMap<>();

            for (String o : ranked_items.keySet()) {
                our_items.put(o,ranked_items.get(o));
            }
            for (String g : correct_items.keySet()) {
                google_items.put(g,correct_items.get(g));
            }


            double dcg   = 0;
            Double original_rank;


            for (final String key : our_items.keySet()) {
                if (google_items.containsKey(key)) {
                    original_rank = our_items.get(key);
                    if (original_rank == 1) {
                        dcg += google_items.get(key);
                        our_items.put(key, google_items.get(key));
                    } else {
                        our_items.put(key, google_items.get(key)/Math.log(original_rank));
                        dcg += google_items.get(key)/Math.log(original_rank);
                    }

                } else {
                    original_rank = 0.0;
                    our_items.put(key,original_rank);
                }
            }
            Set<Map.Entry<String, Double>> set = our_items.entrySet();
            for (Map.Entry<String, Double> me : set) {
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
            System.out.println("dcg is "+dcg);
            return dcg / 8.69;
            }

                public static void main(String[] args) {
                    HashMap<String,Double> ourResult = new HashMap<>();
                    ourResult.put("http://mondego.ics.uci.edu/", 1.0);
                    ourResult.put("https://mailman.ics.uci.edu/mailman/listinfo/mondego",2.0);
                    ourResult.put("http://www.ics.uci.edu/~lopes/",3.0);
                    ourResult.put("https://mailman.ics.uci.edu/mailman/listinfo/",4.0);
                    ourResult.put("http://www.informatics.uci.edu/research/labs-centers/",5.0);

                    HashMap<String,Double> googleResult = new HashMap<>();
                    googleResult.put("http://mondego.ics.uci.edu/", 3.0);
                    googleResult.put("http://nile.ics.uci.edu", 3.0);
                    googleResult.put("http://mondego.ics.uci.edu/projects/clonedetection/", 2.0);
                    googleResult.put("http://www.ics.uci.edu/~lopes/", 2.0);
                    googleResult.put("http://sdcl.ics.uci.edu/2012/05/calico-for-the-mondego-group/",1.0);

                    Double ndcgVal = NDCG.compute(ourResult, googleResult);
                    System.out.println("NDCG Value: " + ndcgVal);
                     }

}