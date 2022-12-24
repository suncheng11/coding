function plusOne(digits: number[]): number[] {
    if(digits == null){
        return digits;
    }
    let add = 1;
    digits.reverse().forEach((v,idx)=>{
        let tmp = add+v;
        add = Math.floor(tmp/10);
        digits[idx] = tmp%10;
    })

    if(add > 0){
        digits.push(1);
    }
    return digits.reverse();
};