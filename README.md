## Sample Android MVVM Architecture Project using with Dagger2, Databinding, Retrofit, RxJava



**The New York Times Bestsellers Books App is a sample app based on MVVM pattern and implemented with android architecture components. It shows the latest bestsellers books fetched from NYTimes API.
It utilizes trending libraries such as Dagger2, Retrofit, RxJava2, Databinding, Picasso.**


## Structure

<p align="center">
  <img width="500" height="330" src="https://github.com/umutbayramoglu/mvvm-dagger2-databinding-retrofit-rxjava2/blob/master/screenshots/mvvm2.png?raw=true">
</p>


## Screenshots
<p align="center">
  <img src="https://github.com/umutbayramoglu/mvvm-dagger2-databinding-retrofit-rxjava2/blob/master/screenshots/ss11.jpg?raw=true" width="250">
  <img src="https://github.com/umutbayramoglu/mvvm-dagger2-databinding-retrofit-rxjava2/blob/master/screenshots/ss2.jpg?raw=true" width="250">

</p>

#### The app consists of following packages:
 1. **data**: It contains all the data accessing and manipulating components.
	 - **api:** makes api calls to server, using Retrofit. 
	 - **repo:** contains repository pattern classes to abstract the source of data.
2. **di**: contains Dagger2 classes -that a fast and lightweight dependency injection framework.
3. **ui**: activity, fragment classes and their corresponding viewmodels.
4. **utils**: utility classes.

#### Libraries and their functions:
* [Retrofit](https://square.github.io/retrofit/) handles API integration.
* [RxJava2](https://github.com/ReactiveX/RxJava) for implementing observable pattern.
* [Dagger 2](https://google.github.io/dagger/) provides dependency injection.
* [Databinding](https://developer.android.com/topic/libraries/data-binding/index.html) synchronizes UI for LiveData.
* [Gson](https://github.com/google/gson) provides serialisation.
* [Picasso](http://square.github.io/picasso/) handles image loading.
