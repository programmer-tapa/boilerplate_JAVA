# Running the Applications Layer

This guide explains how to compile the whole project using the parent project, and then execute individual modules locally.

## Prerequisite: Compile Full Solution
Before running applications, particularly `server` and `worker`, you must ensure that Maven copies the updated `domain` dependencies to your `.m2` user directory and properly installs it for dependent modules.

Inside the project root directory, execute:
```bash
./mvnw clean install
```
*Note: We utilize `./mvnw` instead of needing Maven globally installed, ensuring build consistency across Linux/Mac/Windows systems.*

---

## 1. Running the REST API

The API handles typical web-facing loads using a Tomcat webserver binding to port `8080`.

1. Open a new terminal tab and navigate into the `server` directory:
```bash
cd server
```
2. Leverage the spring-boot-maven-plugin to execute the class:
```bash
../mvnw spring-boot:run
```
3. Test the injected `SharedService` logic:
```bash
curl http://localhost:8080/hello
```
Expected output: `"API says: Hello from the Shared Module!"` (Note: Message comes from the service in the `domain` module).

---

## 2. Running the Asynchronous Worker

The worker ignores typical Tomcat port behaviors, deploying only scheduling execution threads or remote queue listeners in the fastest startup time possible.

1. Open another separate terminal tab and navigate into the `worker` directory:
```bash
cd worker
```
2. Execute the jar normally:
```bash
../mvnw spring-boot:run
```
The logs will instantly begin to poll the scheduled task (default is set to 5000 milliseconds) executing code pulled exclusively from the `domain` module without ever exposing port 8080 configurations.
