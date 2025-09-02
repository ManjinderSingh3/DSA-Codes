import java.util.Scanner;

public class d_GuessNumberHigherOrLower {
    private int pick;

    public d_GuessNumberHigherOrLower(int pick){
        this.pick = pick;
    }

    public int guess(int num){
        if (num>pick)
            return -1;
        else if(num<pick)
            return 1;
        else
            return 0;

    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left<=right){
            int mid = left + (right-left)/2;
            int guessed = guess(mid);
            if(guessed == 0){
                return mid;
            }else if(guessed == -1){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter maximum number: ");
        int n = sc.nextInt();

        System.out.print("Enter the number to pick (1 to " + n + "): ");
        int pick = sc.nextInt();

        d_GuessNumberHigherOrLower game = new d_GuessNumberHigherOrLower(pick);
        int guessedNumber = game.guessNumber(n);

        System.out.println("Guessed Number: " + guessedNumber);
    }
}
