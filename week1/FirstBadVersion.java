/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int start = 1;
    int end = n + 1;
    int m = start + (end - start) / 2;

    while (start != end) {
      boolean isBad = isBadVersion(m);

      if (isBad) {
        end = m;
      } else {
        start = m + 1;
      }

      m = start + (end - start) / 2;
    }

    return start;
  }
}

