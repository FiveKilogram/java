/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 *
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 时间复杂度：O（n）。
 * 空间复杂度：O（n）
 * https://leetcode-cn.com/problems/insert-interval/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--19/
 * @author luweiliang
 * @created 2020/7/15
 */
public class Lc_57_插入区间 {
    public static class Interval {
        int start;
        int end;
        public Interval() {
            start = 0;
            end = 0;
        }
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // 将新节点之前的节点加到结果中
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // 和新节点判断是否重叠，更新新节点
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        //将新节点加入
        result.add(newInterval);
        ///剩下的全部加进来
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }

    public static List<Interval> insert_1(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval i : intervals) {
            //新加的入的节点在当前节点后边
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
                //新加入的节点在当前节点的前边
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
                //新加入的节点和当前节点有重合，更新节点
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }


    public static void main(String[] args){

//        Interval interval1 = new Interval(1, 3);
//        Interval interval2 = new Interval(6, 9);
//
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(interval1);
//        intervals.add(interval2);
//
//        Interval newInterval = new Interval(2, 5);

        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(3, 5);
        Interval interval3 = new Interval(6, 7);
        Interval interval4 = new Interval(8, 10);
        Interval interval5 = new Interval(12, 16);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);

        Interval newInterval = new Interval(4, 8);

        List<Interval> list = insert(intervals, newInterval);
        for (Interval interval : list) {
            System.out.println(interval.start + "   " + interval.end);
        }
    }
}
