package from2100;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        return (int)Arrays.stream(words).filter(x->x.startsWith(pref)).count();
    }
}
