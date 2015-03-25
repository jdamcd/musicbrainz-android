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

### Building with gradle

For building with gradle, follow the steps. Gradle wrapper downloads the
required gradle version and dependencies and builds the application.  For
reference, the gradle version used is 2.2.1.  For windows, replace ` ./gradlew `
with `./gradlew.bat`.

1. Install the Musicbrainz api jar to local maven repository using

        $ ./gradlew install

2. Now follow one of these in order to build the android application

  1. For building the android apk, installing it to emulator/device and to run instrumentation checks

            $ ./gradlew connectedAndroidTest

  2. For building the android apk and installing it to emulator/device :

            $ ./gradlew installDebug

  3. For building the android apk :

            $ ./gradlew build

3. To clean the build files :

        $ gradle clean

### Android Studio

Import project (gradle) and you are set.

(Tested with Android Studio 1.1.0 Build 135.1740770)

