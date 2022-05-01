/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。
 * 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：总人数少于1100人。
 * 示例
 * 输入: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author luweiliang
 * @created 2020/11/5
 */
public class Lc_406_根据身高重建队列 {
    public static int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length)
            return new int[0][0];

        //按照身高降序 K升序排序
        //排序前：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        //排序后：[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        //K值定义为 排在h前面且身高大于或等于h的人数
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置

        // 1. people: [7,0]
        // 插入到离开始位置偏移了0个距离的位置。
        // result: [[7,0]]

        // 2. people: [7,1]
        // 插入到离开始位置偏移了1个距离的位置，即插入到[7,0]的后面。
        // result: [[7,0], [7,1]]

        // 3. people: [6,1]
        // 插入到离开始位置偏移了1个距离的位置，即插入到[7,0]的后面。
        // result: [[7,0], [6,1], [7,1]]

        // 4. people: [5,0]
        // 插入到离开始位置偏移了0个距离的位置，即插入到[7,0]的前面。
        // result: [[5,0], [7,0], [6,1], [7,1]]

        // 5. people: [5,2]
        // 插入到离开始位置偏移了2个距离的位置，即插入到[7,0]的后面。
        // result: [[5,0], [7,0], [5,2], [6,1], [7,1]]

        // 6. people: [4,4]
        // 插入到离开始位置偏移了4个距离的位置，即插入到[6,1]的后面。
        // result: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

        // 这种算法体现了元素第二个数字与其插入位置的关系，所以通过简单的一个for循环就可以搞定。
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] new_people =  reconstructQueue(people);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < new_people.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j< new_people[i].length; j++){
                //System.out.print(new_people[i][j] + ",");
                list.add(new_people[i][j]);
            }
            res.add(list);
        }
        System.out.println(res);
    }
}
