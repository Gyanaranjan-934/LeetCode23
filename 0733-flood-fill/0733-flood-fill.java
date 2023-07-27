import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) {
            return image; // No need to perform flood fill if the colors are already the same
        }
        
        int n = image.length;
        int m = image[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = newColor; // Change the color of the starting pixel
        
        while (!queue.isEmpty()) {
            Pair currentPixel = queue.poll();
            int x = currentPixel.x;
            int y = currentPixel.y;
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && image[nx][ny] == originalColor) {
                    queue.add(new Pair(nx, ny));
                    image[nx][ny] = newColor; // Change the color of the neighboring pixel
                }
            }
        }
        
        return image;
    }
}
