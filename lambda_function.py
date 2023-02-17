import requests
import json

def lambda_handler(ssn, context):
    print(f"Evento original: {ssn}")
    client_api_url = f"https://pocarielstepfunctions.free.beeceptor.com/ssn/{ssn}"
    headers = {"Content-Type": "application/json"}

    response = requests.get(client_api_url, headers=headers)

    if response.status_code == 200:
        client = json.loads(response.text)
        return {"client_id": client["ssn"]}
    else:
        return {"error": f"Failed to fetch client data for ssn {ssn}"}
