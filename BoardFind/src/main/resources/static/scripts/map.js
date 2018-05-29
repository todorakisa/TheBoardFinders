function initMap() {
    var center = {lat: 42.662369, lng:  23.373397};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: center
    });
    var marker = new google.maps.Marker({
        position: center,
        map: map,
        draggable: true
    });

    google.maps.event.addListener(marker, 'dragend', function(evt){
        document.getElementById('mapEnd1').value = evt.latLng.lat().toFixed(3);
        document.getElementById('mapEnd2').value = evt.latLng.lng().toFixed(3);

    });

    google.maps.event.addListener(myMarker, 'dragstart', function(evt){
        document.getElementById('mapEnd1').value = "";
        document.getElementById('mapEnd2').value = "";
    });

    map.setCenter(marker.position);
    myMarker.setMap(map);
}