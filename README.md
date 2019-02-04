# FUEL API EXAMPLE

### INTRODUCTION
Test to get data from my GitHub user repos. For it, I'm using **Fuel** a library for Android. This app is for Kotlin

Implementation library on **build.gradle** (Module:app)
```
implementation 'com.github.kittinunf.fuel:fuel-android:1.6.0'
```

It's very important to put in the **Manifest** the next permission
```
<uses-permission android:name="android.permission.INTERNET"/>
```

### MAIN ACTIVITY

In the **onCreate** method we add our base link where we will obtain the data, in these case, I use de api of GitHub
```
FuelManager.instance.basePath = "https://api.github.com"
```

To obtain the data, I create a new function that get the JSON, and I add the part that we want to collect (the missing part of the link in which the data we need is found)
```
fun httpGetJson(view: View) {  
    try {  
        progress!!.show()  
        Fuel.get("users/Jeluchu/repos").responseJson { _, _, result ->  
            tvGetResponse!!.text = result.get().content  
        }  
    } catch (e: Exception) {  
        tvGetResponse!!.text = e.message  
    } finally {  
        progress!!.dismiss()  
    }  
}
```
