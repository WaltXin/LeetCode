package LeetCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class J56_Merge_Intervals {
	
	public static void main(String[] args) {
		J56_Merge_Intervals js = new J56_Merge_Intervals();
		List<Interval> ls = new ArrayList<Interval>();
		ls.add(js.new Interval(1,3));
		ls.add(js.new Interval(2,4));
		js.merge(ls);
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		//sort with start
		int[] reflect = new int[intervals.size()];
		ArrayList<Interval> al = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			int start = intervals.get(i).start;
			reflect[i] = start;
		}
		for (int i = 1; i < reflect.length; i++) {
			int val = reflect[i];
			int j;
			for (j = i - 1; j > 0 && reflect[j - 1] > val; j--) {
				reflect[j] = reflect[j - 1];
			}
			int tem = reflect[j];
			reflect[j] = reflect[i];
			reflect[i] = tem;
		}
		for (int i = 0; i < reflect.length; i++) {
			for (int j = 0; j < intervals.size(); j++) {
				if (reflect[i] == intervals.get(j).start) {
					al.add(intervals.get(i));
					break;
				}
			}
		}
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (int i = 0; i < al.size();) {
			int start = al.get(i).start;
			int end = al.get(i).end;
			for (int j = i + 1; j < al.size(); j++) {
				int nextStart = al.get(j).start;
				int nextEnd = al.get(j).end;
				if (nextStart > end) {
					i++;
					break;
				} else if(end > nextEnd){
					i++;
				} else if (nextEnd >= end) {
					al.get(i).end = nextEnd;
					i++;
					break;
				}
			}
			result.add(al.get(i));
		}

        return result; 
    }
	
	
	public class Interval {
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e) {start = s; end = e;}
	}
}

