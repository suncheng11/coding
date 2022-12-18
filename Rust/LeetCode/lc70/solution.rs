impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        return fib(n);
    }
}
pub fn fib(n: i32) -> i32{
    if n<3 {
        return n;
    }
    let mut a = 1;
    let mut b = 2;
    let mut c = 2;
    for i in 3..=n{
        c = a+b;
        a = b;
        b = c;
    }
    c
}