package Day4.Practice;
import java.util.Arrays;
public class FindTriplets {
    public static void find_and_print_all_Triplets(int[] nums, int sum, int alen)
		{
		System.out.println("\nTriplets of sum "+sum);
		for (int i = 0; i <= alen - 3; i++)
			{
				int k = sum - nums[i];
				int l_index = i + 1, h_index = nums.length - 1;
	
				while (l_index < h_index)
				{
					if (nums[l_index] + nums[h_index] < k) {
						l_index++;
					}
	
				else if (nums[l_index] + nums[h_index] > k) {
						h_index--;
					}
	
					else {
						System.out.println("(" + nums[i] + " " + nums[l_index] + " " + nums[h_index] + ")");
						l_index++;
						h_index--;
					}
				}
			}
		}
		public static void main(String[] args)
		{
			int[] nums = { 1, 6, 3, 0, 8, 4, 1, 7 };
			int alen = nums.length;
			System.out.println("\nOriginal array: "+Arrays.toString(nums));
			// sort the array in ascending order
			Arrays.sort(nums);
			int sum = 8;
	
			find_and_print_all_Triplets(nums, sum, alen);
		}
}

