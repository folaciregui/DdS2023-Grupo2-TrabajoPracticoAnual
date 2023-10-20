const express = require('express');
const app = express();
const port = 3000;

app.use(express.static(__dirname)); // Sirve archivos estáticos desde la carpeta actual

app.listen(port, () => {
    console.log(`Servidor web local ejecutándose en http://localhost:${port}`);
});
