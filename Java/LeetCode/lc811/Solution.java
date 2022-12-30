package lc811;

import java.util.HashSet;
import java.util.Map;

import javax.xml.crypto.KeySelector.Purpose;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Domain> map = new HashMap<>();

        for(String item : cpdomains){
            String[] strs = item.split(" ");
            int cnt = Integer.parseInt(strs[0]);
            String[] domains = strs[1].split("\\.");
            String domain = "";
            Domain parent = null;
            for(int i = domains.length-1; i>=0; i--){
                if(domain.length() == 0){
                    domain = domains[i];
                }else {
                    domain = domains[i] + "."+domain;
                }
                Domain cur = map.getOrDefault(domain,new Domain(domain,0));
                cur.parent = parent;
                map.put(domain,cur);            
                parent = cur;
            }

            // System.out.println(domain+"ADD"+cnt);

            map.get(domain).addCnt(cnt);
        }

       

        List<String> ret = new ArrayList<>();

        for(String key : map.keySet()){
            System.out.println(key+" "+map.get(key).getCnt());  
            ret.add(map.get(key).getCnt()+" "+key);
        }

        return ret;  
    }

    class Domain{
        int cnt;
        Domain parent;
        String  name;

        public Domain(String name, int cnt){
            this.cnt = cnt;
            this.name = name;
        }

        public int getCnt() {
            return cnt;
        }
        public Domain getParent() {
            return parent;
        }
        public String getName() {
            return name;
        }
        public void addCnt(int cnt) {
            this.cnt += cnt;
            if(parent!=null){
                getParent().addCnt(cnt);
            }
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setParent(Domain parent) {
            this.parent = parent;
        }
    }
} 