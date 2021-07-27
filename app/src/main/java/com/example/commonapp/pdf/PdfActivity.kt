package com.example.commonapp.pdf

import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commitNow
import com.example.commonapp.R

class PdfActivity : AppCompatActivity(R.layout.activity_pdf) {
    companion object {
        const val FRAGMENT_INFO = "info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState==null){
            supportFragmentManager.commitNow {
                replace(R.id.container, PdfRenderFragment())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info -> {
                InfoFragment().show(supportFragmentManager, FRAGMENT_INFO)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    class InfoFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return AlertDialog.Builder(requireContext())
                .setMessage(R.string.intro_message)
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
    }
}