package com.example.iceandfire.book.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.iceandfire.R
import com.example.iceandfire.book.presentation.view.BookFragment
import com.example.iceandfire.character.CharacterFragment
import com.example.iceandfire.databinding.ActivityIceAndFireBinding
import com.example.iceandfire.house.presentation.view.HouseFragment

class IceAndFireActivity : AppCompatActivity() {

    private val binding: ActivityIceAndFireBinding by lazy {
        ActivityIceAndFireBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNavigationView()
        setDefaultFragment(savedInstanceState)
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavIceAndFire.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_book -> {
                    loadFragment(BookFragment())
                    true
                }

                R.id.navigation_character -> {
                    loadFragment(CharacterFragment())
                    true
                }

                R.id.navigation_house -> {
                    loadFragment(HouseFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerIceAndFire, fragment)
            .commit()
    }

    private fun setDefaultFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.bottomNavIceAndFire.selectedItemId = R.id.navigation_book
        }
    }
}