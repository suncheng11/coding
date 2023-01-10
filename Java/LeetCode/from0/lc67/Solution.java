package lc67;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i1 = a.length()-1, i2 = b.length()-1;
        while(i1 >= 0 && i2 >= 0){
            int v1 = a.charAt(i1)-'0';
            int v2 = b.charAt(i2)-'0';
            builder.append((v1+v2+carry)%2);
            carry = (v1+v2+carry)/2;
            i1--;i2--;
        }

        while(i1>=0){
            int v1 = a.charAt(i1)-'0';
            builder.append((v1+carry)%2);
            carry = (v1+carry)/2;
            i1--;
        }

        while(i2>=0){
            int v2 = b.charAt(i2)-'0';
            builder.append((v2+carry)%2);
            carry = (v2+carry)/2;
            i2--;
        }

        if(carry>0){
            builder.append(1);
        }

        return builder.reverse().toString();
    }
}