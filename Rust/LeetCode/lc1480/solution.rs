/**
 * 累加和数组
 * for idx,value in nums
 *      tmp += value
 *      ret[idx] = tmp
 */
impl Solution {
    pub fn running_sum(nums: Vec<i32>) -> Vec<i32> {
        nums.iter().scan(0,|acc,x|{*acc += *x; Some(*acc)}).collect();
    }
}