/* Description:-Setting of Questions and related options
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.linequiz.database;

public class Question {
	
	private int q_id;
	private String question;
	private String option_a;
	private String option_b;
	private String option_c;
	private String option_d;
	private String explanation;
	
	
	public Question(){
		
	}
	
	public Question(int q_id, String question, String option_a, String option_b, String option_c, String option_d, String explanation){
		
		this.q_id=q_id;
		this.question=question;
		this.option_a=option_a;
		this.option_b=option_b;
		this.option_c=option_c;
		this.option_d=option_d;
		this.explanation=explanation;
	}
	
	
	public int get_id(){
		return q_id;
	}
	
	public String get_question(){
		return question;
	}
	public String get_optiona(){
		return option_a;
	}
	public String get_optionb(){
		return option_b;
	}
	public String get_optionc(){
		return option_c;
	}
	public String get_optiond(){
		return option_d;
	}

	public String get_explanation(){
		return explanation;
	}
}
