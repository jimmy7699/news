package pkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
    public RetrieveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("news/saving-data");
		DatabaseReference usersRef = ref.child("news");
		final ArrayList<Article> newsDate= new ArrayList<Article>();
		usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
		    @Override
		    public void onDataChange(DataSnapshot dataSnapshot) {
		        for (DataSnapshot d : dataSnapshot.getChildren()) {
		        	Article newsDateOne = d.getValue(Article.class);
		        	newsDate.add(newsDateOne);
		        	System.out.println(newsDateOne);
		        }
		       
		    }
		 
		  
		    @Override
		    public void onCancelled(DatabaseError databaseError) {
		    }
		});
		try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println(newsDate);
		request.setAttribute("newsDate", newsDate);
		RequestDispatcher view = request.getRequestDispatcher("news-form.jsp");
		view.forward(request, response);


	}


	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
