plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

repositories {
	mavenCentral() // Ensure this is added
}

dependencies {
	// Spring Boot Web Starter
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Spring Data JPA Starter
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	// H2 Database for Runtime
	runtimeOnly("com.h2database:h2")

	// Jakarta Validation API
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
	implementation("org.glassfish:jakarta.el:4.0.2")

	// Lombok dependency
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")

	// Development Tools
	developmentOnly("org.springframework.boot:spring-boot-devtools")

    // encryption package
	implementation("org.springframework.boot:spring-boot-starter-security")

	//swagger
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	// Testing Dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.withType<Test> {
	useJUnitPlatform()
}
