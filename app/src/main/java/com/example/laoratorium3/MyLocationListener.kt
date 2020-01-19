package com.example.laoratorium3

import android.location.Location
import android.location.LocationListener
import android.os.Bundle

class MyLocationListener: LocationListener {
    lateinit var myOnLocationChangeListener: (Float?) -> Unit


    //var distance: Double = 0.0
    var lastLocation: Location? = null

    override fun onLocationChanged(p0: Location?) {



        if (lastLocation == null) {
            lastLocation = p0
        }
        //var distance:Float? = p0?.distanceTo(lastLocation)
        var distance = lastLocation?.distanceTo(p0)
        lastLocation = p0
        myOnLocationChangeListener(distance)


    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}