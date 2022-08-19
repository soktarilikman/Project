package uz.gita.project.sharedPref

import android.content.Context

class MySharedPref private constructor(context: Context) {
    private val sharedPref = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    private val editor = sharedPref.edit()

    fun isIntroOne(): Boolean = sharedPref.getBoolean(IS_FIRST, false)

    fun setIntroOne() {
        editor.putBoolean(IS_FIRST, true)
        editor.apply()
    }


    companion object {
        private const val SHARED_NAME = "app_data"
        private const val IS_FIRST = "is_first"
        private lateinit var instance: MySharedPref

        fun init(context: Context) {
            if (!Companion::instance.isInitialized) {
                instance = MySharedPref(context)
            }
        }

        fun getSharedPref(): MySharedPref {
            return instance
        }

    }

}