impl Solution {
    pub fn can_attend_meetings(intervals: Vec<Vec<i32>>) -> bool {
        intervals.sort_by(|a,b| a[0].cmp[&b[0]]);
        let mut pre_end = 0;
        for item in intervals.iter(){
            if pre_end > item[0]{
                return false;
            }
            pre_end = item[1];
        }
        true;
    }
}

