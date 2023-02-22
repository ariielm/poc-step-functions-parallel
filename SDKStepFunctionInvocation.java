import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.stepfunctions.StepFunctionsClient;
import software.amazon.awssdk.services.stepfunctions.model.StartExecutionRequest;
import software.amazon.awssdk.services.stepfunctions.model.StartExecutionResponse;

public class StartExecutionExample {
    public static void main(String[] args) {
        Region region = Region.US_EAST_1; // replace with your region

        String stateMachineArn = "arn:aws:states:us-east-1:123456789012:stateMachine:your-state-machine-name"; // replace with your state machine ARN

        StepFunctionsClient sfnClient = StepFunctionsClient.builder()
                .region(region)
                .build();

        String inputJson = "{\"ssns\": [\"111-22-3333\", \"444-55-6666\", \"777-88-9999\"]}"; // replace with your input JSON
        StartExecutionRequest startExecutionRequest = StartExecutionRequest.builder()
                .stateMachineArn(stateMachineArn)
                .input(inputJson)
                .build();

        StartExecutionResponse response = sfnClient.startExecution(startExecutionRequest);
        String executionArn = response.executionArn();

        System.out.println("Started Step Function execution: " + executionArn);
    }
}
