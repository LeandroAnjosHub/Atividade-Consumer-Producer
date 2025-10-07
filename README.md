# INTEGRANTES:
## Bruno Yuji Takahashi (RA: 04241032)
## Leandro Anjos (RA: 04241025)

# Producer (Java Spring Boot):

## URL do endpoint de publicação: http://localhost:8080/musicas/enviar

## Método: POST 

## Exemplo de JSON : {
##  "titulo": "Let It Be",
##  "artista": "The Beatles",
##  "genero": "Rock"
## }

## Passo a Passo para subir o ambiente:

## 1. Verificar Docker e subir o RabbitMQ (docker compose up -d)
## 2. Rodar o Producer (Java Spring)
## 3. Rodar o Consumer (npm install e npm start)
## 4. Enviar uma mensagem e verificar o fluxo -

## O que esperar no Producer:

## Resposta HTTP: 200 OK ou 201 Created.
## Corpo: {"titulo": "Jesus","artista":"Bible","genero":"Gospel"}

## 5. Verificar a mensagem no consumidor (GET localhost:80/messages)
