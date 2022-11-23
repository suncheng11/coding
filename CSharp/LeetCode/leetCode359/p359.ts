class Logger {
    map:Map<string,number>;
    
    constructor() {
        this.map = new Map();
    }

    shouldPrintMessage(timestamp: number, message: string): boolean {
        let span = 10;
        if(this.map.has(message) && timestamp - this.map.get(message) < span) {
            return false;
        }
        this.map.set(message,timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * var obj = new Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */