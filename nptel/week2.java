package nptel;
import java.util.*;
//https://onlinecourses.nptel.ac.in/noc23_cs16/progassignment?name=134

/*
 * The Siruseri Singing Championship

    The Siruseri Singing Championship is going to start, and Lavanya wants to figure out the outcome before the tournament
    even begins! Looking at past tournaments, she realizes that the judges care only about the pitches that the singers can
    sing in, and so she devises a method through which she can accurately predict the outcome of a match between any two singers.

    She represents various pitches as integers and has assigned a lower limit and an upper limit for each singer,
    which corresponds to their vocal range. For any singer, the lower limit will always be less than the upper limit. 
    If a singer has lower limit L and upper limit U (L < U), it means that this particular singer can sing in all the 
    pitches between L and U, that is they can sing in the pitches {L, L+1, L+2, …, U}.

    The lower bounds and upper bounds of all the singers are distinct. When two singers Si and Sj with bounds (Li, Ui) 
    and (Lj, Uj) compete against each other, Si wins if they can sing in every pitch that Sj can sing in, and some more pitches. 
    Similarly, Sj wins if they can sing in every pitch that Si can sing in, and some more pitches. If neither of these conditions
    are met, the match ends in a draw. In this problem, you can assume that no match ends in a draw.

    N singers are competing in the tournament. Each singer competes in N-1 matches, one match against each of the other singers. 
    The winner of a match scores 2 points, and the loser gets no points. But in case of a draw, both the singers get 1 point each.

    You are given the lower and upper bounds of all the N singers. You need to output the total scores of each of the $N$ singers
    at the end of the tournament.

    Solution hint
    Since no match ends in a draw, for any pair of singers Si and Sj, one of their vocal ranges is strictly included in the other. 
    Deduce that, across all singers, the vocal ranges form a sequence where each interval is strictly included in the previous one. 
    You can then sort the starting points of the vocal ranges and determine how many matches each singer wins from the position of 
    their starting point in this sorted sequence.

    Sample input 1
    5
    3 23
    4 20
    11 16
    5 19
    1 25

    Sample output 1
    6 4 0 2 8

*/

public class week2 {
    public static void main(String[] args) {
         ArrayList<int[]> arr = new ArrayList<int[]>();

            Scanner sc = new Scanner(System.in);
            System.out.println("Whats the number of participants?");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
            System.out.printf("Enter the low and high pitches of participant %d", i);
            System.out.println();
            int l= sc.nextInt();
            int u= sc.nextInt();
            arr.add(new int[]{l, u});
        }
        /*
        arr.add(0, new int[]{3, 23});
        arr.add(1, new int[]{4, 20});
        arr.add(2, new int[]{11, 16});
        arr.add(3, new int[]{5, 19});
        arr.add(4, new int[]{1, 25});
         */
        
        System.out.println(Arrays.toString(solve(arr)));
    }

    static int[] solve(ArrayList<int[]> arr){ 
        //this function will use hashmap to make a copy of arr 
        HashMap<Integer, int[]> map = new HashMap<>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            map.put(i, arr.get(i));
        }
        int[] scores = new int[map.size()];//stores the scores

        //make a copy of arr & at some point it will call MergeSort
        ArrayList<int[]> sorted= new ArrayList<int[]>(arr.size());
        sorted.addAll(MergeSort(arr));
        /*
         * Very important !!
         * It was sorted in a way that was kinda descending wrt the difference
         * in the pitch intervals but on seeing closely, we needed the opposite of that bcz
         * the interval with the most value shall win all the matches and shall be at the last & whose
         * index would show his number of wins, therefore we reverse it.
         */
        Collections.reverse(sorted); 

        //compare & calc the score in original order and return.
        for (int i = 0; i < sorted.size(); i++) {
            int[] sortedPitch = sorted.get(i); //i represents the number of matches it won.

            //hashmapPitch.getKey() represents the original postion in the array.
            for(Map.Entry<Integer, int[]> hashmapPitch : map.entrySet()){
                if(hashmapPitch.getValue() == sortedPitch){
                    scores[hashmapPitch.getKey()] = 2 * i;
                    //for debugging
                    //System.out.print(hashmapPitch.getKey() + " " + hashmapPitch.getValue() + " " + i);
                    System.out.println();
                }
     
            }
        }
        return scores;
    }

    static ArrayList<int[]> MergeSort(ArrayList<int[]> arr){
        if(arr.size() ==1)
            return arr;

        int mid= arr.size()/2;
        ArrayList<int[]> left = MergeSort(new ArrayList<>(arr.subList(0, mid))); //last value is excluded
        ArrayList<int[]> right = MergeSort(new ArrayList<>(arr.subList(mid, arr.size())));


        //Merge the left & right sections
        //can use a diff function for this.
        ArrayList<int[]> merged= new ArrayList<>(left.size() + right.size());
        //System.out.println(merged.size());
        int i=0, j=0, k=0;

        while(i<left.size() && j<right.size()){
            //left contains right's interval of pitches -> left wins
            if((left.get(i)[0] <= right.get(j)[0]) && (left.get(i)[1] >= right.get(j)[1])){
                //I did merged.set(k, ...) earlier and it threw error for it being empty.
                merged.add(k, left.get(i));
                i++;
            }
            else{
                //I did merged.set(k, ...) earlier and it threw error for it being empty.
                merged.add(k, right.get(j));
                j++;
            }
            k++;     
        }
        
        //one array may end before another so just gotta add the remaining values to the merged[].
        while(i<left.size()){
            merged.add(k, left.get(i));
            i++;
            k++;
        }
        while(j<right.size()){
            merged.add(k, right.get(j));
            j++;
            k++;
        }

        //merged
        return merged;
    }
}




