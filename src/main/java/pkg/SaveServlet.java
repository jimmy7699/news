package pkg;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SaveServlet extends HttpServlet {

       
   
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("restricted_access/secret_document");
		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				Object document = dataSnapshot.getValue();
				System.out.println(document);
			}
			public void onCancelled(DatabaseError error) {
			}
			});
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref1 = database.getReference("news/saving-data");
		DatabaseReference usersRef = ref1.child("news");

		/*Map<String, User> users = new HashMap<String, User>();
		users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
		users.put("564546545", new User("December 9, 1906", "Grace Hopper"));

		usersRef.setValueAsync(users);*/
		RSSReader rss = new RSSReader();
        Article[] new1 = rss.getItem("https://udn.com/rssfeed/news/2/7225?ch=news");
        List<Article> news = Arrays.asList(new1);
        usersRef.setValueAsync(news);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

