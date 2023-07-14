
# CSV File Processing and Database Storage ~ Wio Assignment



Given would be a large CSV file.

-  Each entry of the CSV would contain 3 values:
   - paymentId
   - customerId
   - paymentType
-  Add each CSV entry to the DB
- Timestamp of each transaction should also be added to the DB, which will be **createdAt**
- 5 minutes after every entry is added to the table, a service should run which would return a random boolean.
- This boolean should also be stored in the DB as the **verified** attribute.
- At the time verified attribute is added to the table, **modifiedAt**  field should also be updated.


**Schema would like this**

| Column | Data Type| Description |
| --------- | --------- | --------- |
| customerID | int | Customer ID |
| paymentType | varchar(50) | Payment type |
| paymentID | int | Payment ID |
| created_at | timestamp  | Creation timestamp |
| verified | boolean |Verification status |
| modified_at | timestamp | timestamp of modification of Verification status |





## **Java API**

### Read CSV
```
const API_PATH   : '/payments/processCsvData'
const API_METHOD : 'POST'

export type response = true/false
```

### Get payment verification status
```
const API_PATH   : 'payment/getVerificationStatus'
const API_METHOD : 'GET'

export type request = {
  paymentId      : String
}

export type response = {
  customerId    : String
  paymentType   : number
  verified      : boolean
  createdAt     : String
}
```
***


