# simple-restful-crud
Bring up CRUD restful web services in Java in a moment!


With the abstractions defined in the restful-core project, you can implement CRUD(+search) web services for an entity with just implementing four classes. 
1. An entity like Student. --> implementing IEntity
2. A DAO for the entity, like StudentDao. --> implementing AbstractDao
3. A search request class for the entity, like StudentSearchReqDto. --> implementing SearchRequestDto
4. A JAX-RS service class. --> implementing AbstractCrudService

* I implemented a sample-rest project for an example.

* I added brief JavaDoc for documentation. Sorry for being so brief!

* I ran the project with apache-tomee-plume version 7.0.2 as the application server.

* I used JPA for database connection.

* Sample postman requests are available in postman.json file.

* There are some issues that I commented as //TODO: in the source files. I'll fix them later.

* Any comments are appreciated. You can contact me through nav.mojir@gmail.com
