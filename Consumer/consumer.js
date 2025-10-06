const express = require('express');
const amqp = require('amqplib');
const app = express();
var path = require("path");
const port = 8080;

var mensagem = [];

async function consumeMessage() {
    try {
        const connection = await amqp.connect('amqp://localhost');
        const channel = await connection.createChannel();
        const queue = 'music_queue';

        await channel.assertQueue(queue, { durable: false });
        console.log(`Aguardando mensagens em ${queue}.`);

        channel.consume(queue, (msg) => {
            if (msg.content) {
                const messageContent = msg.content.toString();
                console.log(`Mensagem recebida: '${messageContent}'`);
                mensagem = messageContent;
            }
        }, { noAck: true });
    } catch (error) {
        console.error('Erro ao consultar o RabbitMQ:', error);
    }
}

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, "public")));

app.get('/messages', (req, res) => {
    res.json(mensagem);
    mensagem = []
});

app.listen(port, () => {
    console.log(`Server listening at http://localhost:${port}`);
    consumeMessage();
});