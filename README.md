# yucel-demo

## Getting Started
### Clone the repository

First, clone the repository to your local machine:
```
git clone https://github.com/yuqu/yucel-demo.git
cd yucel-demo
```

### Build the Project

To build the project, run the following Maven command:
```
mvn clean install
```

This will download the necessary dependencies and build the application.
### Run the Application

To run the application locally, execute the following command:

```
mvn spring-boot:run
```

The application will start and will be accessible at http://localhost:8080.

### Insomnia API File

For easy testing of the application's endpoints, an Insomnia file is provided. You can import this file into Insomnia to test the API endpoints directly.

- Open Insomnia.
- Click on Import/Export in the top-right menu.
- Select Import Data and choose the .json Insomnia file located in the repository.
- The API requests will be imported, and you can start testing the endpoints.