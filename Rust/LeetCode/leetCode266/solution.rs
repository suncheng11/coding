impl Solution {
    pub fn can_permute_palindrome(s: String) -> bool {
        let cv : Vec<char> = s.chars().collect();
        let mut map = std::collections::HashMap::new();
        for ch in cv{
            let cnt = map.entry(ch).or_insert(0);
            *cnt += 1;
        }

        let mut remain = 0;
        for key in map.values(){
            remain += (*key) % 2;
        }
        remain <2
    }
}