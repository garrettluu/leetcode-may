class Solution {
  public boolean isEven(int x) {
    return (x % 2) == 0;
  }
  public int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int start = 0;
    int end = nums.length;
    int mid = nums.length / 2;

    while (mid < end) {
      //if mid index is even
      if (isEven(mid)) {
        //check if indices are aligned
        //if not:
        if (mid + 1 >= nums.length || nums[mid + 1] != nums[mid]) {
          //readjust mid point
          end = mid;
          mid = start + ((end - start) / 2);
        } else {
          start = mid + 1;
          mid = start + ((end - start) / 2);
        }
      } else {
        if (mid - 1 < 0 || nums[mid - 1] != nums[mid]) {
          //readjust mid point
          end = mid;
          mid = start + ((end - start) / 2);
        } else {
          start = mid + 1;
          mid = start + ((end - start) / 2);
        }
      }
    }

    return nums[mid];
  }
}
