# GraphSample
Implement a graphql server using graphql-java-spring-boot-starter-webmvc

# Curl commands for sample
curl --location --request POST 'localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"query ($name : String!){\n    getBookByName(name : $name) {\n        name\n        publishedDate\n        authors {\n            name\n            birthday\n        }\n    }\n}","variables":{"name":"book 1"}}'
