/**
 Do not return anything, modify nums in-place instead.
 */
 function moveZeroes(nums: number[]): void {
    let pre = 0;
    nums.forEach((v)=>{
        if(v != 0){
            nums[pre] = v;
            pre++;
        }
    });

    for(let i = pre; i < nums.length; i ++){
        nums[i] = 0;
    }
};