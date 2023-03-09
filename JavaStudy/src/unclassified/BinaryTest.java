package unclassified;

/**
 * @author DIO的面包店
 * @since 2022/3/5 16:14
 */
public class BinaryTest {

    public static void main(String[] args) {



        Integer[] numbers = {1,4,6,5,2,3};
        sort(numbers, false);
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.print(numbers[i] + "]");
            } else if (i == 0) {
                System.out.print("[" + numbers[i] + ",");
            } else {
                System.out.print(numbers[i] + ",");
            }
        }
//        int[] n = {5};
//        System.out.println(search(n, 5));
    }

    private static Integer[] sort(Integer[] numbers, boolean isDesc) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if(isDesc){
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }else{
                    if (numbers[j] < numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }

            }
        }
        return numbers;

    }


    public static int calcValue(int n) {
        if (n > 3) {
            return 3;
        }
        if (n <= 1) {
            return 1;
        }
        return calcValue(n-1) * calcValue(n+1);}

    public static int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int mid;

        while(l<=r){
            mid = (l+r) /2;
            if(target == nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                l = mid + 1 ;
            }else if(target<nums[mid]){
                r = mid - 1;
            }

        }
        return -1;

    }

}
