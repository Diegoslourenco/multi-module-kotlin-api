import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//buildscript {
//	repositories {
//		mavenCentral()
//	}
//
//	dependencies {
//		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
//		classpath("org.jetbrains.kotlin:kotlin-allopen:1.5.10")
//		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.5.1")
//	}
//}

plugins {
	id("org.springframework.boot") version "2.5.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.5.10"
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	kotlin("plugin.jpa") version "1.5.10"
}

group = "br.com.EmployeesApi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

extra["springVersion"] = "2.5.1"

repositories {
	mavenCentral()
}

tasks.bootJar {
	enabled = false
}



subprojects {
	group = "br.com.EmployeesApi"
	version = "0.0.1-SNAPSHOT"

	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-allopen")
	apply(plugin = "kotlin-jpa")

	repositories {
		mavenCentral()
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:${property("springVersion")}")
		}
	}

	dependencies {

		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

	allOpen {
//		annotation("org.springframework.stereotype.Component")
//		annotation("org.springframework.stereotype.Service")
//		annotation("org.springframework.stereotype.Repository")
		annotation("org.springframework.context.annotation.Configuration")
//		annotation("org.springframework.context.annotation.ComponentScan")

	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}


	tasks.withType<Test> {
		useJUnitPlatform()
	}

}


tasks.withType<Jar> {
	// Otherwise you'll get a "No main manifest attribute" error
	manifest {
		attributes["Main-Class"] = "br.com.employeesapi.EmployeesApiApplicationKt"
	}

	// To add all of the dependencies
	from(sourceSets.main.get().output)

	dependsOn(configurations.runtimeClasspath)
	from({
		configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
	})
}

/*
tasks.register<Jar>("uberJar") {
	archiveClassifier.set("uber")

	from(sourceSets.main.get().output)

	dependsOn(configurations.runtimeClasspath)
	from({
		configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
	})
}

 */

/*
tasks.withType<Jar> {
	manifest {
		attributes["Main-Class"] = "br.com.EmployeesApi.EmployeesApiApplicationKt"
	}

	configurations["compileClasspath"].forEach {
			file: File ->
		from(zipTree(file.absoluteFile))
	}


}
 */
