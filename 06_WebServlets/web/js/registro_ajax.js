window.onload = function(){
    var btn_reg = document.getElementById("btn_registro_ajax");
    
    btn_reg.onclick = function(){
        var nombre = document.getElementById("nombre").value;
        var edad= document.getElementById("edad").value;
        var email = document.getElementById("email").value;
        var activo = document.getElementById("activo").checked;
        activo = activo ? "on" : "off";
        
        var cliente = {
            "nombre":nombre,
            "edad" : edad,
            "email" : email,
            "activo" : activo
        };
        
        var clienteJSON = JSON.stringify(cliente);
        alert("Enviando...\n" + clienteJSON);
        
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/registro", true);
        xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
        
	var cli = JSON.parse(xhr.responseText);
	if (xhr.readyState === 4 && xhr.status === "201") {
		console.table(cli);
	} else {
		console.error(cli);
	}    
        xhr.send(clienteJSON);
        
    };
};


