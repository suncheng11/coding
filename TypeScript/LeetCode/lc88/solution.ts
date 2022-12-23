/**
 Do not return anything, modify nums1 in-place instead.
 */
 function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let i1=m-1,i2=n-1,i3=m+n-1;
    for(let i = i3; i>=0; i--){
        if(i1<0 || (i2>=0 && nums1[i1]<nums2[i2])){
            nums1[i] = nums2[i2];
            i2-=1;
        }else{
            nums1[i] = nums1[i1];
            i1-=1;
        }
    }
};