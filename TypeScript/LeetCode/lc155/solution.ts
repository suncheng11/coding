class MinStack {
    protected helpStack = [];
    protected stack = [];
    constructor() {
        
    }

    push(val: number): void {
        this.stack.push(val);
        if(this.helpStack.length == 0){
            this.helpStack.push(val);
        }else{
            this.helpStack.push(Math.min(val,this.getMin()));
        }

    }

    pop(): void {
        this.stack.pop();
        this.helpStack.pop();
    }

    top(): number {
        return this.stack[this.stack.length-1];
    }

    getMin(): number {
        return this.helpStack[this.helpStack.length-1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */