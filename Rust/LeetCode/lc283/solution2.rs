impl Solution {
    pub fn move_zeroes(nums: &mut Vec<i32>) {
        let mut pre = 0;
        for i in 0..nums.len(){
            if nums[i]!=0{
                nums[pre] = nums[i];
                pre+=1;
            }
        }

        for i in pre..nums.len(){
            nums[i] = 0;
        }
    }
}