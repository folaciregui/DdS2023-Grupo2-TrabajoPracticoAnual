function myFunction(persona) {
    alert("Hola " + persona.nombre)
}

var per = {"nombre":"fran", "id":2}

myFunction(per)

console.log(per)
fetch('http://localhost:3000/api/entidades')
    .then(responseHttp => {
        if (responseHttp.status >= 400) {
            alert("Hubo un error en el API")
        } else {
            return responseHttp.json()
        }
    })
    .then(listaDeEntidades => {
        console.log(listaDeEntidades)
        var a = 5000 + 6
        console.log(a)
    })


var a = 5 + 6 + "A"
console.log(a)
