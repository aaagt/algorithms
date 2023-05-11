plugins {
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("Main")
}

sourceSets {
    main {
        java {
            srcDir("linked-stack/src/main/java")
        }
    }

    test {
        java {
            srcDir("linked-stack/src/test/java")
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}