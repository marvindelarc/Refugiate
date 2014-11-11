var xmlHttp

function getDistrito(id_pro){
    xmlHttp=new XMLHttpRequest();
    if (xmlHttp==null){
        alert ("Tu navegador no soporta AJAX!");
        return;
    }
    today = new Date();
    id= Math.abs(Math.sin(today.getTime()));
    var url = "ajax_Distrito.jsp";
    url = url + "?id_pro=" + id_pro;
    url = url + "&id=" + id;
    xmlHttp.onreadystatechange = result_mas_detalle;
    xmlHttp.open("GET",url,true);
    xmlHttp.send(null);
}

function result_mas_detalle(){
    if (xmlHttp.readyState==4){
        document.getElementById("result_mas_detalle").innerHTML=xmlHttp.responseText;
    }
}

