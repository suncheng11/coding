package leetCode157;

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
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int ret = 0;
        int cnt = read4(tmp);

        while(cnt > 0 && ret < n){
            for(int i = 0;i < cnt && ret < n;i++,ret++){
                buf[ret] = tmp[i];
            }
            cnt = read4(tmp);
        }
        return ret;
    }
}