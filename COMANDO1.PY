import boto3

# Crear un cliente de EC2
ec2 = boto3.client('ec2')

# Llamar al método describe_instances
response = ec2.describe_instances()

# Imprimir la respuesta
for reservation in response['Reservations']:
    for instance in reservation['Instances']:
        print(instance['InstanceId'], instance['InstanceType'])
  