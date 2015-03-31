var xmlHttp

function getProvincia(id_pro){
    xmlHttp=new XMLHttpRequest();
    if (xmlHttp==null){
        alert ("Tu navegador no soporta AJAX!");
        return;
    }
    today = new Date();
    id= Math.abs(Math.sin(today.getTime()));
    var url = "ajax_Provincia.jsp";
    url = url + "?id_pro=" + id_pro;
    url = url + "&id=" + id;
    xmlHttp.onreadystatechange = resultado_detalle;
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}

function resultado_detalle(){
    if (xmlHttp.readyState==4){
        document.getElementById("result_detalle").innerHTML=xmlHttp.responseText;
    }
}

