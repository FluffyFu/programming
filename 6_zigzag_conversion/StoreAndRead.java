/*
 * Problem name: ZigZag Conversion
 * Solve date: Tue Oct 29 20:33:03 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Use an array of StringBuffers to store the input in the 'zigzag' manner (vertical).
 *  Then read out them row by row.
 */
import java.lang.StringBuffer;

public class StoreAndRead {
    public String convert(String s, int numRows) {
        // convert string to char array for easier manipulation.
        char[] c = s.toCharArray();
        StringBuffer[] store = new StringBuffer[numRows];
        for (int i=0; i<numRows; i++) store[i] = new StringBuffer();

        int i=0;
        while (i < c.length) {
            for (int j=0; j<numRows && i<c.length; j++){
                store[j].append(c[i++]);
            }
            for (int j=numRows-2; j>0 && i<c.length; j--){
                store[j].append(c[i++]);
            }
        }

        for (int idx=1; idx < numRows; idx++) {
            store[0].append(store[idx]);
        }
        return store[0].toString();
    }

    public static void main (String[] args) {
        String test = "PAYPALISHIRING";
        int numRows = 4;
        StoreAndRead obj = new StoreAndRead();
        String res = obj.convert(test, numRows);

        System.out.println(res);

    }
}
