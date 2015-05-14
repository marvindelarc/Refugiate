/* [ ---- Gebo Admin Panel - location finder ---- ] */

	
    g_Map = $('#g_map');



	// marker callback after drag end
    function marker_callback(marker) {
        $('#txtLatiud').val(marker.position.lat().toFixed(6));
        $('#txtLongitud').val(marker.position.lng().toFixed(6));
        g_Map.gmap3({
            action: 'getAddress',
            latLng: marker.getPosition(),
            callback: function(results){
                $('#txtDireccion').val(results[0].formatted_address);
            }
        });
    };
    
    gebo_maps = {
        
        search_location: function(search_query) {
            //* drop marker on map after location search
            
            if(search_query != ''){
                //g_Map.gmap3('destroy').remove();
                g_Map.gmap3(
                    {
                        action: 'clear',
                        name: 'marker'
                    },
                    {   action: 'addMarker',
                        address: search_query,
                        map: {
                            center:true,
                            zoom: 13
                        },
                        marker: {
                            
                           options: { 
                               draggable: true
                           },
                            events: {
                                dragend: function(marker){
                                    marker_callback(marker);
									g_Map.gmap3('get').panTo(marker.position);
                                }
                            }
                        }
                    }
                )
            } else {
                $.gritter.add({
                                                // (string | mandatory) the heading of the notification
                                                title: 'Mensaje',
                                                // (string | mandatory) the text inside the notification
                                                text: "Por favor Ingresa una ubicación."
                                        }); 
            }
        }
        
        
        
    };