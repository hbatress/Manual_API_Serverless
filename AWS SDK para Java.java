import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Instance;
import software.amazon.awssdk.services.ec2.model.Reservation;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
 
public class ListInstances {

    public static void main(String[] args) {
        // Crear un cliente de EC2
        Ec2Client ec2 = Ec2Client.builder()
                .region(Region.US_EAST_1) // Especifica la región
                .build();

        try {
            // Crear una solicitud para describir las instancias
            DescribeInstancesRequest request = DescribeInstancesRequest.builder().build();

            // Obtener la respuesta con las instancias
            DescribeInstancesResponse response = ec2.describeInstances(request);

            // Iterar sobre las reservas y las instancias
            for (Reservation reservation : response.reservations()) {
                for (Instance instance : reservation.instances()) {
                    // Imprimir la información de la instancia
                    System.out.printf(
                            "Instance ID: %s, Instance Type: %s, State: %s%n",
                            instance.instanceId(),
                            instance.instanceType(),
                            instance.state().name()
                    );
                }
            }

        } catch (Ec2Exception e) {
            System.err.println("Error al describir las instancias: " + e.awsErrorDetails().errorMessage());
            System.exit(1);
        } finally {
            ec2.close();
        }
    }
}
