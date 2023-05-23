plugins {
    application
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

application {
    mainClass.set("Main")
}

sourceSets {
    main {
        java.srcDir("substring/src/main/java")
    }
    test {
        java.srcDir("substring/src/test/java")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}