function twoSum(nums: number[], target: number): number[] {
    let ret : number[] = [];
    let map:Map<number,number> = new Map();
    let index : number | undefined;

    for(let i = 0; i < nums.length; i++){
        index = map.get(target - nums[i]);
        if(index != undefined){
            ret = [index, i]
            return ret;
        }
        map.set(nums[i],i);
    }

    return ret;
};