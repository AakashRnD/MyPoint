/* Description:-To handle the database for Questions of Quiz-It Basic Level
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.finaleasy.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHandler extends SQLiteOpenHelper {

	public DataBaseHandler(Context context) {
		
		super(context, "FinalEasy", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override//Create the Table
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL("CREATE TABLE FinalEasy(qid INTEGER, question TEXT, a TEXT, b TEXT, c TEXT, d TEXT, explanation TEXT)");		
		Log.d("info","create table");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS FinalEasy");
		 
        // Create tables again
        onCreate(db);
		
	}

//Add questions to the Table------------------------
	public void addQuestion(Question q){
		
		SQLiteDatabase db = this.getWritableDatabase();		 
	    ContentValues values = new ContentValues();
	    
	    values.put("qid", q.get_id()); 
	    values.put("question", q.get_question());
	    values.put("a", q.get_optiona());
	    values.put("b", q.get_optionb());
	    values.put("c", q.get_optionc());
	    values.put("d", q.get_optiond());
	    values.put("explanation", q.get_explanation());
	    
	 // Inserting Row
	    db.insert("FinalEasy", null, values);
	    db.close(); // Closing database connection
	    
	}
	
//Get single question from Table--------------------
	public Question getQuestion(int id){
		
		SQLiteDatabase db = this.getReadableDatabase();
		
		String query = "SELECT * FROM FinalEasy WHERE qid = ?";
		Cursor cursor = db.rawQuery(query, new String[]{Integer.toString(id)});		
		if (cursor != null)
	        cursor.moveToFirst();
	 
	    Question q = new Question(Integer.parseInt(cursor.getString(0)),
	            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
	    
	    return q;
	}
	
	public void remove(){
		
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL("DELETE FROM FinalEasy");
		Log.d("info","remove table");
		
	}

}
