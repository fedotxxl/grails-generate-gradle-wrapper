import org.codehaus.groovy.grails.cli.CommandLineHelper

target(generateGradleWrapper: "This script will generate build.gradle") {
    def propsFile = new File('application.properties')
    if (!propsFile.exists()) {
        println "ERROR: file application.properties is not found!"
        println "ERROR: can't generate build.gradle file!"
        return
    }

    def props = new Properties()
    propsFile.withInputStream {
        stream -> props.load(stream)
    }

    def version = props['app.grails.version']
    def content =
"""buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.connorgarvey.gradle:gradle-grails-wrapper:1.0'
    }
}

apply plugin: 'grails'

grails {
    version '${version}'
}"""

    def buildGradle = new File("build.gradle")
    if (buildGradle.exists()) {
        println "WARNING: you already have build.gradle file!"


        def inputHelper = new CommandLineHelper()
        def doReplace = inputHelper.userInput( "You already have build.gradle file. Replace it (whole content will be overwritten)?\n", ["y", "N"] as String[] )

        if (!doReplace.equalsIgnoreCase("y")) {
            println "WARNING: please manually paste following content into build.gradle file:"
            println ""
            println content
            return
        }
    }

    buildGradle.text = content
    println "build.gradle file is correctly created!"
    println "How to use gradle grails wrapper: https://github.com/ConnorWGarvey/gradle-grails-wrapper"
}

setDefaultTarget(generateGradleWrapper)
