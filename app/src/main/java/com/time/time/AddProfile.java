package com.time.time;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

import java.util.ArrayList;
import java.util.List;

public class AddProfile extends AppCompatActivity {


    ArrayList<String> listItems = new ArrayList<String>();

    ArrayAdapter<String> adapter;


    DBHandler db = new DBHandler(this);

    int colR, colG, colB = 0, selectedColor;

    Button selectColorButton;
    EditText name, description;
    String s_name, s_description;
    ListView profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //declaring and defining objects
        name = (EditText) findViewById(R.id.profile_name);
        description = (EditText) findViewById(R.id.profile_description);
        profileList = (ListView) findViewById(R.id.profile_list);

        //Color Picker
        final ColorPicker cp = new ColorPicker(AddProfile.this, colR, colG, colB);

        selectColorButton = (Button) findViewById(R.id.select_color_button);

        //update list with profiles
        populateProfileList();

        //Clicking the color button
        selectColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cp.show();
                Button okColor = (Button) cp.findViewById(R.id.okColorButton);
                okColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        selectedColor = cp.getColor();
                        selectColorButton.setBackgroundColor(selectedColor);
                        cp.dismiss();
                    }
                });


            }
        });

        //Add floating button is clicked
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting strings from edittext box
                s_name = name.getText().toString();
                s_description = description.getText().toString();
                db.addProfile(new Profiles(s_name, s_description, "color_test"));
                //show notification
                Snackbar.make(view, "Profile " + s_name + " has been created.", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();

                //update list with profiles
                populateProfileList();
                //clear editText
                name.setText("");
                description.setText("");
            }
        });


    }


    public void populateProfileList() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        adapter.clear();
        profileList.setAdapter(adapter);

        List<Profiles> profiles = db.getAllProfile();

        for (Profiles pf : profiles) {
            listItems.add(pf.getProfileName());
            adapter.notifyDataSetChanged();
        }
    }


   /* public AddProfile() {
    }

    public String getProfileName() {
        return s_name;
    }

    public String getProfileDescription() {
        return s_description;
    }
*/
}
