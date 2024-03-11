import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        
        PriorityQueue<Student> pq = new PriorityQueue<>();
        
        for(int i=0; i<attendance.length; i++) {
            if(attendance[i]) pq.offer(new Student(i, rank[i]));
        }
        
        return pq.poll().getIdx()*10_000 + pq.poll().getIdx()*100 + pq.poll().getIdx();
    }
}

class Student implements Comparable<Student> {
    private int idx;
    private int grade;
    
    public Student(int idx, int grade) {
        this.idx = idx;
        this.grade = grade;
    }
    
    public int getIdx() {
        return idx;
    }
    
    public int getGrade() {
        return grade;
    }
    
    @Override
    public int compareTo(Student s) {
        return this.grade-s.getGrade();
    }
}