// index.js

exports.handler = async (event) => {
    // Log del evento de entrada
    console.log('Received event:', JSON.stringify(event, null, 2));

    // Procesamiento del evento
    const name = event.name || 'Mundo';
    const message = `¡Hola, ${name} desde AWS Lambda!`;

    // Respuesta HTTP
    const response = {
        statusCode: 200,
        body: JSON.stringify({ message }),
    };

    return response;
};
 