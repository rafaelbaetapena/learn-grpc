import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*

plugins {
    id("java")
    id("com.google.protobuf") version "0.8.14"
    kotlin("jvm") version "1.4.20"
    id("idea")
}

group = "com.rafaelbaetapena"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.13.0"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.32.1"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:0.2.1:jdk7@jar"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}

dependencies {
    implementation("io.grpc:grpc-kotlin-stub:0.2.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    runtimeOnly("io.grpc:grpc-netty:1.32.1")

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

// if you have source imports issues, add the below
sourceSets.main {
    java.srcDirs(buildDir, "generated/source")
    idea {
        module {
            // Marks the already(!) added srcDir as "generated"
            generatedSourceDirs.plusAssign(file("build/generated/source"))
        }
    }
}