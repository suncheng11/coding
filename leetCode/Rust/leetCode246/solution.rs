impl Solution {
    pub fn is_strobogrammatic(num: String) -> bool {
        let mut new = "".to_string();
        for c in num.chars().rev(){
            match c {
                '6' =>new.push('9'),
                '9' =>new.push('6'),
                x @ ('1' | '8' | '0')=>new.push(x),
                _ => return false,
            }
        }
        new == num
    }
}