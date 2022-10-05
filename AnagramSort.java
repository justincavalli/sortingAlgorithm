import java.util.*;

public class AnagramSort
{
    private static char[] auxiliary;
    public static void main(String[] args)
    {
        ArrayList<String> inputStrings = new ArrayList<String>(Arrays.asList("arc", "car", "angel", "glean", "acutioned", "cautioned", "education", "testing", "countries", "cretinous", "neurotics", "emigrants", "mastering", "streaming", "master", "of", "software", "engineering"));
        System.out.println(groupAnagram(inputStrings));
    }

    
    private static ArrayList<ArrayList<String>> groupAnagram(ArrayList<String> inputList)
    {
        // Create the 2d list to store the grouped anagrams
        ArrayList<ArrayList<String>> outputList = new ArrayList<ArrayList<String>>();

        outer: while(inputList.size() > 0)
        {
            // pop one word at a time from the inputList
            String word = inputList.remove(0);

            if(outputList.size() > 0)
            {
                for(int i = 0; i <outputList.size(); i++)
                {
                    // check if the word belongs in any of the existing anagram bucket in the output
                    if(sort(outputList.get(i).get(0)).equals(sort(word)))
                    {
                        // add to the bucket of anagrams
                        outputList.get(i).add(word);
                        // skip making a new bucket
                        continue outer;
                    }
                }
            }

            // make a new bucket of anagrams to add to the output
            ArrayList<String> newList = new ArrayList<String>();
            newList.add(word);
            outputList.add(newList);
        }
        return outputList;
    }


    public static String sort(String str)
    {
        // make the string an array of characters for easier sorting
        char[] a = str.toCharArray();
        auxiliary = new char[a.length];
        
        // apply merge sorting
        mergeSort(a, 0, a.length - 1);

        // return in String form
        return String.valueOf(a);
    }

    private static void mergeSort(char[] a, int low, int high)
    {
        // Sort a[low..high]
        if(high <= low) return;
        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid);       // recursively sort left half
        mergeSort(a, mid+1, high);    // recursively sort right half
        merge(a, low, mid, high);     // merge the two halves together
    }

    public static void merge(char[] a, int low, int mid, int high)
    {
        // Merge a[low..mid] with a[mid+1..high]
        int i = low, j = mid+1;

        for(int k = low; k <= high; k++)
            // copy all the elements to the auxiliary array
            auxiliary[k] = a[k];

        for(int k = low; k <= high; k++)
        {
            if(i > mid)
                // if we've used the entire left side, take from the right
                a[k] = auxiliary[j++];
            else if(j > high)
                // if we've used the entire right side, take from the left
                a[k] = auxiliary[i++];
            else if(auxiliary[j] < auxiliary[i])
                // if the next smallest character comes from the left, use it
                a[k] = auxiliary[j++];
            else
                // if the next smallest character comes from the right, use it
                a[k] = auxiliary[i++];
        }
    }
}