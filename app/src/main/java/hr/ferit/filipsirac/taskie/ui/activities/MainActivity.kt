package hr.ferit.brunozoric.taskie.ui.activities

import com.google.android.material.bottomnavigation.BottomNavigationView
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.ui.activities.base.BaseActivity
import hr.ferit.brunozoric.taskie.ui.fragments.AboutFragment
import hr.ferit.brunozoric.taskie.ui.fragments.TasksFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUi() {
        showFragment(TasksFragment.newInstance())
        bottomNavigation.setOnNavigationItemSelectedListener(this.navListener)
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_list -> {
                loadFragment(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_about -> {
                loadFragment(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
        }
        loadFragment(item.itemId)
        true
    }

    private fun loadFragment(itemId: Int) {
        val tag = itemId.toString()
        var fragment = supportFragmentManager.findFragmentByTag(tag) ?: when (itemId) {
            R.id.nav_list -> {
                TasksFragment.newInstance()
            }
            R.id.nav_about -> {
                AboutFragment.newInstance()
            }
            else -> {
                null
            }
        }

        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment, tag)
                .commit()
        }
    }

}