{
    "type": "AWS_PROXY",
    "httpMethod": "POST",
    "uri": "arn:aws:apigateway:{region}:lambda:path/2015-03-31/functions/{lambdaArn}/invocations",
    "requestParameters": {
        "integration.request.header.X-Amz-Target": "'AWSStepFunctions.StartExecution'"
    }
}


{
    "usuarioId": "$input.params('id')",
    "accion": "$input.json('$.accion')"
}

{
    "Records": [
        {
            "s3": {
                "bucket": {
                    "name": "my-images-bucket"
                },
                "object": {
                    "key": "image.jpg"
                }
            }
        }
    ]
}
 

{
    "Records": [
        {
            "eventName": "INSERT",
            "dynamodb": {
                "NewImage": {
                    "id": {
                        "S": "123"
                    },
                    "nombre": {
                        "S": "Jane Smith"
                    }
                }
            }
        }
    ]
}

{
    "source": "aws.events",
    "detail-type": "Scheduled Event",
    "time": "2024-08-07T12:00:00Z",
    "region": "us-east-1"
}
