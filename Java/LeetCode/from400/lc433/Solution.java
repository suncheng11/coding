package from400.lc433;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>();
        for(String item : bank){
            set.add(item);
        }

        if(startGene.equals(endGene)){
            return 0;
        }
        if(!set.contains(endGene)){
            return -1;
        }

        return bfsToCnt(startGene,endGene,visited,set);
    }

    private int bfsToCnt(String startGene, String endGene, Set<String> visited, Set<String> bank){
        char[] genes = new char[]{'A','G','C','T'};

        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        visited.add(startGene);
        int step = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                for(int j = 0; j < cur.length(); j++){
                    for(char ch : genes){
                        if(ch != cur.charAt(j)){
                            StringBuilder builder = new StringBuilder(cur);
                            builder.setCharAt(j,ch);
                            String next = builder.toString();
                            if(!visited.contains(next) && bank.contains(next)){
                                if(next.equals(endGene)){
                                    return step;
                                }
                                q.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
} 