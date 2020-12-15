package hard._1036;

import java.util.*;

/**
 * Created by fzy at 11:52 on 2020/12/15.
 */
public class Solution {
    private static final Integer LIMIT = 1000000;
    private static final Integer[][] POSITION_OFFSET = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) {
            return true;
        }
        return bfs(blocked, target, source) && bfs(blocked, source, target);
    }

    public boolean bfs(int[][] blocked, int[] source, int[] target) {

        Set<String> visited = new LinkedHashSet<>();
        for (int[] block : blocked) {
            //System.out.println(block[0] + ":" + block[1]);
            visited.add(block[0] + ":" + block[1]);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(source[0] + ":" + source[1]);
        visited.add(source[0] + ":" + source[1]);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > blocked.length) {
                return true;
            }
            for (int i = 0; i < size; i++) {
                String[] toFind = Objects.requireNonNull(queue.poll()).split(":");
                int x = Integer.parseInt(toFind[0]);
                int y = Integer.parseInt(toFind[1]);
                if (x == target[0] && y == target[1]) {
                    return true;
                }
                updateValue(x, y, queue, visited);
            }
        }
        return false;
    }

    private boolean isValidPosition(Integer x, Integer y, Set<String> visited) {
        if (x < 0 || x >= LIMIT || y < 0 || y >= LIMIT) {
            return false;
        }
        return !visited.contains(x + ":" + y);
    }

    private void updateValue(Integer x, Integer y, Queue<String> queue, Set<String> visited) {
        for (Integer[] offset : POSITION_OFFSET) {
            Integer xNew = x + offset[0];
            Integer yNew = y + offset[1];
            if (isValidPosition(xNew, yNew, visited)) {
                queue.add(xNew + ":" + yNew);
                visited.add(xNew + ":" + yNew);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] blocked = {{0,1},{1,0}};
        int[] source = {0,0};
        int[] target = {0,2};
        System.out.println(solution.isEscapePossible(blocked,source,target));
    }
}
