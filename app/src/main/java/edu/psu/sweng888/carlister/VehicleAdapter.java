package edu.psu.sweng888.carlister;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

//the vehicle adapter binds a list of vehicle obejcts to the listview
public class VehicleAdapter extends ArrayAdapter<Vehicle> {
    private Context context;
    private List<Vehicle> vehicles;

    // Constructor to initialize the adapter with the context and list of vehicles

    public VehicleAdapter(Context context, List<Vehicle> vehicles) {
        super(context, 0, vehicles);
        this.context = context;
        this.vehicles = vehicles;
    }
    // Overriding the getView method to provide the view for each item in the ListView


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vehicle vehicle = vehicles.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_vehicle_item, parent, false);
        }
        // Bind the vehicle data (name and manufacturer) to the list TextViews

        TextView nameTextView = convertView.findViewById(R.id.vehicleName);
        TextView manufacturerTextView = convertView.findViewById(R.id.vehicleManufacturer);

        nameTextView.setText(vehicle.getName());
        manufacturerTextView.setText(vehicle.getManufacturer());

        return convertView;
    }
}