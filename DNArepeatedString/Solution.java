// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

// For example,

// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].



public class Solution {
    //notice the order of string counts!
    //same substring can overlap
   // .contain() wast time a lot, use boolean instead!
   // Robin-Karp Algorithm inspired, hash the string into a unique value
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer,Boolean> hash =  new HashMap<Integer,Boolean>();
        HashSet<String> res = new HashSet<String>();
        int  sum = 0;
        for(int i = 0;i<s.length()-9;i++){
                int value = getV(s, i);
                if(!hash.containsKey(value)){
                    hash.put(value,false);
                }
                else{
                    if(hash.get(value)==false)
                        {
                            res.add(s.substring(i,i+10));
                            hash.put(value,true);
                        }
                }
            }
            return new ArrayList(res);
        }
    
    private int getV(String s, int index){
        int v = 0;
        for(int i = index; i<index+10; i++){
            int vv = 0;
            if(s.charAt(i) == 'A') vv = 0;
            else if(s.charAt(i) == 'C') vv = 1;
            else if(s.charAt(i) == 'G') vv = 2;
            else vv = 3;
            v = v*10+vv;
        }
        return v;
    }
    
    private static final Map<Character, Integer> A = new HashMap<>();
    static { A.put('A',0); A.put('C',1); A.put('G',2); A.put('T',3); }
    private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i-10));
            rhash = A.size() * rhash + A.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
    }
}
  
     