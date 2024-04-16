package fr.nextu.Michellon_theo

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import java.net.URL

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "fr.nextu.Michellon_theo.action.FOO"
private const val ACTION_BAZ = "fr.nextu.Michellon_theo.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "fr.nextu.Michellon_theo.extra.PARAM1"
private const val EXTRA_PARAM2 = "fr.nextu.Michellon_theo.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.

 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.

 */
class BeersService : IntentService("BeersService") {

    override fun onHandleIntent(intent: Intent?) {
        var url = URL("https://ror-next-u.onrender.com/beers.json");
        val co = url.openConnection();
        val result = co.getInputStream();

        Log.d("fr.nextu.myApp.BeerService", "Le cours est fini");
    }

    companion object {
        @JvmStatic
        fun startAction(context: Context) {
            val intent = Intent(context, BeersService::class.java)
            context.startService(intent)
        }
    }
}