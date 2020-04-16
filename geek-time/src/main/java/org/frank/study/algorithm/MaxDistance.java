package org.frank.study.algorithm;

import java.util.*;

/**
 * @ClassName: MaxDistance
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/3/29 9:28
 * @Version: 1.0
 */
public class MaxDistance {
    public static int max(int[][] grid) {
        List<int[]> oceanCoordinate = new ArrayList<>();
        List<int[]> landCoordinate = new ArrayList<>();
        for (int i = grid.length; i > 0  ; i--) {
           int [] sub = grid[i-1];
            for (int j = 0; j < sub.length; j++) {
                if(sub[j] == 0){
                    oceanCoordinate.add(new int[]{i-1,j});
                }else{
                    landCoordinate.add(new int[]{i-1,j});
                }
            }
        }
        return calc(landCoordinate,oceanCoordinate);
    }

    private static int calc(List<int[]> coordinatorOfLand,List<int[]> coordinatorOfOcean){
        Map<Integer,Integer> count = new HashMap<>();
        if(coordinatorOfLand.size() < coordinatorOfOcean.size()){
           count = calc2(coordinatorOfLand,coordinatorOfOcean);
        }else{
            count = calc2(coordinatorOfOcean ,coordinatorOfLand);
        }
        int max = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : count.entrySet()) {
            if(max == 0){
                max = integerIntegerEntry.getValue();
                continue;
            }
            if(max < integerIntegerEntry.getValue()){
                max = integerIntegerEntry.getValue();
                result = integerIntegerEntry.getKey();
            }
        }
        return result;
    }

    private static Map<Integer,Integer> calc2(List<int[]> listA,List<int[]> listB){
        Map<Integer,Integer> count = new HashMap<>();
        Iterator<int[]> iteratorOfLand = listA.iterator();
        while (iteratorOfLand.hasNext()){
            int[] cl = iteratorOfLand.next();
            Iterator<int[]> iteratorOfOcean = listB.iterator();
            while (iteratorOfOcean.hasNext()){
                int[] co = iteratorOfOcean.next();
                int distance = Math.abs(cl[0]-co[0]) + Math.abs(cl[1]-co[1]);
                count.put(distance,count.getOrDefault(distance,0)+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        int[][] grid2 = {{1,0,0},{0,0,0},{0,0,0}};
        int[][] grid3 = {{0,0,1,1,1},{0,1,1,0,0},{0,0,1,1,0},{1,0,0,0,0},{1,1,0,0,1}};
        long start = System.currentTimeMillis();
        System.out.println(max(grid));
        System.out.println(System.currentTimeMillis()-start);
    }
}
