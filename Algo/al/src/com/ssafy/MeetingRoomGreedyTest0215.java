package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomGreedyTest0215 {

	static class Meeting implements Comparable<Meeting> {

		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); // 회의 수

		int count = sc.nextInt();
		
		
		Meeting[] meetings = new Meeting[count];
		for (int i = 0; i < count; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		List<Meeting> result = getSchedule(meetings);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append('\n');
		
		for (Meeting meeting : result) {
			sb.append(meeting.start).append(" ").append(meeting.end).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static List<Meeting> getSchedule(Meeting[] meetings){
		ArrayList<Meeting> result = new ArrayList<Meeting>();
		
		Arrays.sort(meetings);
		result.add(meetings[0]);  // 첫회의 추가 
		
		for (int i = 0, size = meetings.length; i < size; i++) {
			
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		return result;
	}
}
