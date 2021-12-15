package com.example.intentassgn
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }


    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
    intent.data = Uri.parse("package:" + context.packageName)
    startActivity(intent)
}
fun createAlarm(message: String, hour: Int, minutes: Int) {
    val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
        putExtra(AlarmClock.EXTRA_MESSAGE, message)
        putExtra(AlarmClock.EXTRA_HOUR, hour)
        putExtra(AlarmClock.EXTRA_MINUTES, minutes)
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    }
}

