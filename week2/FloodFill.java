class Solution {

  public void addNeighbors(int[][] image, int currPixel[], int oldColor,
      List<int[]> q) {
    if ((currPixel[1] + 1 < image[currPixel[0]].length) && (image[currPixel[0]][currPixel[1] + 1] == oldColor)) {
      int[] thing = {currPixel[0], currPixel[1] + 1};
      q.add(thing);
    }
    if ((currPixel[1] - 1 >= 0) && (image[currPixel[0]][currPixel[1] - 1] == oldColor)) {
      int[] thing = {currPixel[0], currPixel[1] - 1};
      q.add(thing);
    }
    if ((currPixel[0] + 1 < image.length) && (image[currPixel[0] + 1][currPixel[1]] == oldColor)) {
      int[] thing = {currPixel[0] + 1, currPixel[1]};
      q.add(thing);
    }
    if ((currPixel[0] - 1 >= 0) && (image[currPixel[0] - 1][currPixel[1]] == oldColor)) {
      int[] thing = {currPixel[0] - 1, currPixel[1]};
      q.add(thing);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];

    if (oldColor == newColor) {
      return image;
    }

    List<int[]> q = new ArrayList<>();
    int[] startPix = {sr, sc};

    q.add(startPix);

    while (!q.isEmpty()) {
      int[] currPixel = q.remove(0);

      image[currPixel[0]][currPixel[1]] = newColor;

      addNeighbors(image, currPixel, oldColor, q);

    }

    return image;

  }
}
