impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        let (mut i1,mut i2, mut i3) = ((m) as usize, (n) as usize, (m+n-1) as usize);
        for i in (0..=i3).rev(){
            if i1<=0 || (i2>0 && nums1[i1-1]<nums2[i2-1]){
                nums1[i] = nums2[i2-1];
                i2-=1;
            }else if i2<=0 || (i1>0 && nums1[i1-1]>=nums2[i2-1]){
                nums1[i] = nums1[i1-1];
                i1-=1;
            }
        }
    }
}