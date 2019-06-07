var variable;
var boolean;

boolean = 5;
variable = "Otra cosa";

interface Tiempo {
    dia: number,
    mes: number,
    anio: number
}

var miCumple: Tiempo = {dia:10, mes:5, anio:1978};

function recibeDatos(datos:string){
    console.log(datos);
}

recibeDatos("cadena");
recibeDatos(20);