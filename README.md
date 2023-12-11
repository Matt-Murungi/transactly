# Transactly

A standalone  project showcasing an analytics dashboard for a mobile wallet
application. The mobile application is developed in Kotlin and Jetpack compose, and the API is developed in Python.

# Setup
1. Clone the project `https://github.com/Matt-Murungi/transactly.git`.

## Backend Setup
The backend can be setup either using docker or locally. NGROK will be utilised to expose the local server to the Internet.  

#### Docker
1. Navigate to the backend folder `cd backend`
2. Run `docker-compose up --build` to run the project on docker. 
3. To expose the local development server to the Internet, install [NGROK](https://ngrok.com/download) on your local machine.
4. Run `ngrok http 1337` on a separate terminal. 
5. Copy the url that appears in this format `https://e3bb-41-210-146-57.ngrok-free.app/`

#### Backend Setup (Run locally)
1. Navigate to the backend folder `cd backend`
2. Create and activate a virtualenv `` (feel free to use pipenv or virtualenv).
3. Install dependencies `pip install -r requirements.txt`
4. Run `python manage.py runserver` to run the project. 
5. To expose the local development server to the Internet, install [NGROK](https://ngrok.com/download) on your local machine.
6. Run `ngrok http 80` on a separate terminal. 
7. Copy the url that appears in this format `https://e3bb-41-210-146-57.ngrok-free.app/`



## Mobile Application Setup

1. Navigate to the mobile app folder `cd mobile_app`
2. Open the project in Android Studio
3. Build the project and make sure that the build is successful
4. Navigate to `app/src/main/java/com/example/myapplication/di/AppModule.kt` and paste the url copied from the backend in the `BASE_URL` variable. This allows the mobile application to fetch data from the backend.
5. Run the application either on your emulator or your device.

