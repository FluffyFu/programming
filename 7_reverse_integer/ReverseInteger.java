/*
 * Problem: reverse interger
 * Solve date: 2019/09/12
 * Notes: 1. % has different meaning in Python and Java
 *        2. Here we need to know the last digit of Integer.MAX_VALUE and Integer.MIN_VALUE
 * Time complexity: O(# of digits) or O(log(x))
 * Space complexity: O(1)
 */
class ReverseInteger {
    public int reverse(int x) {
        int reconstructed = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reconstructed > Integer.MAX_VALUE / 10 || (reconstructed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (reconstructed < Integer.MIN_VALUE / 10 || (reconstructed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            reconstructed = reconstructed * 10 + pop;
        }
        return reconstructed;
    }
    public static void main(String[] args) {
        int x = 123;
        int res = new ReverseInteger().reverse(x);
        System.out.println("input x is: "+ x);
        System.out.println("reversed result: "+ res);
    }
}
