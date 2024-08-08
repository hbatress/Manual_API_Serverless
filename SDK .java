import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Reservation;

public class ListInstances {
    public static void main(String[] args) {
        Ec2Client ec2 = Ec2Client.create();

        DescribeInstancesRequest request = DescribeInstancesRequest.builder().build();
        DescribeInstancesResponse response = ec2.describeInstances(request);

        for (Reservation reservation : response.reservations()) {
            reservation.instances().forEach(instance -> {
                System.out.println(instance.instanceId() + " " + instance.instanceType());
            });
        }
    }
}
