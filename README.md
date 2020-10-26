# Test-task

## Table of Contents
* [Project description](#description)
* [Project structure](#structure)
* [Author](#author)

### <a name="description"></a>Project description

This project based on Spring Boot, Spring Data + Hibernate H2 database (File storing mode)<br>
  1. Spring Security -> Two roles (USER/ADMIN/OWNER)
     - Login/Registration as a user (encode password in db)
     - Add/remove ADMIN rights to/from users can only OWNER (we need to hardcode one OWNER in db) 
     - Owner can block users. So they will not have a possibility to call APIs
  2. Data Model User->OneToOne->Account->OneToMany->Orders (simple data, few fields -> productName, amount etc)
     - User get can create an order and get/update/delete own. (Can not update/delete orders of other users)
     - Admin/Owner can get/update/delete all orders
<hr>

### <a name="structure"></a>Project structure

- java 11
- maven 4.0.0
- spring-boot 2.3.4.RELEASE
- lombok 1.18.12
- hibernate-validator 6.1.5.Final
- jjwt 0.9.1
- h2 1.4.200
- springfox-swagger2 2.9.2

<hr>

### <a name='author'></a>Author
[Serhii Kinashchuk](https://github.com/serg-ksv)
