public class Solution {
    public bool IsArmstrong(int n) {
        string s = n+"";
        int sum = 0;
        int tmp = n;
        Dictionary<int,int> record = new Dictionary<int,int>();
        while(tmp != 0){
            int num = tmp  % 10;

            if(!record.ContainsKey(num)){
                record[num] = Math.pow(num,s.Length);
            }

            sum += nnn(num,s.Length);
            tmp /= 10;
        }
        return sum == n;
    }

    //Math.Pow(num,n)，但是这个跑起来没有nnn快
    public int nnn(int num, int n){
        int ret = 1;
        for(int i = 0; i < n; i ++){
            ret *= num;
        }
        return ret;
    }
}