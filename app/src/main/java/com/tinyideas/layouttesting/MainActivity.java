package com.tinyideas.layouttesting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button01;
    private Button button02;
    private Button button03;
    private LinearLayout mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the main activity. This will be used to place the view stub inside before displaying it.
        mainActivity = findViewById(R.id.mainActivityParent);

        // Initializing the buttons.
        button01 = findViewById(R.id.mainButton01);
        button02 = findViewById(R.id.mainButton02);
        button03 = findViewById(R.id.mainButton03);

        button01.performClick();
    }

    /**
     * This method will be used as the click event handler for the clicks performed on any image
     * inside the grid layout. This method will simply display a toast indicating that an image
     * is clicked.
     *
     * @param view The view that is clicked will be passed as an argument. Will be an ImageView as
     *             this method is attached only to ImageViews.
     */
    public void imageClicked(View view) {
        Toast.makeText(this, "Image Clicked", Toast.LENGTH_SHORT).show();
    }

    /**
     * This method will be used as the click event handler for the table layout. Whenever any cell
     * of the table layout is clicked, this method will be evoked and will print the coordinates of
     * the cell that is clicked in a toast message.
     *
     * @param view The view that is clicked will be passed in as the parameter. Will be a TextView
     *             as this method is attached only to TextViews
     */
    public void tableCellClicked(View view) {
        Toast.makeText(this, "Click detected [" + ((TextView) view).getText().toString()
                .replace("\n", ", ") + "]", Toast.LENGTH_SHORT).show();
    }

    /**
     * This method will be attached as click event handler for all the four buttons in the main layout.
     * When any of these buttons are clicked, the layout for that button will be loaded and the background
     * for the button that is clicked will also be changed.
     *
     * @param view The view that is selected will be passed into this method as an argument
     */
    @SuppressLint("InflateParams")
    public void buttonClicked(View view) {
        // Beginning with changing the background color of the button that is selected.
        changeButtonBackground(view);
        mainActivity.removeAllViews();

        // Depending on which button is selected, displaying the required view in the ViewStub
        switch (view.getId()) {
            case R.id.mainButton01:
                // First button is selected.
                mainActivity.addView(getLayoutInflater().inflate(R.layout.layout_login, null));
                break;

            case R.id.mainButton02:
                // Second button is selected.
                mainActivity.addView(getLayoutInflater().inflate(R.layout.grid_view, null));
                break;

            case R.id.mainButton03:
                // Third button is selected.
                mainActivity.addView(getLayoutInflater().inflate(R.layout.table_layout, null));
                break;
        }
    }

    /**
     * This method will be used to change the background of the button that is clicked by the user.
     * All the buttons will be accessed, the button that was clicked will be given a gray background
     * and the rest of the buttons will be given black background.
     *
     * @param selectedButton The button that is selected. Its ID will be used to detect which button
     *                       is clicked by the user.
     */
    private void changeButtonBackground(View selectedButton) {
        if (selectedButton.getId() != button01.getId())
            // This button is not selected.
            button01.setBackgroundColor(Color.BLACK);

        if (selectedButton.getId() != button02.getId())
            // This button is not selected.
            button02.setBackgroundColor(Color.BLACK);

        if (selectedButton.getId() != button03.getId())
            // This button is not selected.
            button03.setBackgroundColor(Color.BLACK);

        // Once the un-selected buttons have their background color changed, changing the background
        // of the button that is selected.
        selectedButton.setBackgroundColor(Color.GRAY);
    }
}
