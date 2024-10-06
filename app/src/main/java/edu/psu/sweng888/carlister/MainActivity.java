package edu.psu.sweng888.carlister;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declaring the ListView that will display the list of vehicles
    private ListView vehicleListView;

    // Declaring an instance of the custom adapter (VehicleAdapter) to bind the vehicle data to the ListView
    VehicleAdapter adapter;  // Adapter for handling the display of Vehicle items in the ListView

    // Declaring a list to hold the Vehicle objects ,going to be  displayed in the ListView
    private List<Vehicle> vehicleList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleListView = findViewById(R.id.vehicleListView);

        // Initializes vehicle list
        vehicleList = generateVehicleList();

        // Set up adapter
        adapter = new VehicleAdapter(this, vehicleList);
        vehicleListView.setAdapter(adapter);

        // Set item click listener
        vehicleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Vehicle selectedVehicle = vehicleList.get(position);

                // Log to ensure correct vehicle is being selected
                Log.d("MainActivity", "Selected Vehicle: " + selectedVehicle.getName());

                // Display Snackbar
                Snackbar.make(view, "You selected " + selectedVehicle.getName(), Snackbar.LENGTH_SHORT).show();

                // Navigate to DetailActivity and expect a result
                Intent intent = new Intent(MainActivity.this, ItemDetail.class);
                intent.putExtra("vehicle", selectedVehicle);
                startActivityForResult(intent, 1);  // Use startActivityForResult to expect a result
            }
        });
    }



    private List<Vehicle> generateVehicleList() {
        List<Vehicle> list = new ArrayList<>();
        //the list with Vehicle objects
        list.add(new Vehicle("Silverado 1500", "Chevrolet", 2015, 34000, "New", "Red", R.drawable.silverado));
        list.add(new Vehicle("F-150", "Ford", 2018, 36000, "Used", "Blue", R.drawable.f150));
        list.add(new Vehicle("Ram 1500", "Dodge", 2020, 39000, "New", "Black", R.drawable.ram));
        list.add(new Vehicle("Tacoma", "Toyota", 2017, 32000, "Used", "White", R.drawable.tacoma));
        list.add(new Vehicle("Tundra", "Toyota", 2019, 40000, "New", "Gray", R.drawable.tundra));
        list.add(new Vehicle("Sierra 1500", "GMC", 2021, 42000, "New", "Silver", R.drawable.sierra));
        list.add(new Vehicle("Ranger", "Ford", 2020, 35000, "New", "Red", R.drawable.ranger));
        list.add(new Vehicle("Frontier", "Nissan", 2018, 33000, "Used", "Green", R.drawable.frontier));
        list.add(new Vehicle("Canyon", "GMC", 2017, 31000, "Used", "Black", R.drawable.canyon));
        list.add(new Vehicle("Ridgeline", "Honda", 2019, 38000, "New", "Blue", R.drawable.ridgeline));

        return list;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Checks if the result is from ItemDetail activity and if it was successful
        //Checks for two parameters, if we have visited the itemdetail page and if the user pressed the button. If it wouldn't have both requirements, then it could trigger on open or if there was other screens.
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Displays a Snackbar indicating the operation was successful, requirement 8
            Snackbar.make(vehicleListView, "Operation completed successfully", Snackbar.LENGTH_SHORT).show();
        }
    }

}