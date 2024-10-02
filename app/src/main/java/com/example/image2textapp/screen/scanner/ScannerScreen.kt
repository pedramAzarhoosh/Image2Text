package com.example.image2textapp.screen.scanner

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.remember
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Composable
fun CameraScreen() {
    val context = LocalContext.current

    // State to control showing the camera and the photo
    var shouldShowCamera by remember { mutableStateOf(false) }
    var shouldShowPhoto by remember { mutableStateOf(false) }
    var photoUri by remember { mutableStateOf<Uri?>(null) }

    // Output directory and camera executor
    val outputDirectory = remember { getOutputDirectory(context) }
    val cameraExecutor: ExecutorService = remember { Executors.newSingleThreadExecutor() }

    // Permission launcher to request camera permission
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.i("kilo", "Permission granted")
            shouldShowCamera = true
        } else {
            Log.i("kilo", "Permission denied")
        }
    }

    // Request camera permission on composition start
    LaunchedEffect(Unit) {
        requestCameraPermission(context, requestPermissionLauncher, onPermissionGranted = {
            shouldShowCamera = true
        })
    }

    // Display CameraView if permission is granted and shouldShowCamera is true
    if (shouldShowCamera) {
        CameraView(
            outputDirectory = outputDirectory,
            executor = cameraExecutor,
            onImageCaptured = { uri ->
                handleImageCapture(uri, onCapture = { capturedUri ->
                    shouldShowCamera = false
                    photoUri = capturedUri
                    shouldShowPhoto = true
                })
            },
            onError = { Log.e("kilo", "View error:", it) }
        )
    }

    // Display the captured photo if available
    if (shouldShowPhoto && photoUri != null) {
        Image(
            painter = rememberImagePainter(photoUri),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

private fun getOutputDirectory(context: Context): File {
    val mediaDir = context.externalMediaDirs.firstOrNull()?.let {
        File(it, context.getString(R.strings.app_name)).apply { mkdirs() }
    }
    return if (mediaDir != null && mediaDir.exists()) mediaDir else context.filesDir
}

private fun requestCameraPermission(
    context: Context,
    requestPermissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    onPermissionGranted: () -> Unit
) {
    when {
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED -> {
            Log.i("kilo", "Permission previously granted")
            onPermissionGranted()
        }
        else -> {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }
}

private fun handleImageCapture(uri: Uri, onCapture: (Uri) -> Unit) {
    Log.i("kilo", "Image captured: $uri")
    onCapture(uri)
}



