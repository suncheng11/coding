use std::collections::HashMap;

impl Solution{
    pub fn length_of_longest_substring(s:String)->i32{
        let (mut ans,mut cnt) = (0,0);
        let mut map =HashMap::new();
        let mut chars = s.chars().collect::<Vec<_>>();
        let mut l = 0;

        chars.iter().enumerate().for_each(|(i,c)| {
            match map.get(c){
                None =>{
                    cnt += 1;
                    ans = ans.max(cnt);
                }
                Some(&i) =>{
                    for c in &chars[l..=i]{
                        map.remove(c);
                    }
                    cnt -= i-l;
                    l = i+1;
                }
            }
            map.insert(*c,i);
        });
        ans as i32
    }
}