package lc158;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    private static int done = 0;
    private static char[] cache = new char[4];
    private static int cacheRemain = 0;


    public Solution(){
        done = 0;
        cache = new char[4];
        cacheRemain = 0;
    }

    public int read(char[] buf, int n) {

        int adone = done;
        char[] acache = cache;
        int acacheRemain = cacheRemain;

        int ret = 0;
        int cnt = 0;

        if(cacheRemain > 0){
            int remain = cacheRemain;
            for(int pos = (done%4),  tmp = 0;tmp < remain && ret < n;tmp++,pos++,ret++){
                buf[ret] = cache[pos];
                cacheRemain--;
            }
        }

        if(cacheRemain > 0 || ret == n){
            done += ret;
            return ret;
        }

        int size = refreshCache();
       
        while(size > 0 && ret < n){
            for(int i = 0;i < size && ret < n;i++,ret++){
                buf[ret] = cache[i];
                cacheRemain--;
            }
            if(cacheRemain <= 0){
                size = refreshCache();;  
            }
        }
        done += ret;
        return ret;
    }

    private int refreshCache(){
        return cacheRemain = read4(cache);
    }
}