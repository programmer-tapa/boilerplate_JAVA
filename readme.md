# Java Backend Multi-Module Project

Welcome to the Spring Boot multi-module Java boilerplate repository. This project is structured as a Maven monorepo with multiple submodules to promote code reuse while keeping execution environments separate.

## Directory Guide

- `.notes/architecture.md`: Describes the multi-module setup and the purpose behind `server`, `worker`, and `domain` modules.
- `.notes/running-apps.md`: Provides instructions on how to compile, verify, and run each application locally.

## Project Structure & Submodules

The project utilizes a Maven multi-module architecture built on Java 17+ and Spring Boot 3.x:
1. **domain** (Submodule): A library module containing shared business logic, models, database entities, and core services (like `SharedService`) reused across applications.
2. **server** (Submodule): An executable Spring Boot web application serving REST APIs. It depends on the `domain` module.
3. **worker** (Submodule): An executable Spring Boot background processor and scheduler. It depends on the `domain` module.

## 🧪 API Verification & Testing

Here are some sample `curl` requests to verify and test the calculator endpoints:

### 1. Valid Addition Endpoint
- **Request:**
  ```bash
  curl -i -X POST -H "Content-Type: application/json" -d '{"a": 2, "b": 3}' http://127.0.0.1:8080/calculator/add
  ```
- **Result:** Successfully returned `200 OK` with:
  ```json
  {"status":"success","data":{"result":5},"message":null,"errorCode":null}
  ```

### 2. Negative Number Validation
- **Request:**
  ```bash
  curl -i -X POST -H "Content-Type: application/json" -d '{"a": -2, "b": 3}' http://127.0.0.1:8080/calculator/add
  ```
- **Result:** Properly returned `400 Bad Request` with:
  ```json
  {"status":"error","data":null,"message":"Number cannot be negative: -2","errorCode":"400"}
  ```

### 3. Division By Zero Validation
- **Request:**
  ```bash
  curl -i -X POST -H "Content-Type: application/json" -d '{"a": 10.0, "b": 0.0}' http://127.0.0.1:8080/calculator/divide
  ```
- **Result:** Properly returned `400 Bad Request` with:
  ```json
  {"status":"error","data":null,"message":"Division by zero is not allowed","errorCode":"400"}
  ```


