package edu.psu.sweng888.carlister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class ItemDetail extends AppCompatActivity {

    // Declare UI elements for the vehicle details and the home button
    private ImageView vehicleImage; // ImageView to display the image of the selected vehicle
    private TextView vehicleName, vehicleManufacturer, vehicleYear, vehicleMileage, vehicleCondition, vehicleColor; // TextViews for displaying various vehicle details
    private Button buttonHome; // Button to navigate back to the home screen (MainActivity)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Initializse the UI components by linking them to their corresponding views in the layout
        vehicleImage = findViewById(R.id.vehicleImage); // ImageView for the vehicle image
        vehicleName = findViewById(R.id.vehicleName); // TextView for the vehicle name
        vehicleManufacturer = findViewById(R.id.vehicleManufacturer); // TextView for the vehicle manufacturer
        vehicleYear = findViewById(R.id.vehicleYear); // TextView for the vehicle year
        vehicleMileage = findViewById(R.id.vehicleMileage); // TextView for the vehicle mileage
        vehicleCondition = findViewById(R.id.vehicleCondition); // TextView for the vehicle condition (New, Used, etc.)
        vehicleColor = findViewById(R.id.vehicleColor); // TextView for the vehicle color
        buttonHome = findViewById(R.id.buttonHome); // Button to return to the home screen

        // Get Vehicle object from intent
        Vehicle vehicle = (Vehicle) getIntent().getSerializableExtra("vehicle");
        if (vehicle != null) {
            Log.d("ItemDetail", "Received Vehicle: " + vehicle.getName());
            // Continue setting the data to the views...
        } else {
            Log.e("ItemDetail", "Vehicle data not received.");
        }
        //checks to make sure vehicle params aren't null
        if (vehicle != null) {
            vehicleImage.setImageResource(vehicle.getImageResourceId());
            vehicleName.setText(vehicle.getName());
            vehicleManufacturer.setText("Manufacturer: " + vehicle.getManufacturer());
            vehicleYear.setText("Year: " + vehicle.getYear());
            vehicleMileage.setText("Mileage: " + vehicle.getMileage() + " miles");
            vehicleCondition.setText("Condition: " + vehicle.getCondition());
            vehicleColor.setText("Color: " + vehicle.getColor());

            // Shows the snackbar in the ItemDetail activity, indicating the selected vehicle
            Snackbar.make(findViewById(android.R.id.content), "Viewing details for " + vehicle.getName(), Snackbar.LENGTH_SHORT).show();
        } else {
            // If no vehicle is received, log an error or show a fallback message
            Snackbar.make(findViewById(android.R.id.content), "No vehicle data found.", Snackbar.LENGTH_SHORT).show();
        }
        //Creating an intent to return back to the list view of cars
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the result to RESULT_OK to indicate a successful operation
                setResult(RESULT_OK);

                // Finish the current activity and return to MainActivity (no need to start MainActivity again)
                finish();
            }
        });

    }
}