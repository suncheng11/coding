impl Solution {
    pub fn can_attend_meetings(mut intervals: Vec<Vec<i32>>) -> bool {
        intervals.sort_unstable_by(|a,b| a[0].cmp(&b[0]));
        intervals.windows(2).all(|x| x[1][0] >= x[0][1])
    }
}