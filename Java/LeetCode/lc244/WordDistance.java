package lc244;

class WordDistance {
    String[] data;
    public WordDistance(String[] wordsDict) {
        data = wordsDict;
    }
    
    public int shortest(String word1, String word2) {
        int index1 = -1, index2 = -1;
        int ret = 30000;
        for(int i = 0; i < data.length; i ++){
            String cur = data[i];
            if(!cur.equals(word1) && !cur.equals(word2)){
                continue;
            }
            if(cur.equals(word1)){
                index1 = i;
            }
            if(cur.equals(word2)){
                index2 = i;
            }
            if(index1 >=0 && index2 >=0){
                ret = Math.min(Math.abs(index1-index2),ret);
            }
        }
        return ret; 
    }
}