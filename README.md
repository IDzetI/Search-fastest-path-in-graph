# Prim-algorithm

Example implementation Prim's algorithm on java. In this example, the prim's algorithm is used to create a minimal spanning tree. Which helps optimize the tree. This allows you to reduce the amount of stored data.


<b>Statement</b><br>
You are working in delivery company "LHD". Your company's first priority is speed of delivery. So, each time you are looking for the route for delivery, you select the fastest one. 
Now you are building the information system for customers, that estimates time and cost of delivery. Your database is undirected loopless graph with no parallel edges of roads which has information about distance (in km), time (in hours) and cost (in rubles/kilogram) of travelling between two points. This graph is stored in russia.txt file in the following format: 
<br><br>
russia.txt
```
VertexA VertexB VertextC
VertextA VertexB dist:time:cost VertextC VertexB dist:time:cost
```
<br>
For example: 

russia.txt
```
Бабяково Коньково Свиблово
Бабяково Коньково 120.0:4.3:100.50 Свиблово Коньково 220.0:4.0:10.0 Свиблово Бабяково 1000.0:400.0:1000.0
```
Means that there are 120.0 km between Бабяково and Коньково, time to travel is 4.3 hours, and one kilogram delivery will cost 100.5 rubles. 
Having this graph you can estimate delivery time and costs for you clients. You are given input.txt with requests in each line: 

input.txt
```
Бабяково Свиблово 10.0
Бабяково Коньково 5.0
```
Means clients are going to deliver 10 kilos from Бабяково to Свиблово and 5 kilos from Бабяково to Коньково. 



