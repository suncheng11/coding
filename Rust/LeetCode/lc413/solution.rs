impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        if nums.len() < 3{
            return 0;
        }

        let (mut ret, mut add) = (0,0);

        let mut diff = nums[1]-nums[0];

        nums.windows(2).skip(1).for_each(|x|{
            if x[1]-x[0] == diff{
                add+=1;
            }else{
                diff = x[1]-x[0];
                add = 0;
            }
            ret += add;
        });
        
        return ret;
    }
}