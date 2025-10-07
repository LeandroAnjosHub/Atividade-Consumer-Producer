# INTEGRANTES:
## Bruno Yuji Takahashi (RA: 04241032)
## Leandro Anjos (RA: 04241025)

# Producer (Java Spring Boot):

## URL do endpoint de publicação: http://localhost:8080/musicas/enviar

## Método: POST 

## Exemplo de JSON: {} : {
##  "titulo": "Let It Be",
##  "artista": "The Beatles",
##  "genero": "Rock"
## }

## Passo a Passo para subir o ambiente:

## 1. Verificar Docker e subir o RabbitMQ 
## 2. Rodar o Producer (Java Spring)
## 3. Rodar o Consumer (Node.js)
## 4. Enviar uma mensagem e verificar o fluxo -

## O que esperar no Producer:

## Resposta HTTP: 200 OK ou 201 Created (depende da sua implementação).
## Corpo: pode ser algo como { "status": "ok", "mensagem": "enviada" } — adapte se seu código retornar outra coisa.

## 5. Verificar a mensagem no consumidor (ENDPoint)
