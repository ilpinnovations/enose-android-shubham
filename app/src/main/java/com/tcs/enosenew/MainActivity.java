package com.tcs.enosenew;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.provider.SyncStateContract;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;


import com.tcs.enosenew.services.TimerTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {


    NavigationView navigationView=null;
    Toolbar toolbar=null;
    private static DrawerLayout drawerLayout;
    private Switch toggleButton, connectToggleButton;
   // private LinearLayout buttonBarLayout;
    private BluetoothAdapter bluetoothAdapter;
    private static final int REQUEST_CODE_BLUETOOTH_SETTINGS = 1;
    private static final int REQUEST_CODE_ENABLE_BLUETOOTH = 0;
    private AlertDialog alertDialog;
    private OutputStream outputStream;


    Thread workerThread;
    byte[] readBuffer;
    int readBufferPosition;
    int counter;
    volatile boolean stopWorker;
    InputStream mmInputStream;

    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        connectToggleButton = (Switch) findViewById(R.id.connect_toggle_btn);
      //  buttonBarLayout = (LinearLayout) findViewById(R.id.btn_bar_layout);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        connectToggleButton.setOnCheckedChangeListener(connectToggleListener);
    }


    // Call back to connect to device and enable bluetooth
    private CompoundButton.OnCheckedChangeListener connectToggleListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b){
                // The toggle is enabled
             //   sendMessage(SyncStateContract.Constants.TEXT_SAMPLES.QUERY_ENABLE_BT);
                compoundButton.setText("Disconnect");
               // buttonBarLayout.setVisibility(View.VISIBLE);
                if (!bluetoothAdapter.isEnabled()) {
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, REQUEST_CODE_ENABLE_BLUETOOTH);
                   // showAlertForBluetoothDevices();
                } else {
                    showAlertForBluetoothDevices();
                    Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
                }
            }else {
                // The toggle is disabled
             //   sendMessage(SyncStateContract.Constants.TEXT_SAMPLES.QUERY_DISABLE_BT);
                compoundButton.setText("Connect");

                bluetoothAdapter.disable();

            }
        }
    };


    private void showAlertForBluetoothDevices() {
        // Prepare grid view


        ListView listView = new ListView(this);

        List<Integer> mList = new ArrayList<Integer>();

        Set<BluetoothDevice> bondedDevices  = bluetoothAdapter.getBondedDevices();
        ArrayList<String> bluetoothList = new ArrayList<>();
        for (BluetoothDevice device: bondedDevices){
            bluetoothList.add(device.getName() + "\n" + device.getAddress());
        }

        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, bluetoothList));
        listView.setOnItemClickListener(btListClickListener);

        // Set grid view to alertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(listView);
        builder.setTitle("Bluetooth");
        builder.setMessage("Select from the list of paired devices.\n");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        builder.setPositiveButton("Add", pairButtonListener);
        builder.setNegativeButton("Cancel", cancelButtonListener);
        alertDialog = builder.show();
    }

    private DialogInterface.OnClickListener pairButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            Intent bluetoothSettingsIntent = new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
            startActivityForResult(bluetoothSettingsIntent, REQUEST_CODE_BLUETOOTH_SETTINGS);
        }
    };

    private DialogInterface.OnClickListener cancelButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            alertDialog.cancel();
            connectToggleButton.setChecked(false);
        }
    };
    private AdapterView.OnItemClickListener btListClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // sending frequency to device
            TextView textView = (TextView) view;
            String deviceDetails = textView.getText().toString();
            String deviceName = deviceDetails.split("\n")[0];
            String deviceAddress = deviceDetails.split("\n")[1];
            Set<BluetoothDevice>  bondedDevices = bluetoothAdapter.getBondedDevices();

          /*  for (BluetoothDevice device: bondedDevices){
                if(device.getAddress()==deviceAddress){
                    mmDevice=device;
                }
            }
*/
             Log.d("ff", "Device Name: " + deviceName + "\nDevice Address: " + deviceAddress);
            alertDialog.cancel();

            try {
                init(i);
            } catch (IOException e) {
                e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Unable to connect to connect to device " + deviceName + ".\nUnavailable", Toast.LENGTH_SHORT).show();
                connectToggleButton.setChecked(false);
            }
              


        }
    };



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_CODE_ENABLE_BLUETOOTH:
                if (resultCode == RESULT_OK){

//                  Toast.makeText(getApplicationContext(), "Turned on",Toast.LENGTH_LONG).show();
                    showAlertForBluetoothDevices();
                }else {
                    Toast.makeText(getApplicationContext(), "Unable to turn on bluetooth. Try again!",Toast.LENGTH_LONG).show();
                    connectToggleButton.setChecked(false);
                }
                break;

            case REQUEST_CODE_BLUETOOTH_SETTINGS:
                showAlertForBluetoothDevices();
                break;
        }
    }




    private void init(int position) throws IOException {
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

                if(bondedDevices.size() > 0) {
                    Object[] devices = (Object []) bondedDevices.toArray();
                    BluetoothDevice device = (BluetoothDevice) devices[position];
                    ParcelUuid[] uuids = device.getUuids();
                    Log.d("ff", "in init() | device_name: " + device.getName());
                    BluetoothSocket socket = device.createRfcommSocketToServiceRecord(uuids[0].getUuid());
                    socket.connect();
                    outputStream = socket.getOutputStream();
                }

                Log.d("ff", "No appropriate paired devices.");
            } else {
                Log.d("ff", "Bluetooth is disabled.");
            }
        }
    }




    void beginListenForData() throws IOException {

        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); //Standard SerialPortService ID

        Log.d("ff", "device started listening " + mmDevice.getAddress());

        mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
        mmSocket.connect();

        mmInputStream = mmSocket.getInputStream();



        final Handler handler = new Handler();
        final byte delimiter = 10; //This is the ASCII code for a newline character

        stopWorker = false;
        readBufferPosition = 0;
        readBuffer = new byte[1024];
        workerThread = new Thread(new Runnable()
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !stopWorker)
                {
                    try
                    {
                        int bytesAvailable = mmInputStream.available();
                        if(bytesAvailable > 0)
                        {
                            byte[] packetBytes = new byte[bytesAvailable];
                            mmInputStream.read(packetBytes);
                            for(int i=0;i<bytesAvailable;i++)
                            {
                                byte b = packetBytes[i];
                                if(b == delimiter)
                                {
                                    byte[] encodedBytes = new byte[readBufferPosition];
                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                    final String data = new String(encodedBytes, "US-ASCII");
                                    readBufferPosition = 0;

                                    handler.post(new Runnable()
                                    {
                                        public void run()
                                        {
                                           // Toast.makeText(getApplicationContext(), "DD "+data,Toast.LENGTH_LONG).show();


                                        }
                                    });
                                }
                                else
                                {
                                    readBuffer[readBufferPosition++] = b;
                                }
                            }
                        }
                    }
                    catch (IOException ex)
                    {
                        stopWorker = true;
                    }
                }
            }
        });

        workerThread.start();
    }


    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            if (exit) {
                finish(); // finish activity
            } else {
                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                TimerTask task = new TimerTask();
                task.stoptimertask();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            MainFragment fragment = new MainFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.readings) {
            ReadingsFragment fragment = new ReadingsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.graphview) {
            GgraphFragment2 fragment = new GgraphFragment2();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
