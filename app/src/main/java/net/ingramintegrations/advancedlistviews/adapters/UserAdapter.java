package net.ingramintegrations.advancedlistviews.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.ingramintegrations.advancedlistviews.R;
import net.ingramintegrations.advancedlistviews.models.User;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_list_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.user_list_tv_name);
        TextView tvHomeTown = (TextView) convertView.findViewById(R.id.user_list_tv_hometown);
        TextView tvAge = (TextView) convertView.findViewById(R.id.user_list_tv_age);
        ImageView imProfilePhoto = (ImageView) convertView.findViewById(R.id.user_list_im_profile_image);

        int userProfileImageID = 0;

        // Populate the data into the template view using the data object
        tvName.setText(user.getName());
        tvHomeTown.setText("Home Town: " + user.getHometown());
        tvAge.setText("Age: " + user.getAge());
        userProfileImageID = user.getImageID();

        if (userProfileImageID == 1) {
            imProfilePhoto.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.jonathan));
            convertView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.newyork));
            tvName.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteText));
            tvHomeTown.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteText));
            tvAge.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteText));
        }else if (userProfileImageID == 2) {
            imProfilePhoto.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.johndoe));
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.whiteBackground));
        } else
        {
            // Do nothing, leave the photo as the default
        }



        // Return the completed view to render on screen
        return convertView;
    }


}
