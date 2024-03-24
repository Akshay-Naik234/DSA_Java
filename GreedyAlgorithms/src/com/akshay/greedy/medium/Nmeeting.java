package com.akshay.greedy.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nmeeting {

	static class Meeting {
		int start;
		int end;
		int pos;

		Meeting(int start, int end, int pos) {
			this.start = start;
			this.end = end;
			this.pos = pos;
		}
	}
	
	static class MeetingComparator implements Comparator<Meeting>{

		public int compare(Meeting o1, Meeting o2) {
			if(o1.end > o2.end) {
				return 1;
			}
			else if(o1.end<o2.end) {
				return -1;
			}
			else if(o1.pos < o2.pos) {
				return -1;
			}
			return 1;
		}
		
	}

	public static int maxMeetings(int start[], int end[], int n) {
		List<Meeting> meetings = new ArrayList<>();
		for(int i=0;i<n;i++) {
			meetings.add(new Meeting(start[i], end[i], i+1));
		}
		MeetingComparator comparator = new MeetingComparator();
		Collections.sort(meetings,comparator);
		int cnt = 1;
		int endPoint = meetings.get(0).end;
		for(int i=1;i<n;i++) {
			int startPoint = meetings.get(i).start;
			if(startPoint>endPoint) {
				cnt++;
				endPoint = meetings.get(i).end;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int start[] = {1,3,0,5,8,5};
		int end[] =  {2,4,6,7,9,9};
		int res = maxMeetings(start, end, 6);
		System.out.println(res);
	}
}
