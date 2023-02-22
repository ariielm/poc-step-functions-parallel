import requests
import json

class MyCustomException(Exception):
    pass

def lambda_handler(ssn, context):
    client_api_url = f"https://pocarielstepfunctions.free.beeceptor.com/ssn/{ssn}"
    headers = {"Content-Type": "application/json"}

    response = requests.get(client_api_url, headers=headers)

    if response.status_code == 200:
        client = json.loads(response.text)
        return {"client_id": client["ssn"]}
    else:
        raise MyCustomException(f"Failed to fetch client data for ssn {ssn}")
