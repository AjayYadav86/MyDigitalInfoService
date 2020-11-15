const AWS = require("aws-sdk");
const documentClient = new AWS.DynamoDB.DocumentClient();

/*Function To Handle the GET request by Customer ID*/
exports.handler = async event => {
  
  let customerId = event.id;
  let response = {statusCode: 400}
  const params = {
    TableName: "CustomerInfo", 
    Key: {
      customerId: customerId
    }
  };
  try {
    const data = await documentClient.get(params).promise();
    /*Return Statuc Code 200 if data Found*/
    if(data.customerId!== null)
    {
      response = {
                "name": data.Item.name,
                "city": data.Item.city,
                "customerId": data.Item.customerId,
                "emailAddress": data.Item.emailAddress,
                "phoneNumber": data.Item.phoneNumber,
                "state": data.Item.state,
                "zipcode": data.Item.zipcode
                }
      }
    return response;
  } catch (e) {
    return {
      statusCode: 500,
      "body": customerId
    };
  }
};