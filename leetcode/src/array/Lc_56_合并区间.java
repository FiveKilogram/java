/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 时间复杂度：O(N logn)
 * 空间复杂度：O(N)
 * @author luweiliang
 * @created 2020/5/26
 */
public class Lc_56_合并区间 {
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

    /**
     * 合并区间，扫描线算法
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        //根据start对合并间隔列表进行排序
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        //得到合并区间的第一个值
        int start = intervals.get(0).start;
        //得到合并区间的最后一个值
        int end = intervals.get(0).end;

        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            //如果当前合并区间的start <= end最后一个
            if (interval.start <= end) {
                //在最后一个和当前合并区间的结束时间中获取最大的值成为新的结束值;
                end = Math.max(end, interval.end);
            } else {
                //创建这个新合并区间把开始和结束值成为新的区间，添加到结果集中
                res.add(new Interval(start, end));
                //把当前合并区间的开始值，赋值给第一个值
                start = interval.start;
                //把当前合并区间的结束值，赋值给最后一个值
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static List<Interval> merge1(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0)
            return res;

        // 根据start对时间间隔列表进行排序
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

        // 得到第一个
        Interval temp = intervals.get(0);

        // 如果区间只有一个元素
        if(intervals.size() == 1) {
            res.add(temp);
            return res;
        }


        //迭代间隔从[1]到结束
        for(int i=1; i<intervals.size(); i++) {
            //如果temp interval end >= this interval start ->
            //合并tempStart, max(tempEnd, thisEnd)，将这个合并为新的临时变量;
            if(temp.end >= intervals.get(i).start)
            {
                temp.end = Math.max(temp.end, intervals.get(i).end);
            } else {//情况2:如果临时间隔不重叠这个间隔-> 将临时变量添加到列表中，并创建这个新的临时变量
                res.add(temp);
                temp = intervals.get(i);
            }
        }
        //将最后一个临时变量添加到列表中
        res.add(temp);
        return res;
    }


    public static void main(String[] args){

        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        List<Interval> list = merge(intervals);
        for (Interval interval : list) {
            System.out.println(interval.start + "   " + interval.end);
        }
    }

}
