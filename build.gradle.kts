plugins {
    application
}

group = "registration"
version = "1.0"

application {
    mainClass.set("registration.Main")
}

// Allow input from the terminal when running ./gradlew run.
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

// Java 17 syntax and bytecode; the project also runs with JDK 21.
tasks.withType<JavaCompile>().configureEach {
    options.release.set(17)
    options.encoding = "UTF-8"
}
