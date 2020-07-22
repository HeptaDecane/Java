/*
	https://www.hackerrank.com/challenges/java-sort
*/

import java.util.*;

class Student implements Comparable<Student>{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}

	@Override
	public int compareTo(Student second){
		Student first = this;
		if(first.cgpa > second.cgpa)
			return -1;
		else if(first.cgpa < second.cgpa)
			return 1;
		else{
			if(first.fname.compareTo(second.fname)==0){
				if(first.id > second.id)
					return 1;
				else if(first.id < second.id)
					return -1;
				else
					return 0;
			}
			else
				return first.fname.compareTo(second.fname);
		}
	}
}

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
      	Collections.sort(studentList);
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



