class Solution {
    public double angleClock(int hour, int minutes) {
        double am = minutes*6;
        double ah = (hour+(minutes/(double)60))*5*6;
        double a = Math.abs(am-ah);
        return Math.min(a,360-a);
    }
}