function evalRPN(tokens: string[]): number {
    let op = tokens.pop();
    if(!isOp(op)){
        return parseInt(op);
    }
    let right:number = isOp(tokens[tokens.length-1])?evalRPN(tokens):parseInt(tokens.pop());
    let left:number = isOp(tokens[tokens.length-1])?evalRPN(tokens):parseInt(tokens.pop());

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