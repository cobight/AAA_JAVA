public class GetMax {
    public static void main(String[] args) {
        int[] nums ={11,22,55,10,12,40};
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = nums[i]>max?nums[i]:max;
        }
        System.out.println(max);
    }
}
