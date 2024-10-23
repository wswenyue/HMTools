package vip.wswenyue.hmtools

import java.io.File

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun getHdcExePath(): String {
        val fileName =
            if (System.getProperty("os.name").lowercase().contains("win")) "hdc.exe" else "hdc"
        val exeFile =
            File(System.getProperty("compose.application.resources.dir")).resolve(fileName)
        if (!exeFile.canExecute()) {
            println("没有执行权限，正在尝试赋予")
            exeFile.setExecutable(true)
        }
        return exeFile.absolutePath
    }
}