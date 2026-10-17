# AyahBreak Android wrapper

This project wraps the currently hosted AyahBreak web prototype in an Android WebView and includes a GitHub Actions workflow that builds a debug APK.

## Important limitations

- This is a web wrapper, not a native digital-wellbeing blocker.
- An internet connection is required to load the hosted website and fetch remote Qur'anic content/fonts.
- The app currently uses the hosted URL in `MainActivity.kt`. If that URL changes, update `appUrl`.
- It does not yet use `UsageStatsManager`, Accessibility services, native scheduling, or native notifications to monitor/block other apps.
- The debug APK is for personal testing. A release APK should be properly signed before distribution.
- Review all permissions and app behavior before installing or sharing builds.

## Build APK using GitHub Actions (can be done from a phone)

1. Create a new GitHub repository named `AyahBreak-Android`.
2. Upload all files and folders from this project ZIP to the repository's `main` branch. Keep the `.github/workflows/build-apk.yml` path intact.
3. Open the repository's **Actions** tab and choose **Build AyahBreak APK**.
4. Tap **Run workflow** if it has not started automatically.
5. Wait for the workflow to finish successfully.
6. Open the completed workflow run and download the **AyahBreak-debug-apk** artifact.
7. Extract the downloaded artifact ZIP. It contains `app-debug.apk`.
8. Transfer/open `app-debug.apk` on your Android phone and install it. Android may ask you to allow installation from that source.

GitHub account and internet access are required for this build route. GitHub Actions availability and usage limits are controlled by GitHub.

## Build locally

Open this folder in Android Studio with Android SDK platform 35 installed, sync Gradle, then run **Build > Build APK(s)** or execute `gradle assembleDebug`.
