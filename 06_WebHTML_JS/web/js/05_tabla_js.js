/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";
console.log("Generando tabla....");

var lista = new Array();
lista = [["Vaina: ", "Peine", "15 €", 7]];
lista[1] = ["Vaina: ", "Quitapelos", "30 €", 5];
lista[2] = ["Vaina: ", "Coche", "200 €", 4];

generarTabla();

function generarTabla() {
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
            <th>Stock</th>
        </tr>
    </thead>`;

    for (var i = 0; i < lista.length; i++) {
        var nodoTR = document.createElement("tr");
        table.appendChild(nodoTR);

        for (var columna of lista[i]) {
            var nodoCol = document.createElement("td");
            nodoTR.appendChild(nodoCol);

            var textoCol = document.createTextNode(columna);
            nodoCol.appendChild(textoCol);
        }
    }
}

function aniadirFila() {
    var nombre = document.getElementById("vaina").value;
    var producto = document.getElementById("prod").value;
    var precio = document.getElementById("precio").value;
    var stock = document.getElementById("stock").value;
    
    var datosFila = [nombre, producto, precio, stock];
    var fila = document.createElement("tr");
    
    for (var i = 0; i < datosFila.length; i++) {
        var columna = document.createElement("td");
        var text = document.createTextNode(datosFila[i]);
        columna.appendChild(text);  
        fila.appendChild(columna);
    }
    
    var tabla = document.getElementsByTagName("table")[0];
    tabla.appendChild(fila);
}

function aniadirFila2() {

    var nombre = document.getElementById("vaina").value;
    var producto = document.getElementById("prod").value;
    var precio = document.getElementById("precio").value;
    var stock = document.getElementById("stock").value;

    lista[lista.length] = [nombre, producto, precio, stock];  
    generarTabla();
}

function aniadirFila3(){   
    var nombre = document.getElementById("vaina").value;
    var producto = document.getElementById("prod").value;
    var precio = document.getElementById("precio").value;
    var stock = document.getElementById("stock").value;
    
    var tabla = document.getElementsByTagName("table")[0];
    tabla.innerHTML += `<tr>
        <td>${nombre}</td>
        <td>${producto}</td>
        <td>${precio}</td>
        <td>${stock}</td>
    </tr>`;
}

