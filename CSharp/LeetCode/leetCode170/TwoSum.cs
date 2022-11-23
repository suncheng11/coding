public class TwoSum {
    Dictionary<int,int> value;
    Dictionary<int,int> sum;
    public TwoSum() {
        value = new Dictionary<int, int>();
        sum = new Dictionary<int, int>();
    }
    
    public void Add(int number) {
        if(!value.ContainsKey(number)){
            foreach(KeyValuePair<int,int> item in value){
                sum[item.Key+number] = 1;
            }
            value[number] = 1;
        }else{
            sum[number*2] = 1;
        }
    }
    
    public bool Find(int value) {
        return sum.ContainsKey(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.Add(number);
 * bool param_2 = obj.Find(value);
 */