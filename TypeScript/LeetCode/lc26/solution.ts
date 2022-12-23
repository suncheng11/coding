function removeDuplicates(nums: number[]): number {
    let pre = 0;

    for(let i = 1; i < nums.length; i++){
        if(nums[i] != nums[pre]){
            pre++;
            nums[pre] = nums[i];
        }
    }

    return pre+1;
};