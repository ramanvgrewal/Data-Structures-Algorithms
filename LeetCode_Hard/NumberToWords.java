package LeetCode_Hard;

public final class NumberToWords {
    private final String[] below20 = {"", "One", "Two", "Three", "Four", "Five", 
                                           "Six", "Seven", "Eight", "Nine", "Ten", 
                                           "Eleven", "Twelve", "Thirteen", "Fourteen", 
                                           "Fifteen", "Sixteen", "Seventeen", 
                                           "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", 
                                   "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] biggerNums = {"", "Thousand", "Million", "Billion"};
    public final String numberToWords(int num) {
        if(num == 0) return "Zero";

        int i = 0;
        String ans = "";
        while(num > 0) {
            int rem = num % 1000;
            if(rem != 0) {
                ans = solve(rem) + (biggerNums[i].isEmpty() ? "" : " " + biggerNums[i]) +
                (ans.isEmpty() ? "" : " " + ans);
            }
            num /= 1000;
            i++;
        }
        return ans;
    }
    public final String solve(int rem) {
        if(rem == 0) return "";
        else if(rem < 20) return below20[rem];
        else if(rem < 100) return tens[rem / 10]
        + (rem % 10 != 0 ? " " + below20[rem % 10] : "");
        else return below20[rem / 100] + " " + "Hundred"
        + (rem % 100 == 0 ? "" : " " + solve(rem % 100));
    }
    public static void main(String[] args) {
        NumberToWords converter = new NumberToWords();
        System.out.println(converter.numberToWords(123)); 
        System.out.println(converter.numberToWords(12345)); 
        System.out.println(converter.numberToWords(1234567)); 
    }
}