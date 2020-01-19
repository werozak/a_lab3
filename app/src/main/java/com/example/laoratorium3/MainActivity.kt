package com.example.laoratorium3

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myDatabaseHelper =MyDatabaseHelper(this)
        button_wlacz.setOnClickListener{
            var permission = android.Manifest.permission.ACCESS_FINE_LOCATION
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED){
                var locationMenager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

                var locationListener = MyLocationListener()
                locationListener.myOnLocationChangeListener = {
                    myDatabaseHelper.insert(it.toString())
                    var adapter = ArrayAdapter<String>(this,R.layout.row,myDatabaseHelper.selectAll())
                    listView.adapter = adapter
                }
                locationMenager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1f, locationListener )

            }else{
                ActivityCompat.requestPermissions(this, arrayOf(permission),0)
            }

        }
        button_wylacz.setOnClickListener{
            stopService(Intent(this, MyLocationListener::class.java))

        }
    }
}
