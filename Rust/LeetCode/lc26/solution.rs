impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        let mut pre = 0;
        for i in 1..nums.len() {
            if nums[i]!=nums[pre]{
                pre+=1;
                nums[pre] = nums[i];
            }
        }
        return (pre+1) as i32;
    }
}