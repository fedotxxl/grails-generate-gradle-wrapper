# grails-generate-gradle-wrapper
[gradle-grails-wrapper](https://github.com/ConnorWGarvey/gradle-grails-wrapper) project allows you to run Grails project without installed Grails. It may be usefull when your projects have different Grails version. To run Grails project by Gradle you should have `build.gradle` where you should specify same `grails.version` as application has.

This plugin adds `generate-gradle-wrapper` Grails command that creates `build.gradle` file for you.  To generate `build.gradle` file you should have any installed version of Grails. To run any Grails application from console:

1. Add plugin to your `BuildConfig.groovy` file
2. Run `grails generate-gradle-wrapper`
3. Run `gradle grails-run-app`

Check [gradle-grails-wrapper](https://github.com/ConnorWGarvey/gradle-grails-wrapper) documentation for more info