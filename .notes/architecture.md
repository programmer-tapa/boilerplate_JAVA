# Backend Architecture

The backend is structured as a Maven multi-module project to efficiently share code between different deployable contexts while preserving the independence of each application. 

## 1. Parent Module (`pom.xml`)
The parent POM orchestrates the build environment. It:
- Defines the standard `<properties>` (Java version, encodings).
- Maintains the `<dependencyManagement>` section, specifically for `spring-boot-dependencies`, ensuring version consistency across the workspace.
- Declares the `<modules>` that Maven should orchestrate when resolving dependencies.
 
## 2. Domain Module (`domain/`)
This is the core business logic and utility layer.
- **Purpose**: Exists purely as a library. Contains models, database entities, Data Transfer Objects (DTOs), and domain-level services (`SharedService`).
- **Configuration**: Uses a standard JAR packaging. It does *not* apply the `spring-boot-maven-plugin` execution step for building fat JARs, meaning it is safe to inject as a dependency elsewhere without Maven trying to make it an executable application.

## 3. Server Module (`server/`)
This is the primary HTTP interface.
- **Purpose**: Serves RESTful requests. Depends directly on the `domain` module for underlying data types and logic.
- **Configuration**: Uses `<packaging>jar</packaging>` and applies the `spring-boot-maven-plugin`. The `application.yml` spins up a Tomcat web server on port 8080.
- **Component Scan**: Uses standard scanning augmented to reach into `com.example.domain` to discover unified beans.

## 4. Worker Module (`worker/`)
This is the background processor.
- **Purpose**: Handles asynchronous tasks, scheduled jobs, listeners (e.g., Kafka, RabbitMQ) out-of-band to prevent slowing down the REST interface.
- **Configuration**: Applies the `spring-boot-maven-plugin`. The `application.yml` explicitly dictates `spring.main.web-application-type: none`, preventing Tomcat from booting. 
- **Benefits**: This module scales independently of web traffic, consuming minimal memory, and focuses purely on high-throughput backend workloads utilizing the exact same code models from `domain`.
