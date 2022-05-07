public class Question1 {

    public String getParity(int n){
        if (n%2 == 0){
            return "even";
        }
        else{
            return "odd";
        }
    }

    public int getMax(int [] array){
        int mx = Integer.MIN_VALUE;
        for (int num: array){
            mx = Math.max(mx, num);
        }
        return mx;
    }
    public int getMin(int [] array){
        int mn = Integer.MAX_VALUE;
        for (int num: array){
            mn = Math.min(mn, num);
        }
        return mn;
    }
}
