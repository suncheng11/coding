function evalRPN(tokens: string[]): number {
    let stack = [];
    tokens.forEach((v)=>{
        if(!isOp(v)){
            stack.push(v);
        }else{
            stack.push(calculate(parseInt(stack.pop()),parseInt(stack.pop()),v))
        }
    })
    return stack.pop();
};

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

function isOp(ch: string): boolean{
    return ch == "+" || ch == "-" || ch== "*" || ch== "/";
}