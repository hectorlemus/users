### Requirements
- [docker](https://docs.docker.com/engine/install/ubuntu/)
- [docker-compose](https://docs.docker.com/compose/install/compose-plugin/#installing-compose-on-linux-systems)
- [java](https://openjdk.org/install/)
- [maven](https://maven.apache.org/install.html)
- [npm (node ^12.0.0)](https://nodejs.org/es/download/package-manager/)
- [angular cli](https://angular.io/cli)

<hr/>

#### Data Base

- Navigate to `docker-postgresql` directory.
- Run `docker-compose up -d` to up docker container.

<hr/>

#### Backend (Java-SpringBoot)

- Navigate to `users-api` directory.
- Run `mvn install` to install dependencies.
- Run `mvn spring-boot:run` for up a dev server.
- Navigate to `http://localhost:8080/swagger-ui.html` to see API documentation.
- See API documentation and create user status

- ![](docs/img/swagger.png?raw=true)

<hr/>

#### Frontend (Angular)

- Navigate to `users` directory.
- Run `yarn install` or `npm install` to install dependencies.
- Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`.
- ![](docs/img/front-1.png?raw=true)