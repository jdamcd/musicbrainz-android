## MusicBrainz Android

This is the official [MusicBrainz](http://www.musicbrainz.org) Android app. It was created as a Google Summer of Code project in 2010. Here is the [product page](http://musicbrainz.org/doc/MusicBrainz_for_Android).

**NOTE:** This project is not actively maintained, so updates are small and infrequent. 

### Download

Get the latest release from [Google Play](https://play.google.com/store/apps/details?id=org.musicbrainz.mobile).

## Licenses

Copyright © 2010-2013 Jamie McDonald. Licensed under the GNU General Public License Version 3.
ZXing barcode scanner integration code and miscellaneous helper classes are licensed under the Apache License, Version 2.

## Contributing

Please submit issues and feature requests on GitHub.

Code contributions are welcomed in the form of [pull requests](https://help.github.com/articles/using-pull-requests). Please use the following code formatting and style guidelines:

* Tabs are 4 spaces in Java code and 2 spaces in XML
* 120 character line width
* Use descriptive names and comment as a last resort

A code formatting configuration file is included in the repo.

### Building with Maven

If you have Maven 3, the Android SDK and an ```ANDROID_HOME``` environment variable, you can simply build with:

    $mvn clean install

This expects an Android device to be attached for running instrumentation tests. Alternatively, use the ```-DskipTests``` option.

### IntelliJ project setup

Import as existing Maven project. Just works.

### Can I skip all this Maven stuff?

Yes. However, you'll need to look at the dependencies in the POMs and go hunting for the dependencies yourself.

### Building with gradle

For building with gradle (checked with gradle v2.2.1), follow these steps:

1. Install the Musicbrainz api jar to local maven repository using

        $ gradle install

2. Now follow one of these in order to build the android application

  1. For building the android apk, installing it to emulator/device and to run instrumentation checks

            $ gradle connectedAndroidTest

  2. For building the android apk and installing it to emulator/device :

            $ gradle installDebug

  3. For building the android apk :

            $ gradle build

3. To clean the build files :

        $ gradle clean

4. Gradle build does not need paypal jar to be installed in local maven repository. But if still one needs to do it, run

        $ gradle publishToMavenLocal
