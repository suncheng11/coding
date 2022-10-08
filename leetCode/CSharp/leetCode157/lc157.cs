/**
 * The Read4 API is defined in the parent class Reader4.
 *     int Read4(char[] buf4);
 */

public class Solution : Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int Read(char[] buf, int n) {
        int ret = 0;
        char[] tmp = new char[4];
        int size = Read4(tmp);
        while(size >0 && ret < n){
            for(int i = 0; i < size && ret < n; i++,ret++){
                buf[ret] = tmp[i];
            }
            size = Read4(tmp);
        }
        return ret;
    }
}