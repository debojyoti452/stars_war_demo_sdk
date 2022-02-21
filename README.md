# StarWars SDK

[![](https://jitpack.io/v/debojyoti452/stars_war_demo_sdk.svg)](https://jitpack.io/#debojyoti452/stars_war_demo_sdk)

StarWars SDK integrates can be used to get Planet, People, & Films list of Star Wars.
## Installation
#### Project Root Level Gradle
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
## OR
#### settings.gradle Level Gradle
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
```
#### App Level Gradle
```gradle
dependencies {
	 implementation 'com.github.debojyoti452:stars_war_demo_sdk:${version}'
}
```
## APIs
- Response has three Types
 ```kotlin
        -> Response.Success // will return success model. Typed Request Model will be returned.
        -> Response.Error   // will return if any error found. String message will be returned.
        -> Response.Loading // will return Loading State. Show any progress dialog.
 ```
 - People & Planet Model
 ```kotlin
        -> getEyeColors() // is prebuilt function available in People Model which will return an List<eyecolor: String?>? of first 5 people.
        -> getFiveClimateAndPopulation() // is prebuilt function available in Planet Model which will return an List<Pair<climate: String?, population: String?>>? of first 5 planets.
 ```
## Integrations
- Initiate StarWars SDK
 ```kotlin
        private val initiateStarWars: StarWars by lazy {
            StarWars.Builder()
                .setContext(requireContext())
                .create()
        }
 ```
* #### To get All People
 ```kotlin
        initiateStarWars.getPeople(peopleOnResponseListener)
 ```
* #### People OnResponseListener
 ```kotlin
        private val peopleOnResponseListener = object : ResponseOnListener<Response<People>> {
        	override fun onResult(result: Response<People>) {
            		when (result) {
				is Response.Success -> {
				    _loading.postValue(false)
				    _peopleEyeData.postValue(result.data.getEyeColors())
				}

				is Response.Error -> {
				    _loading.postValue(false)
				    _errorMessage.postValue(Pair(true, result.exception.toString()))
				}

				is Response.Loading -> {
				    _loading.postValue(true)
				}
            	}
        }
    }
 ```
* ####  To get All Planet
 ```kotlin
        initiateStarWars.getPlanets(planetOnResponseListener)
 ```
* ####  Planet OnResponseListener
 ```kotlin
        private val planetOnResponseListener = object : ResponseOnListener<Response<Planet>> {
        	override fun onResult(result: Response<Planet>) {
		    when (result) {
			is Response.Success -> {
			    _loading.postValue(false)
			    _populationData.postValue(result.data.getFiveClimateAndPopulation())
			}

			is Response.Error -> {
			    _loading.postValue(false)
			    _errorMessage.postValue(Pair(true, result.exception.toString()))
			}

			is Response.Loading -> {
			    _loading.postValue(true)
			}
		}
        }
    }
 ```
* #### To get All Films
 ```kotlin
        initiateStarWars.getFilm(filmOnResponseListener)
 ```
* #### Film OnResponseListener
 ```kotlin
    private val filmOnResponseListener = object : ResponseOnListener<Response<Film>> {
        override fun onResult(result: Response<Film>) {
            when (result) {
                is Response.Success -> {
                    _filmData.postValue(result.data.dataList)
                    _loading.postValue(false)
                }

                is Response.Error -> {
                    _loading.postValue(false)
                    _errorMessage.postValue(Pair(true, result.exception.toString()))
                }

                is Response.Loading -> {
                    _loading.postValue(true)
                }
            }
        }
    }
 ```

## IMPORTANT NOTES
* ### If you're using MVC or MVP architecture or Java without Viewmodel then you need to use it like this:

    ```kotlin
        starWars.getPlanets(planetResponse -> {
                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TEST:: ", planetResponse.toString());
                    }
                });
        });
    ```
* ### If you're using MVVM make sure to use postValue() instead setValue():
    ```kotlin
        is Response.Success -> {
            _loading.postValue(false)
            _populationData.postValue(result.data.getFiveClimateAndPopulation())
        }
        
        is Response.Error -> {
            _loading.postValue(false)
            _errorMessage.postValue(Pair(true, result.exception.toString()))
        }
        
        is Response.Loading -> {
            _loading.postValue(true)
        }
    ```
## Known Bugs
 - ResponseListener's data is in BackgroundThread and need to transfer to uiThread by Viewmodel or runOnUiThread() methods. Will fix it in Kotlin Coroutines.

## ScreenShots
<p float="left">
  <img src="https://github.com/debojyoti452/stars_war_demo_sdk/blob/main/screenshots/Screenshot_1645432356.png" width="300" />
  <img src="https://github.com/debojyoti452/stars_war_demo_sdk/blob/main/screenshots/Screenshot_1645432443.png" width="300" /> 
  <img src="https://github.com/debojyoti452/stars_war_demo_sdk/blob/main/screenshots/Screenshot_1645432455.png" width="300" />
  <img src="https://github.com/debojyoti452/stars_war_demo_sdk/blob/main/screenshots/Screenshot_1645432574.png" width="300" />
</p>


## Open Source Plugins used
| Library | README |
| ------ | ------ |
| Retrofit | [https://square.github.io/retrofit/] |
| Kotlin Coroutines | [https://kotlinlang.org/docs/coroutines-overview.html] |
| GSON Serializer | [https://github.com/google/gson] |
| Mockk | [https://mockk.io/] |
| Android STD Libs | [https://developer.android.com/kotlin/first] |
