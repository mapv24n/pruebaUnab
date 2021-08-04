     
var SecuenciaID = null
var imagen = 0
var duracion = 1000    
{
imagenes = new CreaArray(4)
imagenes[1].src = "img/elbicho.jpg"
imagenes[2].src = "img/laPulga.jpg"
imagenes[3].src = "img/luchoDiaz.jpg"
imagenes[4].src = "img/pele.jpg"
}    
function CreaArray(n) {
    this.length = n
    for (var i = 1; i<=n; i++) {
        this[i] = new Image()
    }
    return this
}    
function MostrarSecuencia() {
    {
        console.log(document.images["secuencia"]);
        document.images["secuencia"].src = imagenes[imagen].src
        imagen++
        if ( imagen == 5 )
            imagen = 1
    }
    SecuenciaID = setTimeout("MostrarSecuencia()", duracion)
    SecuenciaEjecutandose = true
}    
function IniciarSecuencia() {
    imagen = 1
    MostrarSecuencia()
}