impl Solution {
    pub fn candy(ratings: Vec<i32>) -> i32 {
        let mut ans = 0;
        //初始化每个人分1块糖
        let mut nums= vec![1;ratings.len()];
        //从左边、右边各遍历一次，比前一个得分高的就加一
        for i in 1..ratings.len(){
            if(ratings[i] > ratings[i-1]){
                nums[i] = nums[i-1]+1;
            }
        }

        ans += nums[nums.len()-1];

        for i in (0..ratings.len()-1).rev(){
            if(ratings[i] > ratings[i+1]){
                nums[i] = nums[i].max(nums[i+1]+1);
            }
            ans += nums[i];
        }

        ans
    }
}