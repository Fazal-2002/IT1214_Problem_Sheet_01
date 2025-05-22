class Student{
	private String name;
	private int studentId;
	private int daysAttended;
	
	Student(int studentId, String name, int daysAttended){
		
		this.studentId=studentId; 
		this.name=name;
		this.daysAttended=daysAttended;
		
	}
	
	String getName(){
		return name;
	}
	
	void setName(String name){
		this.name=name;
	}
	
	int getStudentId(){
		return studentId;
	}
	
	void setStudentId(int studentId){
		this.studentId=studentId;
	}
	
	int getDaysAttended(){
		return daysAttended;
	}
	
	void setDaysAttended(int daysAttended){
		this.daysAttended=daysAttended;
	}
	
	public String toString(){
		return "ID: "+studentId+ ", Name: "+name+ ", Days Attended: "+daysAttended;
	}
	
}

class Classroom{
	Student[] students = new Student[10];
	int count=0;
	
	void addStudent(Student s){
		if(count<10){
			students[count]=s;
			count++;
		}else{
			System.out.println("Class full");
		}
	}
	
	void updateAttendance(int id, int newDays){
		boolean found=false;
		for(int i=0; i<count; i++){
			if(students[i].getStudentId()==id){
				students[i].setDaysAttended(newDays);
				found=true;
				break;
			}
		}
		if(!found){
			System.out.println("Student id "+id+" not found");
		}
	}
	
	void studentDetails(){
		for(int i=0; i<count; i++){
			System.out.println(students[i]);
		}
	}
	
}

class Main{
	public static void main(String[] arg){
		Classroom cR=new Classroom();
		
		cR.addStudent(new Student(101,"Alice Smith",12));
		cR.addStudent(new Student(102,"Bob Jones",15));
		cR.addStudent(new Student(103,"Carol Lee",10));
		
		cR.updateAttendance(102,16);
		cR.updateAttendance(104,8);
		
		cR.studentDetails();
	}
}