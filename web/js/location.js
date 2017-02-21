var x = document.getElementById("zenmsg");

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else {
        x.innerHTML = "Geolocation is not supported by this device.";
        x.className = "alert alert-danger";
    }
}

function showPosition(position) {
    var latlon = position.coords.latitude + "," + position.coords.longitude;

    var img_url = "http://image.maps.cit.api.here.com/mia/1.6/mapview?app_id=FepdAwq3sSVy5iSz8ofh&app_code=xZn2tPu48VdAKO1wS1X_NA&c="
    +latlon+"&h=320&w=320&z=14&f=0&style=alps";
    //FepdAwq3sSVy5iSz8ofh
    //xZn2tPu48VdAKO1wS1X_NA
    document.getElementById("mapholder").innerHTML = "<img width='320' zsize='14' onclick='zoom(this,\""+position.coords.latitude+"\",\""+position.coords.longitude+"\");'  src='"+img_url+"'>";
    document.getElementById("dataholder").innerHTML = "Latitude: <input type='text' name='latitude' id='latitude' value='"+position.coords.latitude+"'><br><br>Longitude: <input type='text' name='longitude' id='longitude' value='"+position.coords.longitude+"'><br><br><button onclick='xhrSetRide()' class='btn btn-primary'>Solicitar</button>";
}

function showError(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            x.innerHTML = "User denied the request for Geolocation.";
            x.className = "alert alert-danger";
            break;
        case error.POSITION_UNAVAILABLE:
            x.innerHTML = "Location information is unavailable.";
            x.className = "alert alert-danger";
            break;
        case error.TIMEOUT:
            x.innerHTML = "The request to get user location timed out.";
            x.className = "alert alert-danger";
            break;
        case error.UNKNOWN_ERROR:
            x.innerHTML = "An unknown error occurred.";
            x.className = "alert alert-danger";
            break;
    }
}