package com.example.persistanbottom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var mBottomSheetLayout: ConstraintLayout
    private lateinit var mBottomSheetLayout2: ConstraintLayout
    private lateinit var sheetBehavior: BottomSheetBehavior<*>
    private lateinit var sheetBehavior2: BottomSheetBehavior<*>
    private var overlapSheet2 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBottomSheetLayout = findViewById(R.id.bottom_sheet_parent)
        mBottomSheetLayout2 = findViewById(R.id.bottom_sheet_parent1)
        sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout)
        sheetBehavior2 = BottomSheetBehavior.from(mBottomSheetLayout2)

        findViewById<AppCompatTextView>(R.id.txtBottomSheet1).setOnClickListener {
            showBottomSheet1()
        }

        findViewById<AppCompatTextView>(R.id.txtBottomSheet2).setOnClickListener {
            showBottomSheet2()
        }

        findViewById<AppCompatTextView>(R.id.txtOverlapBottomSheet).setOnClickListener {
            overlapBottomSheet()
        }
    }

    private fun showBottomSheet1() {
        if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        }
    }

    private fun showBottomSheet2() {
        if (sheetBehavior2.state != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior2.state = BottomSheetBehavior.STATE_EXPANDED
        } else {
            sheetBehavior2.setState(BottomSheetBehavior.STATE_COLLAPSED)
        }
    }

    private fun overlapBottomSheet() {
        overlapSheet2 = !overlapSheet2
        if (overlapSheet2) {
            mBottomSheetLayout.elevation = 30f
        } else {
            mBottomSheetLayout.elevation = 0f
        }
    }
}