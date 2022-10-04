# yape-booking-mobile-automation

Download and install android studio
https://developer.android.com/studio

Download and install nappium
https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4
https://github.com/appium/appium-inspector/releases (Optional)



Install adb
https://www.xda-developers.com/install-adb-windows-macos-linux/


1. Open “android studio/ Virtual Device Manager/ run emulator” (Or you can use physical device)
2. Turn on USB debugging and connect it to your computer.
3. Open terminal and run next command: “adb devices”

   You should see something like this:

   alexandergamarra@Alexanders-MacBook-Pro Android % adb devices
   List of devices attached
   emulator-5554	device

4. For install booking application
   Go to the /src/test/resources/apk/
   Copy “booking.apk” absolute path 	
   Go to your terminal and execute the follow command: adb install “absolute path {copied recently}” 		Example: 		alexandergamarra@Alexanders-MacBook-Pro Android % adb install /Users/alexandergamarra/Documents/Examén\ técnico/Desafio\ 2/	com.booking_v33.6.0.1-901292_Android-8.0.apk
   Performing Streamed Install
   Success

4. Open Appium Server GUI
   ->   Go to Advanced tab 	Server address: localhost 	Port: 4723 	Allow CORP: yes

   ->	Edit configurations, Set android_home and java_home variables

5. Download git repository
6. Run features
