function isValid(s: string): boolean {
    let stack = new Array();

    for(let i = 0; i < s.length; i++){
        let cur = s.charAt(i);
        if(cur == '{' || cur =='(' || cur == '['){
            stack.push(cur);
        }else if(stack.length == 0
        || (cur =='}' && stack[stack.length-1]!='{')
        || (cur ==')' && stack[stack.length-1]!='(')
        || (cur == ']' && stack[stack.length-1]!='[')){
            return false;
        }else{
            stack.pop();
        }

    }

    return stack.length == 0;
};