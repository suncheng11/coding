function lengthOfLongestSubstring(s: string) : number{
    let map:Map<string,number> = new Map;
    let max = 0;

    if(s == null){
        return 0;
    }
    if(s.length <2){
        return s.length;
    }

    let left = 0;
     
    map.set(s.charAt(0),0);

    for(let right = 1; right < s.length; right++){
        
        let cur = s.charAt(right);
        if(map.get(cur)!=null){
            left = Math.max(left,map.get(cur)+1);
        }

        if(right-left+1 > max){
            max = right-left +1;
        }
        map.set(cur,right);
    }

    return max;

}