impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
         pub fn gcb(a:i32,b:i32)->i32{
            if b==0{
                return a;
            }
            gcb(b,a%b)
        }
          let min = *nums.iter().min().unwrap();
          let max = *nums.iter().max().unwrap();
          gcb(max,min)
    }
}