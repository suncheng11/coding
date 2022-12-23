function runningSum(nums: number[]): number[] {
    let sum = 0;
    let ret:number[] = new Array(nums.length);
    nums.forEach((val,idx,array)=>{
        sum += val;
        ret[idx] = sum;
    })
    return ret;
};