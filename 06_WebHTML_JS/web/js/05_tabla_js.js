/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

console.log("Generando tabla....");
generarTabla();
function generarTabla(){
    var table = document.getElementsByTagName("table");
    table = table[0];
    table.innerHTML = "<caption>Lista de vainas</caption>";
    var nombrePrecio = "Precio";
    table.innerHTML += `
    <thead>
        <tr>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>${nombrePrecio}</th>
        </tr>
    </thead>`;
    var lista = new Array();
    lista = [["Vaina: ", "Peine", "15 €"]];
    lista[1] = ["Vaina: ", "Quitapelos", "30 €"];
    lista[2] = ["Vaina: ", "Coche", "200 €"];
    
    for (var i = 0; i < lista.length; i++) {
        var nodoTR = document.createElement("tr");
        table.appendChild(nodoTR);
        
        for (var columna of lista[i]){
            var nodoCol = document.createElement("td");
            nodoTR.appendChild(nodoCol);
            
            var textoCol = document.createTextNode(columna);
            nodoCol.appendChild(textoCol);            
        }
    }
}


