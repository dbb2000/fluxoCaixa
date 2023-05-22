############ Requisitos para rodar o micro serviço: ############
- Java jdk11
- maven
- Postman

############ Considerações: ############
- O banco de dados é o H2 configurado para trabalhar em memória.
- Após o start do serviço, o saldo sempre inicia com R$ 0,00.
- Importe o arquivo "FluxoCaixa.postman_collection.json" no Postman com a coleção de chamadas prontas para utilização

############ Instalação: ############
Para instalação, execute o seguinte comando dentro da pasta do projeto:
mvn install

############ Execução: ############
Para rodar o micro serviço, digite:
mvn spring-boot:run

############ Lista de endPoints: ############

GET: http://localhost:8080/lancamentos/"idLancamento"
	- para consultar um único lançamento

POST: http://localhost:8080/lancamentos
	- para inserir um lançamento.
Exemplo do body:
{
    "dataLancamento": "18-05-2023",
    "descricao": "padaria",
    "valor": 120.00,
    "tipoEntrada": "CREDITO"
}	

PUT: http://localhost:8080/lancamentos/"idLancamento"
	- para alterar um determinado lançamento
Exemplo do body:
{
    "dataLancamento": "18-05-2023",
    "descricao": "padaria",
    "valor": 120.00,
    "tipoEntrada": "CREDITO"
}

GET: http://localhost:8080/consolidado/"dataConsolidado"
	- para obter o extrato consolidado junto com o saldo
	Formato de data: 'dd-mm-aaaa'
	