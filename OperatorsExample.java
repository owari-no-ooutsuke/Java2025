public class OperatorsExample {
    public static void main(String[] args) {
        int a = 10; //a = 10
        a += 2; //a = 12
        a -= 4; //a = 8
        a *= 3; //a = 24
        a /= 5; //a = 4
        a %= 3; //a = 1

        String s = "Hello";
        s += ", world!"; //s = "Hello, world!"

        int x = 1, y = 2;
        int max = (x > y) ? x : y; //max равен большему из x, y
        String xParity = (x % 2 == 0) ? "четное" : "нечетное";

        boolean bool1 = true || false; //bool1 = true
        boolean bool2 = true && false; //bool2 = false

        int b = 13; //....1101
        int c = 1; //....0001
        int disj = b | c; //disj = 13 (....1101)
        int xor = b ^ c; //xor = 12 (....1100)
        int conj = b & c; //conj = 1 (....0001)

        byte p = 5, q = 3;
        boolean eq = p == q; //eq = false
        boolean more = p > q; //more = true
        boolean mEq = p >= q; //mEq = true
        boolean less = p < q; //less = false
        boolean lEq = p <= q; //lEq = false;

        int d = 4; //....0100
        int rightShift = d >> 1; //d = 2 (....0010)
        int unsignedRightShift = d >>> 1; //d = 2 (....0010)
        int leftShift = d << 1; //d = 8 (....1000)

        double num1 = 0.1, num2 = 0.2;
        double sum = num1 + num2; //sum = 0.3
        double diff = num1 - num2; //diff = -0.1
        double prod = num1 * num2; //prod = 0.02
        int n = 5, m = 2;
        int quotient = n / m; //quotient = 2
        int remainder = n % m; //remainder = 1

        String str = "Hello, " + "world!"; //str = "Hello, world!"

        short k = 2;
        short postfixIncr = k++; //postfixIncr = 2, k = 3
        short prefixIncr = ++k; //prefixIncr = 4, k = 4
        short postfixDecr = k--; //postfixDecr = 4, k = 3;
        short prefixDecr = --k; //prefixDecr = 2, k = 2

        byte l = 100; //01100100
        byte notL = (byte)~l; //notL = -101 (10011011)
        boolean bool = true;
        boolean notBool = !bool; //notBool = false

        int res1 = 2 + 4 * 3; //res1 = 14
        int res2 = (2 + 4) * 3; //res2 = 24

        char[] chars = new char[2];
        chars[0] = 'A';
        chars[1] = 'B';
    }
}