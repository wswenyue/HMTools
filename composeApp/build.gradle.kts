import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.zt.exec)
            implementation(libs.slf4j.api)
            implementation(libs.slf4j.simple)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.kotlinx.compose.ui)
            implementation(libs.kotlinx.compose.ui.desktop)
        }
    }
}


compose.desktop {
    application {
        mainClass = "vip.wswenyue.hmtools.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "HarmonyOSTools"
            packageVersion = "1.0.0"
            println("==>" + project.layout.projectDirectory.dir("resources"))
            appResourcesRootDir.set(project.layout.projectDirectory.dir("resources"))
        }
    }
}
