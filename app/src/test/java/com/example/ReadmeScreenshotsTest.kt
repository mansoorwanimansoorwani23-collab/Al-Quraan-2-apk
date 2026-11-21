package com.example

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel8, sdk = [36])
class ReadmeScreenshotsTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun capture_hidayah_readme_screenshots() {
        composeTestRule.mainClock.autoAdvance = false
        composeTestRule.mainClock.advanceTimeBy(1500L)

        // 1. Home Screen (Light / Default Liquid Glass Theme)
        composeTestRule.onRoot().captureRoboImage(filePath = "../docs/screenshots/01_home.png")

        // 2. Offline Quran Screen
        composeTestRule.onNodeWithTag("nav_item_quran").performClick()
        composeTestRule.mainClock.advanceTimeBy(1000L)
        composeTestRule.onRoot().captureRoboImage(filePath = "../docs/screenshots/02_quran.png")

        // 3. Prayer Times & Adhan Screen
        composeTestRule.onNodeWithTag("nav_item_prayer").performClick()
        composeTestRule.mainClock.advanceTimeBy(1000L)
        composeTestRule.onRoot().captureRoboImage(filePath = "../docs/screenshots/03_prayer.png")

        // 4. Hidayah AI (Multi-AI & Voice Messaging) Screen
        composeTestRule.onNodeWithTag("nav_item_ai_assistant").performClick()
        composeTestRule.mainClock.advanceTimeBy(1000L)
        composeTestRule.onRoot().captureRoboImage(filePath = "../docs/screenshots/04_hidayah_ai.png")

        // 5. "More" Left Sidebar Drawer with Urdu Guides
        composeTestRule.onNodeWithTag("dock_more_drawer_button").performClick()
        composeTestRule.mainClock.advanceTimeBy(1000L)
        composeTestRule.onRoot().captureRoboImage(filePath = "../docs/screenshots/05_more_drawer_urdu.png")

        // 6. Learn Salah Step-by-Step Guide Screen
        composeTestRule.onNodeWithTag("drawer_item_learn_salah").performClick()
        composeTestRule.mainClock.advanceTimeBy(1000L)
        composeTestRule.onRoot().captureRoboImage(filePath = "../docs/screenshots/06_learn_salah.png")
    }
}
