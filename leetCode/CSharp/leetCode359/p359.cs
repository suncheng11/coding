public class Logger {

    Dictionary<string,int> map;
    public Logger() {
        map = new Dictionary<string,int>();
    }
    
    public bool ShouldPrintMessage(int timestamp, string message) {
        int span = 10;

        if(map.ContainsKey(message) && timestamp - map[message] < span){
            return false;
        }
        map[message] = timestamp;
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * bool param_1 = obj.ShouldPrintMessage(timestamp,message);
 */