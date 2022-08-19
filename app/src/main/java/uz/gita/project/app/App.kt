package uz.gita.project.app

import android.app.Application
import uz.gita.project.sharedPref.MySharedPref

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPref.init(this)
//        database ni init
    }
}