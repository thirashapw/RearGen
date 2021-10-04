![N|Solid](https://i.imgur.com/q8pc6Oq.png)


![Build man](https://img.shields.io/badge/Release-Stable-red?style=for-the-badge&logo=appveyor) ![Build man](https://img.shields.io/badge/Build%20version-v1.7.1-green?style=for-the-badge&logo=appveyor) ![Build man](https://img.shields.io/github/repo-size/ThirashaPraween/RearGen?style=for-the-badge&logo=appveyor) ![Build man](https://img.shields.io/tokei/lines/github/ThirashaPraween/RearGen?style=for-the-badge) ![Build man](https://img.shields.io/github/last-commit/ThirashaPraween/RearGen?style=for-the-badge) ![Build man](https://img.shields.io/badge/Developer-ThirashaPW-blueviolet?style=for-the-badge&logo=appveyor)


# RearGen
Native based fast android apps developing framework with modern features.

- [Installation instructions](#Installation)
- [Start development](#start-development)
- [Run a hosted app](#run-a-hosted-app)
- [Build a new app with HTML/CSS/JS](#build-a-new-app-with-html-css-js)
- [What is fornyKit?](#what-is-fornykit)
- [Live testing](#live-testing)
- [Recollecting](#recollecting)
- [Zeal Animator support](#zeal-animator-support)
- [Custom CSS or JS libraries support](#custom-css-or-js-libraries-support)
- [Use clean file](#use-clean-file)
- [Report a issue](https://discord.gg/ymyQntskxj)
- [Buy premium a key](#buy-premium-a-key)
- [Support to this project](https://www.buymeacoffee.com/thirashapraween)

We have released stable releases of the RearGen. RearGen is depends on JAVA and gradle. To run this application you have to install Java JDK. Compiler written in Python. There are several features added to this framework than [RWAD](https://github.com/ThirashaPraween/RWAD-React-Native-Web-App-Dev).

Try RearGen sample app on PlayStore

[![RearGen](https://i.imgur.com/Uq6TQOy.png)](https://play.google.com/store/apps/details?id=tpw.creator.reargen)




## Features
- Python Runner Supported (LTS)
- No more NodeJS and React Native back-end.
- Running with native code base
- Fast and easy
- Build less than 5MB app
- More customisation
- Connection lost window
- Refresh facility
- No more SSL bypass
- High quality rendering
- Develop mobile app with HTML / CSS / JavaScript
- Generating support
- Live testing
- Live installing
- Recollecting feature
- Full debugging details
- [Zeal Animator](https://thirashapraween.github.io/Zeal-Animator) supported
- Custom CSS and JavaScript libraries supported

<br>
<p align="center">
  <a href="https://www.buymeacoffee.com/thirashapraween">
      <img src="https://camo.githubusercontent.com/2ef5c63105d22716d9d093d2c8b77cd7aa9d540b/68747470733a2f2f63646e2e6275796d6561636f666665652e636f6d2f627574746f6e732f76322f64656661756c742d79656c6c6f772e706e67" height="50px"/>
  </a>
   <a href="https://www.patreon.com/thirasha">
      <img src="https://le-cdn.website-editor.net/05ce6571223a491289ae62de7892c2dd/dms3rep/multi/opt/Patreon-Button-2880w.png" height="50px"/>
  </a>
</p>

## Installation
First you have to download latest [release](https://github.com/ThirashaPraween/RearGen/releases) or LTS [release](https://github.com/ThirashaPraween/RearGen/releases) from the github or clone the repo.
After that, install supported [JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) or [JDK 16](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html) to your computer. then, follow the [start development](#start-development) instructions.

## Start Development
Run ```RearGen.exe``` or head your command line to RearGen directory then type ```RearGen``` and run it.

##### Development Stages
All stages have their default values. you can skip those by pressing ```Enter``` key.

**App Name** - Enter a app name you want to identify the app (Ex: My App).

**App developer single name** - Enter your name as developer name (Ex: john).

**App single organization** - Organization name (Ex: reargen).

**Load URL or dismiss to connect src** - If you are going to build a new in app developement (not hosted url app). you have to copy and paste your source code to ```src``` folder. if not, you have to paste the hosted web url here (Ex for hosted URl: https://www.google.lk) (Ex for in app development: (dismiss by pressing ```Enter``` key)).

**Allow loading screen** - To allow loading screen while your app screen changes.

**Allow refresh button** - To allow refresh button to your app. it will available in top middle of the app. users can pull the button to refresh.(This is native standard app component).

**Allow loading screen image** - Add image/logo to app loading screen.

**Enable status bar transparent** - Allow transparent status bar with full screen.

**Enable full screen** - Remove statusbar visibility and set the full screen app.

**Loading bar color** - Add loading progress bar [color](https://htmlcolorcodes.com/color-picker/) (Ex: #AF320E)

**App primary color** - Set app main [color](https://htmlcolorcodes.com/color-picker/). It will apply to the status bar and other native areas. (Ex: #CEC8C6)

**App secondary color** - Set app secondary [color](https://htmlcolorcodes.com/color-picker/). It will apply to scroll end sections in the app.

**App logo .png path** - Add app logo path. **This image must be ```png``` format and less than 250x250 pixels**.

**Splash image .png path** - Add image to splash screen and loading screen. **This image must be ```png``` format**.

Well, you have done app details section. Next it will gives you app details that you have entered previously. Check those are correct and then type ```y``` to confirm details. or not press ```n``` to grab those again.

if you entered ```y``` it will generate the source code and ask you **Bundle / APK / Test / ReCollect (b/a/t/r):** 
if you want a bundle press ```b```, apk press ```a```, install app to connected device or emulator ```t``` (to run connected device. please [setup](https://guides.codepath.com/android/Running-Apps-on-Your-Device) your device) and press ```r``` to recollect app details.

## Run a hosted app
First follow the [development instructions](#start-development). then the stage of **Load URL or dismiss to connect src:** you have to enter the hosted app or website URL


## Build a new app with HTML CSS JS
First develop your app or website in the ```src``` folder. you can use any css and js libaries. **(```src``` folder must be include ```index.html``` file)**. after that follow the [development instructions](#start-development). then the stage of **Load URL or dismiss to connect src:** dismiss the stage by pressing ```Enter``` key. it will automatically connected to ```src``` folder.

## What is fornyKit?
![N|Solid](https://i.imgur.com/brTmrW7.png)\
RearGen does not come with mobile-responsive components. So fornyKit is also known as RearGen Material Kit handles HTML elements as android responsive components. Try [fornyKit](https://github.com/ThirashaPraween/fornyKit) to your RearGen project.


## Live testing
First follow the [development instructions](#start-development). after that the stage of **Bundle / APK / Test / ReCollect (b/a/t/r):**. press ```t``` to test the app on emulator or [physical device](https://guides.codepath.com/android/Running-Apps-on-Your-Device).


## Recollecting
First follow the [development instructions](#start-development). after that the stage of **Bundle / APK / Test / ReCollect (b/a/t/r):**. press ```r``` to recollect again the details of app.


## Zeal Animator support
Go to [Zeal Animator](https://thirashapraween.github.io/Zeal-Animator/Doc.html) website documentation and copy the CDN url. after that, paste it into your ```src/index.html``` file and any other files.


## Custom CSS or JS libraries support
Copy the library CDN url. Then, paste it into your ```src/index.html``` file and any other html files. or install the library to ```src``` folder.


## Use clean file
You can see ```clean.bat``` file in the root folder. If you have any trouble or unknown error, first try to run the ```clean.bat``` files. and again compile your project. If not fixed, copy the error and find solution through the internet.


## Buy premium a key
You need to support this product. To support and request a premium key, Contact me via email contact@thirashapw.com to get a life time unlimited apps generating premium key.



Thank you for using RearGen!
