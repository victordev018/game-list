# Game List

Aplicação backend para organizar jogos em coleções, sendo cada uma delas com gênero diferente.

## Tecnologias:

- Java
- Spring Boot
- JPA
- Maven
- Docker
- Postman

## Funcionalidades:

### Endpoints referentes a Lista de Jogos:

- Buscar todas as coleções de jogos:

```
GET {url-application}/lists

Resposta:

[
    {
        "id": 1,
        "name": "Aventura e RPG"
    },
    {
        "id": 2,
        "name": "Jogos de plataforma"
    }
]
```

- Buscar jogos de uma lista por *id*:

```
GET {url-application}/lists/{listId}/games

Resposta:

[
    {
        "id": 6,
        "title": "Super Mario World",
        "year": 1990,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/6.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    },
    {
        "id": 7,
        "title": "Hollow Knight",
        "year": 2017,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/7.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    }
]
```

- Alterar a posição de um jogo dentro de uma lista:

```
POST {url-application}/lists/{listId}/replacement

Corpo da Requisição em JSON:

{
    "sourceIndex" : 0,
    "destinationIndex" : 1
}
```

### Endpoints referentes aos Jogos:

- Buscar jogo por __id__

```
GET {url-application}/games/{gameId}

Resposta:

{
    "id": 10,
    "title": "Sonic CD",
    "year": 1993,
    "genre": "Platform",
    "platforms": "Sega CD, PC",
    "score": 4.0,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/10.png",
    "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!",
    "longDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa."
}
```

- Buscar todos os jogos cadastrados:

```
GET {url-application}/games

Resposta:

[
    {
        "id": 1,
        "title": "Mass Effect Trilogy",
        "year": 2012,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    },
    {
        "id": 2,
        "title": "Red Dead Redemption 2",
        "year": 2018,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    },
    {
        "id": 3,
        "title": "The Witcher 3: Wild Hunt",
        "year": 2014,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    }
]
```

## Modelo de Domínio:

![domain model image](https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/dslist-model.png)

## Aprendizados:

Desenvolver este projeto me ajudou a reforçar conceitos importantes no desenvolvimento de *API REST* e utilizar o *JPA* para persistir dados,
mapear as entidades e trabalhar com relacionamentos *Muitos para Muitos*, além de dar por em prática minha lógica de programação, desenvolvendo os
recursos da aplicação.

