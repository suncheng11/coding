package from300.lc374;

public class Solution extends GuessGame {
   public int guessNumber(int n) {
       if(n == 1){
           return n;
       }

       int left = 1, right = n;
       while(left < right){
           int mid = (left + right) >>> 1;
           int tmp = guess(mid);
           if(tmp == 0){
               return mid;
           }
           if(tmp > 0){
               left = mid+1;
           }else{
               right = mid-1;
           }
       }

       return left;
   }
}