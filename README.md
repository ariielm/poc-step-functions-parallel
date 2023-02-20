# Step Functions Parallel POC

POC made to test if parallel calls of lambdas could be done.

## Files:

* [step_function_code.json](step_function_code.json) - Step Function which calls parallelized N [lambdas](lambda_function.py) to execute make the HTTP GET to another API
* [lambda_function](lambda_function.py) - Lambda Function that makes the HTTP Request to another API

## How-To:

1. Log in to the AWS Account
2. Execute the command to install the dependencies of the Lambda Function inside the package repository, so you are able to create the zip file with all the python dependencies: ``python -m pip install requests -t .``
3. Now, zip all the dependencies with the Python code: ``zip -r9 getClientDataBySSN .``
4. Create a lambda function with the name that is used inside the [Step Function](step_function_code.json#L17): ``getClientDataBySSN``
5. Upload the ``zip`` file created on the step 3
6. Create a Step Function and use the [Step Function Code](step_function_code.json)
7. Test it with the content inside the file [INPUT.md](INPUT.md)
8. Check on the Step Function logs if the execution was parallel
9. DONE!