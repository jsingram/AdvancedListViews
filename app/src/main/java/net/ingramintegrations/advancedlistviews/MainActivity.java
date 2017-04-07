package net.ingramintegrations.advancedlistviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.ingramintegrations.advancedlistviews.adapters.UserAdapter;
import net.ingramintegrations.advancedlistviews.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView userListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User newUser = new User();

        newUser.setName("Jonathan Ingram");
        newUser.setAge("27");
        newUser.setHometown("New York");
        newUser.setImageID(1);

        User newUser2 = new User();
        newUser2.setName("John Doe");
        newUser2.setAge("23");
        newUser2.setHometown("Miami");
        newUser2.setImageID(2);

        userListView = (ListView) findViewById(R.id.act_main_lv_users_list);

        // Construct the data source
        ArrayList<User> arrayOfUsers = new ArrayList<User>();
        // Add data to ArrayList
        arrayOfUsers.add(0, newUser);
        arrayOfUsers.add(1, newUser2);
        // Create the adapter to convert the array to views
        UserAdapter adapter = new UserAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        userListView.setAdapter(adapter);

        // Set OnItemClickListener
        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You clicked on Item: " + position, Toast.LENGTH_LONG).show();
            }
        });

    }
}
