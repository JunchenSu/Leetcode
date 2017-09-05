/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    char[] buffer = new char[4];
    int head = 0, tail = 0;

    public int read(char[] buf, int n) {
        // Write your code here
        int i = 0;
        while (i < n) {
            if (head == tail) {               // queue is empty
                head = 0;
                tail = read4(buffer);         // enqueue
                if (tail == 0) {
                    break;
                }
            }
            while (i < n && head < tail) {
                buf[i++] = buffer[head++];    // dequeue, 难点在于假如n=3,只取3个，但是READ4每次都是取4个，怎么把取了的第4个放到下次再用
            }
        }
        return i;
    }
}
