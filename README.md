# Fiducial
* This project uses:
  * Spring 3
  * Java 17
  * Swagger
  * Postgres
  * Ehcache | Jcache

### Requirements list:

We want you to build a rest endpoint that will
1. Insert the list of names in the database
2. List all the names in the database 
3. Search for a name and returns true or false if exists or not
4. Don’t allow duplicated names
5. Create the required unit tests

### Names API | Endpoints:

* GET http://localhost:8080/fiducial/names/pageable?page=0&size=20
  * Parameters:
    * page (integer)(query) - Default value = 0
    * size (integer)(query) - Default value = 10
  * Response:
    * ![img.png](img.png)
    
* GET http://localhost:8080/fiducial/names/exist/{name}
  * Parameter:
    * name *required (string)(path)
  * Response:
    * ![img_1.png](img_1.png)
    
* POST http://localhost:8080/fiducial/names
  * Request body *require (application/json):
    * ![img_2.png](img_2.png)

### Features to improve performance
* We're using pagination in GET/fiducial/names/pageable
* We are using cache in Entity Name.

### Video with swagger demonstration:
* [![screen-swagger.git](screen-swagger.gif)](screen-swagger.gif)


