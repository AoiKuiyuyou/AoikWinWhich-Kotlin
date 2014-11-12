# AoikWinWhich-Kotlin
[AoikWinWhich](https://github.com/AoiKuiyuyou/AoikWinWhich) written in Kotlin.

Kotlin: 0.9.66

## Contents
- [How to install](#how-to-install)
- [How to use](#how-to-use)

## How to install
Clone the repo to local.

## How to use
Download Kotlin's compiler **kotlinc** from [here](http://kotlinlang.org/docs/tutorials/command-line.html)

Go to the local repo dir of AoikWinWhich-Kotlin.

The program entry file is [src/aoikwinwhich/AoikWinWhich.kt](/src/aoikwinwhich/AoikWinWhich.kt).

Use kotlinc to compile.
```
SET KOTLINC_DIR=<put your value here>
%KOTLINC_DIR%\bin\kotlinc -include-runtime src\aoikwinwhich\AoikWinWhich.kt -d build\AoikWinWhich.jar
```
- ```KOTLINC_DIR``` means where kotlinc's root dir is located.
- ```-include-runtime``` means include Kotlin's runtime libs in the result jar.  
  Doing so you do not need to add Kotlin's runtime libs to classpath when running your program.
- ```-d build\AoikWinWhich.jar``` means put result jar file in **build** dir.  
  The dir must be created beforehand.

Use java to run.
```
java -jar build\AoikWinWhich.jar
```

See [here](https://github.com/AoiKuiyuyou/AoikWinWhich#how-to-use) for more usage and [AoikWinWhich](https://github.com/AoiKuiyuyou/AoikWinWhich) for more info.
