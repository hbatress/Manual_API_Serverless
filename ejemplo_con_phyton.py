# lambda_function.py

def lambda_handler(event, context):
    # Registro del evento de entrada
    print('Received event:', event)

    # Procesamiento del evento
    name = event.get('name', 'Mundo')
    message = f'¡Hola, {name} desde AWS Lambda!'

    # Respuesta HTTP
    response = {
        'statusCode': 200,
        'body': {
            'message': message
        }
    }

    return response
 