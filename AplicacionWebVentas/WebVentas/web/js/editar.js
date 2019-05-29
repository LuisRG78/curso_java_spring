//Esta función es callback porque es llamada cuando el usuario hace click
var alPulsarModificar = function(){
    //se llama a este método para cifrar la password
    antesDeEnviar();
    var nombre = document.getElementById("nombre").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password_encrip").value;
    var edad = document.getElementById("edad").value;
    var activo = document.getElementById("activo").checked;
    activo = activo ? "on" : "off";
    
    var cliente = {
        "nombre" : nombre,
        email : email,
        'edad' : edad
    };
    cliente.password = password;
    cliente["activo"] = activo;
    //convertimos el objeto a JSON
    var clienteJSON = JSON.stringify(cliente);
    alert("Enviando...\n" + clienteJSON);
    
    var peticionHTTP = new XMLHttpRequest();//Creamos el Objeto para hacer la petición AJAX
    // ActiveX para IE7
    //¿Que tiene que hacer al recibir la respuesta? (función callback)
    //Esta funcion anonima se la estamos asignando como un metodo a la propiedad onreadtstatechange
    //del objeto XMLHttpRequest. Es una funcion callback que se invoca cada vez que cambia de estado
    peticionHTTP.onreadystatechange = function(){
        //alert("Ha cambiado de estado");
        //readyState -> estado interno del objeto XMLHttpRequest
        if(this.readyState === 4 && this.status === 200){
            //alert("Hemos recibido algo" + this.responseText);
            var jsonResp = this.responseText;
            var objResp = JSON.parse(jsonResp);
            alert("Email recibido? " + objResp.email +  " y el nombre es: " + objResp["nombre"]);
            console.log(">>>>>>> " + jsonResp);
            var divInfo = document.getElementById("div_info");
            divInfo.style = "display: block";
            document.getElementById("span_id").innerHTML = objResp.id;
            document.getElementById("span_nombre").innerHTML = objResp.nombre;
            document.getElementById("span_email").innerHTML = objResp.email;
            document.getElementById("span_password").innerHTML = objResp.password;
            document.getElementById("span_edad").innerHTML = objResp.edad;
            document.getElementById("span_activo").innerHTML = objResp.activo;
            
            document.getElementById("insertarHtml").innerHTML = "<p>Nombre: " + objResp.nombre + "</p><p>Email: " + objResp.email +
                "</p><p>Edad: " + objResp.edad + "</p><p>Activo: " + objResp.activo + "</p><p>Password: " + objResp.password + "</p>";
        }/* else {
            alert("Aún no hemos recibido nada");
        }*/
        
    };
    //Definimos la petición. Hay que ponerlo con ruta relativa
    peticionHTTP.open("POST", "clientes2.do", true);
    peticionHTTP.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    //Convertimos el formulario en datos para enviar
    var form1 = document.getElementById("form1");
    var formData = new FormData(form1);
    var cadenaEnvio = "nombre=" + encodeURIComponent(document.getElementById("nombre").value) +
            "&email=" + encodeURIComponent(document.getElementById("email").value) +
            "&password_encrip=" + encodeURIComponent(document.getElementById("password_encrip").value) +
            //ver linea 10
            "&activo=" + encodeURIComponent(activo) +
            "&edad=" + encodeURIComponent(document.getElementById("edad").value);
    
    alert("Qué se va a enviar?\n" +cadenaEnvio);
    //Lanzamos la petición
    peticionHTTP.send(cadenaEnvio);
    
};

//document.getElementById("btn_modificar").addEventListener("click", alPulsarModificar);
document.getElementById("btn_modificar").onclick = alPulsarModificar;
