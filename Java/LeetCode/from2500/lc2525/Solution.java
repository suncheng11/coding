package from2500.lc2525;

public class Solution {
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = isBulky(length, width, height);
        boolean heavy = isHeavy(mass);
        if (bulky && heavy) {
            return "Both";
        }
        if (!bulky && !heavy) {
            return "Neither";
        }
        if (bulky) {
            return "Bulky";
        }
        return "Heavy";
    }

    private static boolean isBulky(int length, int width, int height) {
        long t = (long)length * width * height;
        boolean b1 = length >= 10000 || width >= 10000 || height >= 10000;
        return b1 || t >= 1000000000;
    }

    private static boolean isHeavy(int mass) {
        return mass >= 100;
    }
}