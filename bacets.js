const AWS = require('aws-sdk');

// Configurar la región
AWS.config.update({region: 'us-east-1'});

// Crear una instancia de S3
const s3 = new AWS.S3();

// Llamar al método listBuckets
s3.listBuckets((err, data) => {
    if (err) console.log(err, err.stack); // un error ocurrió
    else console.log(data.Buckets); // éxito
});
 