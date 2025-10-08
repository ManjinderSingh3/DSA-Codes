public class c_SqrtOfANumber {
    public int mySqrt(int x) {
        int left  = 1, right = x;
        int result = 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            long square = (long) mid * mid;
            if(square == x){
                return mid;
            }else if(square < x){
                result = mid;
                left = mid+1;

            }else{
                right = mid-1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        c_SqrtOfANumber solution = new c_SqrtOfANumber();

        int input = 17;
        int sqrt = solution.mySqrt(input);

        System.out.println("The integer square root of " + input + " is: " + sqrt);
    }
}
