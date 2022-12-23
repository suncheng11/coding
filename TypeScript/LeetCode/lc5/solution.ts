/**
 * 最长回文字符串
 * 
 * 穷举法：
 * for substring in str
 *     if(isPalindromic(substring))
 *          ret = max(ret,substring)
 * 
 * 
 * 中心扩展法：
 * for pos in str.length
 *      len1 = maxPalindromicStrWithMid(pos,pos)
 *      len2 = maxPalindromicStrWithMid(pos,pos+1)
 *      
 *      len = max(ret,len1,len2)
 *      if(len > max)
 *          left = i-(len-1)/2;
 *          right = i+len/2;
 * return str.substring(left,right+1);
 *
 * 
 * maxPalindromicStrWithMid(left,right){
 *      while(valid(left) && valid(right) && str[left] == str[right])
 *          left--;right++;
 * 
 *      return rigfh -left -1;
 * }
 *
 */

 function longestPalindrome(s: string): string {
    var start = 0, end = 0;
    var max = 0;
    for(var i = 0; i < s.length; i++){
        let len1 = maxPalindromicStrWithMid(i,i,s);
        let len2 = maxPalindromicStrWithMid(i,i+1,s);
        let len = Math.max(len1,len2);
        if(len > max){
            start = i-Math.floor((len-1)/2);
            end = i+ Math.floor(len/2);
            max = len;
        }
       
    }
    return s.substring(start,end+1);
};

function maxPalindromicStrWithMid(left: number, right: number, s:String):number{
    while(left >=0 && right < s.length && s[left] === s[right]){
        left--;
        right++;
    }
    return right - left -1;
}