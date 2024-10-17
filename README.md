# Hibernate
This code is  how to register and login customers using Hibernate for database interactions.

Customer Entity:

Customer: A class representing a table in the database. It has fields for id, name, username, and password. The @Entity and @Table annotations define it as a database table.
Getters and setters allow us to access and modify these fields.

CustomerService Class:

SessionFactory: It's used to connect to the database. It reads configuration from hibernate.cfg.xml.
customerRegistration(): This method collects user details (name, username, password), creates a Customer object, and saves it to the database.
loginCustomer(): This method prompts for username and password, checks them against the database, and displays a welcome message if valid, otherwise shows an error.
MainCustomer Class:

The main class that drives the program. It provides a menu for the user to either:
Register (option 1)
Login (option 2)
Exit the program (option 3)
It keeps prompting until the user chooses to exit.
This is a simple command-line program using Hibernate for database operations like saving a new customer and checking login credentials.
