package lab;

public class CompoundInterest {
    public static double calculateAmount(double principal, double rate, int time) {
        return principal * Math.pow(1 + rate / 100, time);
    }

    public static double calculateInterest(double principal, double rate, int time) {
        return calculateAmount(principal, rate, time) - principal;
    }
}
