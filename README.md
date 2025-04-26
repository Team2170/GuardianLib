# Galvanized Guardians Library

A customized library for [Team 2170](https://github.com/Team2170) containing much simplification for our year-to-year robot code. Allows the team to get up and running quickly at the beginning of the year.

# How do I use GuardianLib?

## Setting up GuardianLib

### Step 0. This is done by default for robot projects, but if your doing a local project you must remember to include this at the top
```gradle
plugins {
    id "java"
    
    // You can use different versions of GradleRIO between your robot
    // code and GuardianLib as long as the updates don't break anything
    id "edu.wpi.first.GradleRIO" version "2025.3.2"
}
```

### Step 1. Add the JitPack repository to your `build.gradle`

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2. Add the dependency to `build.gradle`
 
 Version: [![Jitpack Website](https://jitpack.io/v/Team2170/GuardianLib.svg)](https://jitpack.io/#Team2170/GuardianLib)
```gradle
dependencies {
    // check tag above for most recent version
    implementation 'com.github.Team2170:GuardianLib:VERSION'
}
```

### Step 3. Build the project

```dos
./gradlew build
```

### Step 4. Import the neccessary module into your project

```java
import GuardianLib.*;
```

## Known Errors

### The 'import com.GalvanizedGuardians' cannot be resolved

Try closing and reopening your IDE.

## For all other errors, please open a issue or contact us directly
