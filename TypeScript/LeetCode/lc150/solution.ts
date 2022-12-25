function evalRPN(tokens: string[]): number {
    if(!isOp(tokens[tokens.length-1])){
        return parseInt(tokens.pop()); 
    }

    let op = tokens.pop();
    let right:number = evalRPN(tokens);
    let left:number = evalRPN(tokens);

    return calculate(right,left,op);
};

function isOp(ch: string): boolean{
    return ch == '+' || ch == '-' || ch=='*' || ch=='/';
}


function calculate(right:number, left:number, op:string){
    if(op == '+'){
        return left + right;
    }
    if( op =='-'){
        return left - right;
    }
    if(op == '*'){
        return left*right;
    }
    return parseInt((left/right)+"");
}