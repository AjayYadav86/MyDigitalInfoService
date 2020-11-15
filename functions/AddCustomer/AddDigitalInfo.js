const AWS = require("aws-sdk");
const crypto = require("crypto");
const generateUUID = () => crypto.randomBytes(16).toString("hex");
const documentClient = new AWS.DynamoDB.DocumentClient();

exports.handler = async event => {
  let customerId = generateUUID();
  const params = {
    TableName: "CustomerInfo", // The name of your DynamoDB table
    Item: { // Creating an Item with a unique id and with the passed title
      customerId: customerId,
      name: event.name,
      addressLine: event.addressLine,
      city: event.city,
      state: event.state,
      zipcode: event.zipCode,
      phoneNumber: event.phoneNumber,
      emailAddress: event.emailAddress,
      creatdDate: Math.floor(new Date().getTime() / 1000.0)
    }
  };
  try {
    const data = await documentClient.put(params).promise();
    const response = {
      statusCode: 200,
      customerId: customerId
    };
    return response; // Returning a 200 if the item has been inserted 
  } catch (e) {
    return {
      statusCode: 500,
      body: JSON.stringify(e)
    };
  }
};